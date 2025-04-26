package org.example.kariai.ui.screens.register.userdetails.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import localization.t
import org.example.kariai.resources.NutriTheme

@Composable
fun NameInputDialog(
    name: String,
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    var tempName by remember { mutableStateOf(name) }


    NutriTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.6f))
                .clickable(onClick = onDismiss),
            contentAlignment = Alignment.Center,
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .wrapContentHeight(),
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surface,
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                ) {
                    Text(
                        text = t("profile.name_label"),
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    BasicTextField(
                        value = tempName,
                        onValueChange = { tempName = it },
                        textStyle = TextStyle(
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.onSurface,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                MaterialTheme.colorScheme.surfaceVariant,
                                RoundedCornerShape(8.dp),
                            )
                            .padding(
                                horizontal = 12.dp,
                                vertical = 8.dp,
                            )
                    )

                    Spacer(modifier = Modifier.fillMaxWidth())


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                    ) {
                        Text(
                            text = t("common.cancel"),
                            modifier = Modifier
                                .clickable { onDismiss() }
                                .padding(8.dp),
                            color = MaterialTheme.colorScheme.primary,
                        )


                        Spacer(modifier = Modifier.width(16.dp))


                        Text(
                            text = t("common.ok"),
                            modifier = Modifier
                                .clickable {
                                    onConfirm(tempName.trim())
                                    onDismiss()
                                }
                                .padding(8.dp),
                            color = MaterialTheme.colorScheme.primary,
                        )
                    }
                }
            }
        }
    }
}