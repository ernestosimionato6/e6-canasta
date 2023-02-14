package ven.task.core.designsystem.layout

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ven.task.core.designsystem.theme.CanastaTheme

@Composable
fun VnPreview(
    content: @Composable () -> Unit
) {
    CanastaTheme {
        Box(
            Modifier
                .fillMaxSize()
                .padding(8.dp)
                .border(1.dp, Color.Black)
                .padding(16.dp),
            contentAlignment = Alignment.TopCenter,
        ) {
            content()
        }
    }
}