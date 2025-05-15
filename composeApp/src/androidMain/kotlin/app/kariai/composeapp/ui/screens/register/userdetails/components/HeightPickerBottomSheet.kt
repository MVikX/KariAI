package app.kariai.composeapp.ui.screens.register.userdetails.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import app.kariai.composeapp.localization.t
import app.kariai.composeapp.resources.NutriTheme
import app.kariai.composeapp.components.common.button.GradientButton

private val DialogBackgroundAlpha = 0.7f

private val DialogCornerRadius = 24.dp
private val DialogWidth = 300.dp
private val DialogPadding = 24.dp
private val DialogTextBottomPadding = 16.dp

private val WheelPickerHeight = 250.dp
private val ConfirmButtonWidth = 180.dp
private val ConfirmButtonHeight = 48.dp

private val HeightRangeStart = 120
private val HeightRangeEnd = 230

private val HeightSpacer = 24.dp

@Composable
actual fun HeightPickerBottomSheet(
    initialHeight: Int,
    onConfirm: (Int) -> Unit,
    onDismiss: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false,
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
                    var selectedHeight by remember { mutableStateOf(initialHeight) }

                    Column(
                        modifier = Modifier.padding(DialogPadding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = t("profile.choose_height"),
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(bottom = DialogTextBottomPadding)
                        )

                        Box(
                            modifier = Modifier.height(WheelPickerHeight),
                            contentAlignment = Alignment.Center
                        ) {
                            WheelPicker(
                                items = (HeightRangeStart..HeightRangeEnd).toList(),
                                selected = selectedHeight,
                                onSelected = { selectedHeight = it }
                            )
                        }

                        Spacer(modifier = Modifier.height(HeightSpacer))

                        GradientButton(
                            text = t("common.confirm"),
                            onClick = {
                                onConfirm(selectedHeight)
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