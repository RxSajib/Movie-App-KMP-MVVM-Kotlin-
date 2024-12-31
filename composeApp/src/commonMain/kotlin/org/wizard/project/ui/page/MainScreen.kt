package org.wizard.project.ui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import org.koin.compose.viewmodel.koinViewModel
import org.wizard.project.data.model.TvShow
import org.wizard.project.ui.component.ErrorHandlerPaging
import org.wizard.project.ui.component.LoadNetPage
import org.wizard.project.ui.component.LoadStateFooterErrorMessage
import org.wizard.project.ui.component.MovieItem
import org.wizard.project.ui.component.ShimmerEffect
import org.wizard.project.viewmodel.MyViewModel

@Composable
fun MainScreen(
    padding: PaddingValues,
    navcontroller: NavHostController,
    viewModel: MyViewModel = koinViewModel<MyViewModel>()
) {

    val list: LazyPagingItems<TvShow> = viewModel.moviepage.collectAsLazyPagingItems()
    Box(modifier = Modifier.fillMaxSize().padding(padding)) {

        LazyColumn {
            items(list.itemCount) { item ->
                list[item]?.let {
                    MovieItem(
                        onClick = {},
                        tvShow = it
                    )
                }
            }

            list.apply {
                when {
                    loadState.refresh is LoadState.Error -> {
                        item {
                            ErrorHandlerPaging(
                                xmodifier = Modifier.fillParentMaxSize(),
                                onClick = {
                                    list.retry()
                                })
                        }
                    }

                    loadState.refresh is LoadState.Loading -> {
                        item {
                            ShimmerEffect(mymodifier = Modifier.fillParentMaxSize())
                        }
                    }

                    loadState.append is LoadState.Loading -> {
                        item {
                            LoadNetPage()
                        }
                    }

                    loadState.append is LoadState.Error -> {
                        val error = list.loadState.append as LoadState.Error
                        item {
                            LoadStateFooterErrorMessage(
                                message = error.toString(),
                                onclick = {
                                    list.retry()
                                })
                        }
                    }
                }
            }

        }
    }
}