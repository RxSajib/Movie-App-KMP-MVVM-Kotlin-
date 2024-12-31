package org.wizard.project.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp


@Composable //onclick : () -> Unit
fun LoadStateFooterErrorMessage(message : String, onclick : () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 10.dp)){
        Row(modifier = Modifier.fillMaxWidth(1f), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(text = message, style = TextStyle(color = Color.Gray), maxLines = 2, overflow = TextOverflow.Ellipsis, modifier = Modifier.weight(1f), color = Color.Red)
            OutlinedButton(onClick = { onclick() }, modifier = Modifier.weight(.35f)) {
                Text(text = "Retry")
            }
        }
    }
}


@Composable
private fun LoadStateFooterErrorView() {
    //  LoadStateFooterErrorMessage("he elevated button component uses the ElevatedButton composable. It has a shadow that represents the elevation effect by default. Note that it is essentially an outlined button with a shadow.")
}

