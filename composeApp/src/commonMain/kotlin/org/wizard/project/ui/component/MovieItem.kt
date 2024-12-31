package org.wizard.project.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.wizard.project.data.model.TvShow

@Composable
fun MovieItem(tvShow: TvShow) {
       Box(modifier = Modifier.fillMaxWidth().padding(15.dp)) {
           Text(
               text = tvShow.name?: ""
           )
       }
}