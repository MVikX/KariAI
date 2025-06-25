package app.kariai.composeapp.ui.components
//TODO bug with policy labels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.kariai.composeapp.localization.t

private val TermsCheckboxBottomPadding = 16.dp
private val TermsTextSpacing = 8.dp
private val TermsTextAlpha = 0.8f
private val TermsColumnWeight = 1f

@Composable
actual fun PlatformTermsBlock(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = TermsCheckboxBottomPadding),
        verticalAlignment = Alignment.Top
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkmarkColor = MaterialTheme.colorScheme.onPrimary,
                uncheckedColor = MaterialTheme.colorScheme.outline,
                checkedColor = MaterialTheme.colorScheme.primary
            )
        )

        Spacer(modifier = Modifier.width(TermsTextSpacing))

        Column(modifier = Modifier.weight(TermsColumnWeight)) {
            Text(
                text = t("legal.terms_accept_prefix"),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = TermsTextAlpha)
            )

            Row(
                modifier = Modifier.wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = t("legal.terms_link"),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable { onTermsClick() }
                )

                Text(
                    text = " ${t("common.and")} ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = TermsTextAlpha)
                )

                Text(
                    text = t("legal.privacy_link"),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable { onPrivacyClick() }
                )
            }
        }
    }
}