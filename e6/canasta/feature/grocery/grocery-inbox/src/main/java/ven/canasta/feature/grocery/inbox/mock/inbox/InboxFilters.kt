package ar.ven.apps.gro.feature.inbox.mock.inbox

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.google.samples.apps.nowinandroid.core.designsystem.component.NiaButton
import com.google.samples.apps.nowinandroid.core.designsystem.component.NiaOutlinedButton
import com.google.samples.apps.nowinandroid.core.designsystem.component.NiaTextButton
import ven.canasta.feature.grocery.inbox.mock.component.FilterItem

@Composable
public fun InboxFilters(
    modifier : Modifier = Modifier
)  {
    FlowRow(
        mainAxisSpacing = 16.dp,
        modifier= modifier.padding(bottom= 16.dp)
    ) {
        FilterItem( "Todas" ) { }
        FilterItem( "Creadas por mi" ) { }
    }
//    FlowRow(mainAxisSpacing = 16.dp) {
//        NiaOutlinedButton(onClick = {}) {
//            Text(text = "Todas")
//        }
//        NiaOutlinedButton(onClick = {}) {
//            Text(text = "Creadas por mi")
//        }
//    }
}