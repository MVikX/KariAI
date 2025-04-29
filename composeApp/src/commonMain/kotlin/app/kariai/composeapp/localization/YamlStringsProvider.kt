package app.kariai.composeapp.localization

import net.mamoe.yamlkt.Yaml
import net.mamoe.yamlkt.YamlMap
import net.mamoe.yamlkt.YamlPrimitive

class YamlStringsProvider(
    private val flatMap: Map<String, String>
) : StringsProvider {

    override fun get(key: String): String {
        return flatMap[key] ?: "[missing:$key]"
    }

    companion object {
        fun fromYamlText(text: String): YamlStringsProvider {
            val yaml = Yaml.Default
            val root: YamlMap = yaml.decodeYamlMapFromString(text)
            val flatMap = flatten(root)
            return YamlStringsProvider(flatMap)
        }

        private fun flatten(yamlMap: YamlMap, prefix: String = ""): Map<String, String> {
            val result = mutableMapOf<String, String>()
            for ((key, value) in yamlMap) {
                val keyStr = (key as? YamlPrimitive)?.content ?: "unknown"
                val fullKey = if (prefix.isEmpty()) keyStr else "$prefix.$keyStr"

                when (value) {
                    is YamlPrimitive -> {
                        result[fullKey] = value.content ?: "[null]"
                    }
                    is YamlMap -> {
                        result.putAll(flatten(value, fullKey))
                    }
                    else -> {
                        // для логов
                    }
                }
            }
            return result
        }
    }
}