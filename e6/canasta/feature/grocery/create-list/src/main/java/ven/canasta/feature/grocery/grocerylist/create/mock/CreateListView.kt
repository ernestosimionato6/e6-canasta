package ven.canasta.feature.grocery.grocerylist.create.mock

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ven.canasta.core.designsystem.theme.CanastaTheme

@Composable
fun CreateListView(

    navigateToAddItemToList: (String) -> Unit = { listId -> {}}
) {

    CreateListForm(

        navigateToAddItemToList= navigateToAddItemToList // (String) -> Unit = { listId -> {}}
    )

}

@Preview(showBackground = true, name="create-list-view")
@Composable
fun CreateListViewPreview() {

    CanastaTheme {
        Surface(Modifier.fillMaxWidth()) {
            CreateListViewPreview()
        }
    }

}