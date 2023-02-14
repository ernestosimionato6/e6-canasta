package ven.task.apps.t2do.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun T2DoNavHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = "t2do-list/inbox"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(
           "t2do-list/inbox",
        ) {
            T2DoInboxScreen(
                navigateToCreateList =  { navController.navigate("t2do-list/create-list") }
            )
        }
    }
}

