package app.kariai.composeapp.ui.screens.register.userdetails.components
//TODO ДОБАВИТЬ ТРАНСЛИТОР
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
                    .background(Color.Black.copy(alpha = 0.7f)),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    color = MaterialTheme.colorScheme.surface,
                    modifier = Modifier
                        .width(300.dp)
                        .wrapContentHeight()
                ) {
                    var selectedWhole by remember { mutableStateOf(initialWeight.toInt()) }
                    var selectedDecimal by remember { mutableStateOf(((initialWeight * 10) % 10).toInt()) }

                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = t("profile.choose_weight"),
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        Row(
                            modifier = Modifier.height(250.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            WheelPicker(
                                items = (30..200).toList(),
                                selected = selectedWhole,
                                onSelected = { selectedWhole = it }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            WheelPicker(
                                items = (0..9).toList(),
                                selected = selectedDecimal,
                                onSelected = { selectedDecimal = it }
                            )
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        GradientButton(
                            text = t("common.confirm"),
                            onClick = {
                                val result = selectedWhole + (selectedDecimal / 10.0)
                                onConfirm(result)
                                onDismiss()
                            },
                            modifier = Modifier
                                .width(180.dp)
                                .height(48.dp)
                        )
                    }
                }
            }
        }
    }
}