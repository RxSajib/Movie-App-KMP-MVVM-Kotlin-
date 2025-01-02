package org.wizard.project.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
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
import androidx.navigation.NavHostController
import coil3.compose.rememberAsyncImagePainter
import org.jetbrains.compose.resources.painterResource
import org.wizard.project.ui.component.EpisodeItem
import org.wizard.project.ui.dto.MovieDetailsResponse
import the_movie_db.composeapp.generated.resources.Res
import the_movie_db.composeapp.generated.resources.eye_open_svgrepo_com
import the_movie_db.composeapp.generated.resources.heart_icon
import kotlin.math.max

@Composable
fun DetailsSingleMovie(
    navHostController: NavHostController,
    data: MovieDetailsResponse,

    ) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f)
            ) {
                val painter =
                    rememberAsyncImagePainter(model = data.tvShow?.image_thumbnail_path)

                Image(
                    painter = painter, contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxHeight()
                        .aspectRatio(1f), contentScale = ContentScale.FillBounds
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = data.tvShow?.name ?: "",
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 30.sp
                        ),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 30.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)
                            .clip(
                                CircleShape
                            )
                            .clickable {
                                navHostController.popBackStack()
                            }
                            .background(Color.DarkGray), contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(.65f),
                            tint = Color.White
                        )
                    }

                    Box(
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)
                            .clip(
                                CircleShape
                            )
                            .clickable {
                                /*viewmodel.insertBookMark(
                                    BookMark(
                                        country = singleMovieDetailsResponse.tvShow.country,
                                        end_date = singleMovieDetailsResponse.tvShow.end_date,
                                        id = singleMovieDetailsResponse.tvShow.id,
                                        image_thumbnail_path = singleMovieDetailsResponse.tvShow.image_path,
                                        name = singleMovieDetailsResponse.tvShow.name,
                                        network = singleMovieDetailsResponse.tvShow.network,
                                        permalink = singleMovieDetailsResponse.tvShow.permalink,
                                        start_date = singleMovieDetailsResponse.tvShow.start_date,
                                        status = singleMovieDetailsResponse.tvShow.status
                                    )
                                )*/
                            }
                            .background(Color.Gray), contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource( Res.drawable.heart_icon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                       /* Icon(
                            imageVector = if (x?.id == null) {
                                Icons.Filled.FavoriteBorder
                            } else {
                                Icons.Outlined.Favorite
                            },
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(.65f),
                            tint = Color.White
                        )*/
                    }
                }


            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = Color.Yellow
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(text = "5.5", style = TextStyle(fontSize = 18.sp, color = Color.Gray))
                    Spacer(modifier = Modifier.width(20.dp))
                   Icon(
                       painter = painterResource(Res.drawable.eye_open_svgrepo_com),
                       contentDescription = null,
                       tint = Color.Yellow,
                       modifier = Modifier.size(24.dp)
                   )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "542", style = TextStyle(fontSize = 18.sp, color = Color.Gray))
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "movie details",
                    style = TextStyle(color = Color.Gray),
                    maxLines = 7,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = data.tvShow?.name ?: "Unknown",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = data.tvShow?.description ?: "No details found",
                    style = TextStyle(color = Color.Gray.copy(0.8f), fontSize = 12.sp),
                    maxLines = 10,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Epsoid",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))

                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    verticalItemSpacing = 5.dp,
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                ) {
                    data.tvShow?.episodes?.let {
                        items(it.size) { item ->
                            data.tvShow.episodes[item]?.let { it1 -> EpisodeItem(it1) }
                        }
                    }
                }

            }
        }
    }
}

@Composable
private fun Preview() {
}