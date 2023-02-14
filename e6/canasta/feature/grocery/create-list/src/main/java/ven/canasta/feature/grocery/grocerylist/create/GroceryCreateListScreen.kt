package ven.canasta.feature.grocery.grocerylist.create

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme
import ven.canasta.feature.grocery.grocerylist.create.mock.CreateListMock

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun GroceryCreateListRoute(
    navigateToAddItemToList: (String) -> Unit = {listId -> {}}
) {
    GroceryCreateListScreen(
        navigateToAddItemToList = navigateToAddItemToList
    )
}

@Composable
fun GroceryCreateListScreen(
    navigateToAddItemToList: (String) -> Unit = {listId -> {}}
) {
    CreateListMock(
        navigateToAddItemToList = navigateToAddItemToList
    )
}

@Preview(name="grocery-create-list-screen", showBackground = true)
@Composable
fun GroceryCreateListScreenPreview() {
   NiaTheme {
      GroceryCreateListScreen()
   }
}
