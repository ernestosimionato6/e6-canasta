package ar.ven.apps.gro.feature.inbox.mock


import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import ar.ven.apps.gro.feature.inbox.mock.inbox.InboxView
import ven.canasta.core.ui.mock.layout.GroceryLayout

import ven.canasta.core.designsystem.theme.CanastaTheme
import ven.canasta.feature.grocery.inbox.GroceryListsVM
import ven.canasta.grocerylist.GroceryList
import ven.canasta.grocerylist.dummyGroceryLists

@Composable
fun OnboardingMock(
    navigateToCreateList: () -> Unit = {}
) {

    GroceryLayout(

    ){
       InboxView(
           navigateToCreateList = navigateToCreateList,
           viewModel = object : GroceryListsVM {
               override fun getGroceryLists(): List<GroceryList> {
                   return dummyGroceryLists
               }
           }
       )
    }

}


@Preview(name="grocery-onboarding-mock", showBackground = true, showSystemUi = true)
@Composable
fun OnboardingMockPreview() {

        CanastaTheme {
        OnboardingMock()
    }
}