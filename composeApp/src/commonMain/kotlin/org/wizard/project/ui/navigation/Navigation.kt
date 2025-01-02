package org.wizard.project.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.wizard.project.data.model.TvShow
import org.wizard.project.ui.page.MovieDetails
import org.wizard.project.ui.route.Route.HOME

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HOME){
        composable(route = HOME) {
            org.wizard.project.MainScreen(navcontroller = navController)
        }

        composable<TvShow>{ backStackEntry ->
            MovieDetails(navController = navController, backStack = backStackEntry)
        }
    }
}


