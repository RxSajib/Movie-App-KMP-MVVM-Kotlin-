package org.wizard.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.wizard.project.di.initKoin

fun main() = application {

    initKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "Paging 3",
    ) {
        App()
    }
}