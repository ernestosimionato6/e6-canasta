package ven.task.core.designsystem.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VnRowPreview(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit // ColumnScope = Unit
) {
    VnPreview {
        Row(
            modifier = Modifier
                .background(Color.Yellow.copy(alpha = 0.15F))
                .fillMaxWidth()
                .padding(4.dp)
                .border(1.dp, Color.Black)
                .padding(16.dp)
                .then(modifier),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            content()
        }
    }
}