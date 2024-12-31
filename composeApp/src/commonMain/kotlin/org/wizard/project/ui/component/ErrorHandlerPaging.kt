package org.wizard.project.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ErrorHandlerPaging(xmodifier: Modifier, onClick : () -> Unit) {
    Box(modifier = xmodifier, contentAlignment = Alignment.Center){

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(imageVector = Icons.Default.Refresh, contentDescription = null, Modifier.size(100.dp),
                colorFilter = ColorFilter.tint(Color.Gray))

            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = "No internet connection\nPlease try again",
                textAlign = TextAlign.Center,
                style = TextStyle(color = Color.Gray, fontSize = 15.sp)
            )

            Spacer(modifier = Modifier.height(5.dp))
            OutlinedButton(onClick = { onClick() }) {
                Text(text = "Retry")
            }

        }

    }
}

@Composable
fun Preview(modifier: Modifier = Modifier) {
    ErrorHandlerPaging(xmodifier = Modifier.fillMaxSize(), onClick = {})
}