package app.kariai.composeapp.ui.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import app.kariai.composeapp.localization.t

@Composable
fun buildPrivacyText(): AnnotatedString {
    return buildAnnotatedString {
        append(t("legal.terms_accept_prefix"))
        append(" ")

        pushStringAnnotation(tag = "TERMS", annotation = "terms")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append(t("legal.terms_link"))
        }
        pop()

        append(" ")
        append(t("common.and"))
        append(" ")

        pushStringAnnotation(tag = "PRIVACY", annotation = "privacy")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append(t("legal.privacy_link"))
        }
        pop()
    }
}