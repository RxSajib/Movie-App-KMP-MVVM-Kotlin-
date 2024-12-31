package org.wizard.project.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.wizard.project.ui.page.MainScreen
import org.wizard.project.ui.page.MovieDetails
import org.wizard.project.ui.route.Route.DETAILS
import org.wizard.project.ui.route.Route.HOME

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HOME){
        composable(route = HOME) {
            org.wizard.project.MainScreen(navcontroller = navController)
        }

        composable(route = DETAILS){
            MovieDetails()
        }
    }
}


