package ven.canasta.feature.grocery.inbox.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import ven.canasta.feature.grocery.inbox.GroceryInboxRoute

const val groceryInboxNavigationRoute = "grocery_inbox_route"

fun NavController.navigateToGroceryInbox(navOptions: NavOptions? = null) {
    this.navigate(groceryInboxNavigationRoute, navOptions)
}

fun NavGraphBuilder.groceryInboxScreen() {
    composable(route = groceryInboxNavigationRoute) {
        GroceryInboxRoute()
    }
}
