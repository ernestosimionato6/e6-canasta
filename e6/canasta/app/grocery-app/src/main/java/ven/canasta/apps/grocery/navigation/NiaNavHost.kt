package ven.canasta.apps.grocery.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.Companion
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ven.canasta.feature.grocery.grocerylist.create.GroceryCreateListScreen
import ven.canasta.feature.grocery.inbox.GroceryInboxScreen
import ven.canasta.feature.grocery.inbox.GroceryListsViewModel

// import ven.canasta.feature.grocery.grocerylist.create.navigation.groceryAddItemsNavigationRoute

@Composable
fun NiaNavHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = "grocery-list/inbox" // home" // inbox"  // groceryInboxNavigationRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination, // "grocery-list/home",
        modifier = modifier,
    ) {
        composable(
           "grocery-list/inbox",
        ) {
            GroceryInboxScreen(
                navigateToCreateList =  { navController.navigate("grocery-list/create-list") }
            )
        }
        composable(
           "grocery-list/home",
        ) {
            GroceryHomeScreen (
                navigateToNewList = { navController.navigate("grocery-list/create-list") },
                navigateToList = { listId ->
                    navController.navigate("grocery-list/list/${listId}")
                }
            )
        }
        composable(
            "grocery-list/create-list"
        ) {
            GroceryCreateListScreen(
                navigateToAddItemToList = { listId ->
                    navController.navigate("grocery-list/list/${listId}/add-items")
                }
            )
        }
        composable(
            "grocery-list/list/{listId}",
            arguments = listOf(navArgument("listId") { type = NavType.StringType })
        ) {backStackEntry ->
            GroceryListHomeScreen(
                navController, // onNavigate: (Int) -> ()
                backStackEntry.arguments?.getString("listId").toString()
                // navigateToList: (listId: String) -> Unit
                //  { listId ->
                //        navController.navigate("grocery-list/list/{listId}")  // list?listId=$listId
                // }
            )
        }

        composable(
            "grocery-list/list/{listId}/edit-items",
            arguments = listOf(navArgument("listId") { type = NavType.StringType })
        ) {backStackEntry ->
            GroceryListEditItemsScreen (
                navController = navController,
                listId = backStackEntry.arguments?.getString("listId").toString()
            )
        }

        composable(
            "grocery-list/list/{listId}/add-items",
            arguments = listOf(navArgument("listId") { type = NavType.StringType })
        ) {backStackEntry ->
            GroceryListAddItemsScreen (
                navController = navController,
                listId = backStackEntry.arguments?.getString("listId").toString()
            )
        }
//        groceryInboxScreen()
//        groceryCreateListScreen(
//            navigateToAddItemsToList = { },
//            navigateToEditItemsToList = { listId ->
//                navController.navigate("listId")
//            }
//        )
//        forYouScreen()
//        bookmarksScreen()
//        interestsGraph(
//            navigateToTopic = { topicId ->
//                navController.navigateToTopic(topicId)
//            },
//            nestedGraphs = {
//                topicScreen(onBackClick)
//            }
//        )
    }
}

@SuppressLint("DesignSystem")
@Composable
fun GroceryHomeScreen(
    navigateToNewList: () -> Unit = {},
    navigateToList: (listId: String) -> Unit = {}
) {
    val viewModel: GroceryListsViewModel = viewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(Modifier.fillMaxWidth()) {
            Button(
                onClick = navigateToNewList
            ) {
                Text("[ create list ]")
            }
        }
        Row(Modifier.fillMaxWidth()) {
            Button(
                onClick = { navigateToList("#1234") }
            ) {
                Text("[ #123 ]")
            }
        }
        viewModel.getGroceryLists().forEach { it ->
            Row(Modifier.fillMaxWidth()) {
                Button(
                    onClick = { navigateToList("${it.id}") }
                ) {
                    Text("[ ${it.name} ] $ ${it.total().amount}")
                }
            }
        }
    }
}

@SuppressLint("DesignSystem")
@Composable
fun GroceryListEditItemsScreen(
    navController: NavHostController,
    listId: String
) {
    GroceryListEditItemsScreen(
        navigateToList = { navController.navigate("grocery-list/list/${listId}") },
        navigateToAddItems = { navController.navigate("grocery-list/list/${listId}/add-items") },
        listId = listId
    )
}

@SuppressLint("DesignSystem")
@Composable
fun GroceryListEditItemsScreen(
    navigateToList: () -> Unit = {},
    navigateToAddItems: () -> Unit = {},
    listId: String
) {
    Column(
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier.fillMaxSize()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("[ grocery-list::edit-items ]")
            Text("[ #### ${listId} #### ]")
        }
        Row(Modifier.fillMaxWidth()) {
            Button(onClick = navigateToAddItems) {
                Text("[ add-items ]")
            }
        }
        Row(Modifier.fillMaxWidth()) {
            Button(onClick = navigateToList) {
                Text("[ done ]")
            }
        }
    }
}

@SuppressLint("DesignSystem")
@Composable
fun GroceryListAddItemsScreen(
    navController: NavHostController,
    listId: String
) {
    GroceryListAddItemsScreen(
        navigateToList = { navController.navigate("grocery-list/list/${listId}/edit-items") },
        listId = listId
    )
}

@SuppressLint("DesignSystem")
@Composable
fun GroceryListAddItemsScreen(
    navigateToList: () -> Unit = {},
    listId: String
) {
    Column(
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier.fillMaxSize()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("[ grocery-list::add-items ]")
            Text("[ #### ${listId} #### ]")
        }
        Button(onClick = navigateToList) {
           Text("Done")
        }
    }
}

@SuppressLint("DesignSystem")
@Composable
fun GroceryListHomeScreen(
    navController: NavHostController,
    listId: String
) {
    GroceryListHomeScreen(
        navigateToEditItems = {listId -> navController.navigate("grocery-list/list/${listId}/edit-items") },
        listId = listId
    )
}
@SuppressLint("DesignSystem")
@Composable
fun GroceryListHomeScreen(
    navigateToEditItems: (listId: String) -> Unit =  {},
    listId: String  // String?
) {
    Column(
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier.fillMaxSize()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("[ grocery-list::home ]")
            Text("[ ### ${listId} ### ]")
        }
        Button(onClick = {
            navigateToEditItems(listId)
        }) {
           Text("Edit Items")
        }
    }
}
