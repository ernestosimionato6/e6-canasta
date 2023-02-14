package ven.canasta.feature.grocery.grocerylist.create.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import ven.canasta.feature.grocery.grocerylist.create.GroceryCreateListRoute

const val groceryCreateListNavigationRoute = "grocery_create_list_route"

fun NavController.navigateToGroceryCreateList(navOptions: NavOptions? = null) {
    this.navigate(groceryCreateListNavigationRoute, navOptions)
}

fun NavGraphBuilder.groceryCreateListScreen(
    navigateToAddItemsToList : (String) -> Unit = { listId -> {}}
) {
    composable(route = groceryCreateListNavigationRoute) {
        GroceryCreateListRoute(
           navigateToAddItemsToList
        )
    }
}
