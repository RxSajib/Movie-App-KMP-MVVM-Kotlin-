package org.wizard.project.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import org.jetbrains.compose.resources.painterResource
import org.wizard.project.data.datamanager.DataManager
import org.wizard.project.data.model.TvShow
import paging3.composeapp.generated.resources.Res
import paging3.composeapp.generated.resources.error
import paging3.composeapp.generated.resources.placeholder

@Composable
fun MovieItem(tvShow: TvShow, onClick : () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(10.dp)
        .clickable {
            onClick()
            DataManager.MovieID = tvShow.id
        }) {
        Row(modifier = Modifier.fillMaxWidth()) {
            val painter =
                rememberAsyncImagePainter(model = tvShow.image_thumbnail_path, placeholder = painterResource(
                    Res.drawable.placeholder
                ), error = painterResource(Res.drawable.error)
                )

            Image(painter = painter, contentDescription = null,
                modifier = Modifier
                    .width(75.dp).clip(RoundedCornerShape(10.dp))
                    .fillMaxHeight().aspectRatio(1f), contentScale = ContentScale.FillBounds)

            Spacer(modifier = Modifier.width(10.dp))

            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceAround) {
                Text(text = tvShow.network.toString(), style = TextStyle(color = Color.Gray, fontSize = 12.sp))
                Text(
                    text = tvShow.name.toString(),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp), maxLines = 2, overflow = TextOverflow.Ellipsis
                )
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = null, tint = Color(
                        0x8B363636
                    )
                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    Text(text = "Start From: ${tvShow.start_date.toString()}", style = TextStyle(color = Color.Gray, fontSize = 12.sp), maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
            }
        }
    }
}

@Composable
fun showMovie(modifier: Modifier = Modifier) {
    MovieItem(TvShow("US", "10.20", 12, "data:image/jpeg;base64,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", "The Movie", "US", "", "10 JUN 2023", "End" ), onClick = {})
}

