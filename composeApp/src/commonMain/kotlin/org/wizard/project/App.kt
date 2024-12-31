package org.wizard.project

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.wizard.project.data.model.TvShow
import org.wizard.project.data.tab.Tab
import org.wizard.project.ui.navigation.Navigation
import org.wizard.project.ui.page.BookMark
import org.wizard.project.ui.page.Profile
import org.wizard.project.viewmodel.MyViewModel


@Composable
@Preview
fun App(viewModel: MyViewModel = koinViewModel<MyViewModel>()) {

    MaterialTheme {
        Navigation()
    }

}


@Composable
private fun Content(padding: PaddingValues, selectedIndex: Int, navcontroller: NavHostController) {
    when (selectedIndex) {
        0 -> org.wizard.project.ui.page.MainScreen(padding, navcontroller)
        1 -> BookMark(padding)
        2 -> Profile(padding)
    }
}

@Composable
fun MainScreen(navcontroller: NavHostController) {
    val tabs = arrayOf(
        Tab(title = "Tv Show", icon = Icons.Default.Search),
        Tab(title = "Favorite", icon = Icons.Default.Favorite),
        Tab(title = "Profile", icon = Icons.Default.Person)
    )

    val selectedIndex = remember { mutableIntStateOf(0) }

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "MOVIE DB")
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                        }
                    },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                        }
                    }

                )
            },
            bottomBar = {
                BottomNavigation() {
                    tabs.forEachIndexed { index, tab ->
                        BottomNavigationItem(
                            selected = selectedIndex.intValue == index,
                            label = {
                                Text(text = tabs[index].title)
                            },
                            icon = {
                                Icon(
                                    imageVector = tab.icon,
                                    contentDescription = null
                                )
                            },
                            onClick = {
                                selectedIndex.intValue = index
                            }
                        )
                    }

                }
            }
        ) { innder_padding ->
            Content(innder_padding, selectedIndex.intValue, navcontroller)
        }
    }
}

