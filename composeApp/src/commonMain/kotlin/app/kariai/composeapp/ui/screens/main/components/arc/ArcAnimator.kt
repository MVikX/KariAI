package app.kariai.composeapp.ui.screens.main.components.arc

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

// animation configuration constants
private const val AnimationDurationMillis = 1000
private const val MinArcProgress = 0f
private const val MaxArcProgress = 1f
private const val InitialSweepValue = 0f

class ArcAnimators(
    val spentSweep: Animatable<Float, *>,
    val burnedSweep: Animatable<Float, *>,
) {
    suspend fun animate(
        spentKcal: Int,
        maxSpentKcal: Int,
        burnedKcal: Int,
        maxBurnedKcal: Int,
        maxArcAngle: Float
    ) = coroutineScope {
        launch {
            spentSweep.animateTo(
                targetValue = (spentKcal / maxSpentKcal.toFloat()).coerceIn(MinArcProgress, MaxArcProgress) * maxArcAngle,
                animationSpec = tween(AnimationDurationMillis, easing = FastOutSlowInEasing)
            )
        }
        launch {
            burnedSweep.animateTo(
                targetValue = (burnedKcal / maxBurnedKcal.toFloat()).coerceIn(MinArcProgress, MaxArcProgress) * maxArcAngle,
                animationSpec = tween(AnimationDurationMillis, easing = FastOutSlowInEasing)
            )
        }
    }
}

@Composable
fun rememberInfinityArcAnimators(): ArcAnimators {
    return remember {
        ArcAnimators(
            spentSweep = Animatable(InitialSweepValue),
            burnedSweep = Animatable(InitialSweepValue)
        )
    }
}