package app.kariai.composeapp.ui.screens.main.components.arc
//TODO automation required in calorie numbers (constants)
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.kariai.composeapp.localization.t

//TODO implement automatic counter
const val maxSpentKcal = 3000
const val maxBurnedKcal = 3000

@Composable
fun InfinityProgressArc(
    spentKcal: Int,
    burnedKcal: Int,
    modifier: Modifier = Modifier,
    arcSize: Dp = 260.dp,
    onClick: ((Offset) -> Unit)? = null
) {
    val maxArcAngle = 345f
    val fadeAngle = 30f

    val animators = rememberInfinityArcAnimators()

    LaunchedEffect(spentKcal, burnedKcal) {
        animators.animate(
            spentKcal,
            maxSpentKcal,
            burnedKcal,
            maxBurnedKcal,
            maxArcAngle
        )
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(arcSize)
            .pointerInput(onClick) {
                onClick?.let { safeClick ->
                    detectTapGestures { offset -> safeClick(offset) }
                }
            },
        contentAlignment = Alignment.Center
    ) {

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawInfinityArc(
                spentSweep = animators.spentSweep.value,
                burnedSweep = animators.burnedSweep.value,
                fadeAngle = fadeAngle,
                maxArcAngle = maxArcAngle,
                size = size
            )
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(t("main_screen_arc.spent"), fontSize = 14.sp, color = Color.White)
                    Text("$spentKcal", fontSize = 26.sp, color = Color.White)
                    Text(t("small_all_wards.kcal"), fontSize = 14.sp, color = Color.White)
                }
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(t("main_screen_arc.burned"), fontSize = 14.sp, color = Color.White)
                    Text("$burnedKcal", fontSize = 26.sp, color = Color.White)
                    Text(t("small_all_wards.kcal"), fontSize = 14.sp, color = Color.White)
                }
            }
        }
    }
}