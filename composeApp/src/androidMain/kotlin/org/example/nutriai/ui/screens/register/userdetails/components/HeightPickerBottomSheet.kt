package org.example.nutriai.ui.screens.register.userdetails.components

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
import localization.t
import org.example.nutriai.resources.NutriTheme
import org.example.nutriai.ui.components.common.button.GradientButton

@Composable
actual fun HeightPickerBottomSheet(
    initialHeight: Int,
    onConfirm: (Int) -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        )
    ) {
        NutriTheme(darkTheme = true) {
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
                    var selectedHeight by remember { mutableStateOf(initialHeight) }

                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = t("profile.choose_height"),
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        Box(
                            modifier = Modifier.height(250.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            WheelPicker(
                                items = (120..230).toList(),
                                selected = selectedHeight,
                                onSelected = { selectedHeight = it }
                            )
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        GradientButton(
                            text = t("common.confirm"),
                            onClick = {
                                onConfirm(selectedHeight)
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