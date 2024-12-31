package org.wizard.project

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.wizard.project.data.model.TvShow
import org.wizard.project.ui.component.MovieItem
import org.wizard.project.ui.component.ShimmerEffect
import org.wizard.project.viewmodel.MyViewModel


@Composable
@Preview
fun App(viewModel: MyViewModel = koinViewModel<MyViewModel>()) {

    val list: LazyPagingItems<TvShow> = viewModel.moviepage.collectAsLazyPagingItems()

    MaterialTheme {

        Box(modifier = Modifier.fillMaxSize()) {

            LazyColumn {

                list.apply {
                    when {
                        loadState.append is LoadState.Loading -> {
                            item {
                                CircularProgressIndicator()
                            }
                        }

                        loadState.refresh is LoadState.Loading -> {
                            item {
                                ShimmerEffect(mymodifier = Modifier.fillParentMaxSize())
                            }
                        }

                        loadState.append is LoadState.Error -> {
                            val error = list.loadState.append as LoadState.Error
                            item {
                                Box(modifier = Modifier.fillMaxWidth().padding(10.dp), contentAlignment = Alignment.Center) {
                                    Column {
                                        Text(
                                            text = error.toString()
                                        )
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Button(onClick = {
                                            list.retry()
                                        }){
                                            Text(
                                                text = "Retry Again"
                                            )
                                        }
                                    }
                                }
                            }

                        }
                    }
                }

                items(list.itemCount) { item ->
                    list[item]?.let { MovieItem(it) }
                }


            }
        }
    }
}