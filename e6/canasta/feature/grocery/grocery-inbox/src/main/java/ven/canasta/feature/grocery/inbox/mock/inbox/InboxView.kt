package ar.ven.apps.gro.feature.inbox.mock.inbox

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import ven.canasta.core.designsystem.theme.CanastaTheme
import ven.canasta.feature.grocery.inbox.GroceryListsVM
import ven.canasta.feature.grocery.inbox.mock.inbox.InboxContent
import ven.canasta.grocerylist.GroceryList
import ven.canasta.grocerylist.dummyGroceryLists

@Composable
public fun InboxView(
    modifier: Modifier = Modifier,
    navigateToCreateList: () -> Unit = {}
) {
    val viewModel: GroceryListsVM = viewModel()
    InboxView(
        modifier,
        navigateToCreateList = navigateToCreateList,
        viewModel
    )
}
@Composable
fun InboxView(
    modifier: Modifier = Modifier,
    navigateToCreateList: () -> Unit = {},
    viewModel: GroceryListsVM
) {
    Column { // InboxContainer{
        InboxHeader{
            InboxTitle("Tus listas")
            CreateListButton(
                "Crear nueva",
                onClick = navigateToCreateList
            )
        }
        InboxFilters()
        InboxContent(
            viewModel
        )
    }
}

@Preview(name="inbox-view", showBackground=true)
@Composable
fun InboxViewPreview() {
   CanastaTheme() {
       InboxView(
           viewModel = object : GroceryListsVM {
               override fun getGroceryLists(): List<GroceryList> {
                   return dummyGroceryLists
               }
           }
       )
   }
}
