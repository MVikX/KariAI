package org.example.kariai.ui.screens.main.components.arc

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

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
                targetValue = (spentKcal / maxSpentKcal.toFloat()).coerceIn(0f, 1f) * maxArcAngle,
                animationSpec = tween(1000, easing = FastOutSlowInEasing)
            )
        }
        launch {
            burnedSweep.animateTo(
                targetValue = (burnedKcal / maxBurnedKcal.toFloat()).coerceIn(0f, 1f) * maxArcAngle,
                animationSpec = tween(1000, easing = FastOutSlowInEasing)
            )
        }
    }
}

@Composable
fun rememberInfinityArcAnimators(): ArcAnimators {
    return remember {
        ArcAnimators(
            spentSweep = Animatable(0f),
            burnedSweep = Animatable(0f)
        )
    }
}