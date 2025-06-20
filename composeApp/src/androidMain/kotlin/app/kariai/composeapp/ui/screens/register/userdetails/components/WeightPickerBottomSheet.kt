package app.kariai.composeapp.ui.screens.register.userdetails.components
//TODO ADD TRANSLITERATOR
import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog
import app.kariai.composeapp.components.common.button.GradientButton

import androidx.compose.ui.window.DialogProperties
import app.kariai.composeapp.localization.t
import app.kariai.composeapp.resources.NutriTheme

//UI
private val DialogBackgroundAlpha = 0.7f
private val DialogCornerRadius = 24.dp
private val DialogWidth = 300.dp
private val DialogPadding = 24.dp
private val DialogTextBottomPadding = 16.dp
private val PickerRowHeight = 250.dp
private val PickerSpacing = 8.dp
private val ConfirmButtonWidth = 180.dp
private val ConfirmButtonHeight = 48.dp
private val HeightSpacer = 24.dp

//Weight
private const val WeightMin = 30
private const val WeightMax = 200
private const val WeightDecimalMin = 0
private const val WeightDecimalMax = 9


@Composable
actual fun WeightPickerBottomSheet(
    initialWeight: Double,
    onConfirm: (Double) -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        )
    ) {
        NutriTheme {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = DialogBackgroundAlpha)),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(DialogCornerRadius),
                    color = MaterialTheme.colorScheme.surface,
                    modifier = Modifier
                        .width(DialogWidth)
                        .wrapContentHeight()
                ) {
                    var selectedWhole by remember { mutableStateOf(initialWeight.toInt()) }
                    var selectedDecimal by remember { mutableStateOf(((initialWeight * 10) % 10).toInt()) }

                    Column(
                        modifier = Modifier.padding(DialogPadding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = t("profile.choose_weight"),
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(bottom = DialogTextBottomPadding)
                        )

                        Row(
                            modifier = Modifier.height(PickerRowHeight),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            WheelPicker(
                                items = (WeightMin..WeightMax).toList(),
                                selected = selectedWhole,
                                onSelected = { selectedWhole = it }
                            )
                            Spacer(modifier = Modifier.width(PickerSpacing))
                            WheelPicker(
                                items = (WeightDecimalMin..WeightDecimalMax).toList(),
                                selected = selectedDecimal,
                                onSelected = { selectedDecimal = it }
                            )
                        }

                        Spacer(modifier = Modifier.height(HeightSpacer))

                        GradientButton(
                            text = t("common.confirm"),
                            onClick = {
                                val result = selectedWhole + (selectedDecimal / 10.0)
                                onConfirm(result)
                                onDismiss()
                            },
                            modifier = Modifier
                                .width(ConfirmButtonWidth)
                                .height(ConfirmButtonHeight)
                        )
                    }
                }
            }
        }
    }
}