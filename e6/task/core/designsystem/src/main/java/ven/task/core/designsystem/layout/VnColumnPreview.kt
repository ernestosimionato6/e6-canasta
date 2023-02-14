package ven.task.core.designsystem.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VnColumnPreview(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit // ColumnScope = Unit
) {
    VnPreview {
        Column(
            modifier = Modifier
                .background(Color.Yellow.copy(alpha = 0.15F))
                .fillMaxSize()
                .padding(4.dp)
                .border(1.dp, Color.Black)
                .padding(16.dp)
                .then(modifier),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            content()
        }
    }
}