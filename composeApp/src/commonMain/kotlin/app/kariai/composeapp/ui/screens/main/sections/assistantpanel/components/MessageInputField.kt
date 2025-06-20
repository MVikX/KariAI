package app.kariai.composeapp.ui.screens.main.sections.assistantpanel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// layout values
private val OuterPadding = 8.dp
private val CornerRadius = 16.dp
private val ButtonContentHorizontal = 16.dp
private val ButtonContentVertical = 12.dp
private val InputToButtonSpacer = 8.dp
private val InputElevation = 2.dp

// proportions
private const val InputWeight = 1f

@Composable
fun MessageInputField(
    inputText: String,
    onInputTextChange: (String) -> Unit,
    onSendMessage: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(OuterPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            shape = RoundedCornerShape(CornerRadius),
            tonalElevation = InputElevation,
            modifier = Modifier.weight(InputWeight)
        ) {
            OutlinedTextField(
                value = inputText,
                onValueChange = onInputTextChange,
                placeholder = { Text("Type a message...") }, // TODO: localized
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline
                )
            )
        }

        Spacer(modifier = Modifier.width(InputToButtonSpacer))

        Button(
            onClick = {
                if (inputText.isNotBlank()) {
                    onSendMessage(inputText)
                }
            },
            shape = RoundedCornerShape(CornerRadius),
            contentPadding = PaddingValues(
                horizontal = ButtonContentHorizontal,
                vertical = ButtonContentVertical
            )
        ) {
            Text("Send") // TODO: localized
        }
    }
}