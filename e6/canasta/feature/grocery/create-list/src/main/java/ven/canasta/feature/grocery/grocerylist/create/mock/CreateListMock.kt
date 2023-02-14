package ven.canasta.feature.grocery.grocerylist.create.mock


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.tooling.preview.Preview
import ven.canasta.core.ui.mock.layout.GroceryLayout
import ven.canasta.core.designsystem.theme.CanastaTheme

@Composable
public fun CreateListMock(
   navigateToAddItemToList: (String) -> Unit = { listId -> {}}
) {

    GroceryLayout(
        bottomMenu = {
            Text("bottom-menu")
        },
    ) {
       CreateListView(
           navigateToAddItemToList= navigateToAddItemToList // (String) -> Unit = { listId -> {}}
       )
    }

}
@Composable
public fun CreateListMock2() {

    GroceryLayout(
        bottomMenu = {
            Text("bottom-menu")
        },
    ) {
       CreateListView(
       )
    }

}

@Preview(name="grocery-create-list-mock", showBackground = true, showSystemUi = true)
@Composable
fun CreateListMockPreview() {

   CanastaTheme {
        CreateListMock()
    }
}