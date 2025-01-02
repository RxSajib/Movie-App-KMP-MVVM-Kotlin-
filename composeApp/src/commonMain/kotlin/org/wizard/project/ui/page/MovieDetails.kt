package org.wizard.project.ui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.toRoute
import org.koin.compose.viewmodel.koinViewModel
import org.wizard.project.data.model.TvShow
import org.wizard.project.ui.component.ErrorHandlerPaging
import org.wizard.project.ui.component.LoadingProgressBar
import org.wizard.project.utils.NetworkResult
import org.wizard.project.utils.logMessage
import org.wizard.project.viewmodel.MyViewModel

@Composable
fun MovieDetails(navController: NavHostController, backStack: NavBackStackEntry,  vm : MyViewModel = koinViewModel<MyViewModel>()) {
    val data = backStack.toRoute<TvShow>()
    val detailsResponse by vm.movieDetailsStateFlow.collectAsState()

    LaunchedEffect(key1 = Unit){
        vm.getSingleMovieDetails(
            movieId = data.id.toString()
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when(detailsResponse){
            is NetworkResult.Loading -> {
                logMessage("loading ...")
                LoadingProgressBar()
            }
            is NetworkResult.Success -> {
                logMessage("success ${detailsResponse.data}")
                DetailsSingleMovie(navHostController = navController, detailsResponse.data!!)
            }
            is NetworkResult.Empty -> {

            }
            is NetworkResult.Error -> {
                ErrorHandlerPaging(Modifier.fillMaxSize(), onClick = {
                    vm.getSingleMovieDetails(data.id.toString())
                })
            }
        }

    }
}