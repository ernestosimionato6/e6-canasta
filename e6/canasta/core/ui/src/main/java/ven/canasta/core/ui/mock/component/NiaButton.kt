package ven.canasta.feature.grocery.inbox.mock.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import ven.canasta.core.designsystem.theme.eniaSemiBold
import ven.canasta.core.ui.mock.Black80
import ven.canasta.core.ui.mock.Gray40

@SuppressLint("DesignSystem")
@Composable
fun FilterItem(
    text: String = "",
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Gray40 // MaterialTheme.colorScheme.onBackground
        )
    ) {
        Text(
            text,
            style = TextStyle(
                color = Black80,
                fontFamily = eniaSemiBold
            )
        )
    }
}
