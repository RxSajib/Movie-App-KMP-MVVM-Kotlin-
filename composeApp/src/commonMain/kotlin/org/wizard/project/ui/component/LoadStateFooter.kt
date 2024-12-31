package org.wizard.project.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoadNetPage() {
    Box(modifier = Modifier.fillMaxWidth().padding(10.dp), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}