package org.wizard.project.ui.page

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
private fun Content(padding: PaddingValues, selectedIndex: Int, navcontroller: NavHostController) {
    when (selectedIndex) {
        0 -> MainScreen(padding, navcontroller)
        1 -> BookMark(padding)
        2 -> Profile(padding)
    }
}