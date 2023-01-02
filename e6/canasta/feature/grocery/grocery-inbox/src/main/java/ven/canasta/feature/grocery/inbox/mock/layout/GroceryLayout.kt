package ar.ven.apps.gro.feature.inbox.mock.layout

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ar.ven.apps.gro.feature.inbox.mock.layout.header.GroceryHeader

@Composable
fun GroceryLayout(
    content: @Composable () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 12.dp),
        verticalArrangement = Arrangement.Top
    ) {
        GroceryHeader(
           modifier = Modifier//.border(1.dp, Color.Red)
        )
        content()
    }
}