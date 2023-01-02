package ar.ven.apps.gro.feature.inbox.mock.inbox

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowColumn
import ven.canasta.core.designsystem.theme.CanastaTheme

@Composable
public fun InboxView(
    modifier: Modifier = Modifier
) {
    //var isEmpty by remember { mutableStateOf(true) }

    Column(
        modifier.fillMaxWidth()
            .padding( horizontal = 20.dp ),

    ) { // InboxContainer{
        InboxHeader{
            InboxTitle("Tus Listas")
            CreateListButton("Crear nueva")
        }
        InboxFilters()
        InboxContent()
    }
}



@Preview(name="inbox-view", showBackground=true)
@Composable
fun InboxViewPreview() {
   CanastaTheme() {
       InboxView()
   }
}
