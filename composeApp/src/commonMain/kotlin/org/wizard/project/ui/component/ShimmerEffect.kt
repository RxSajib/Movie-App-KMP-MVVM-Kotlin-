package org.wizard.project.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer


@Composable
fun ShimmerEffect(mymodifier: Modifier) {
    Box(modifier = mymodifier){
        Column(modifier = Modifier.fillMaxWidth()) {
            for(i in 0 .. 10){
                ShimmerItem()
            }
        }
    }
}

@Composable
fun ShimmerItem(modifier: Modifier = Modifier) {
    ShimmerItemPrev()
}

@Composable
private fun ShimmerItemPrev() {
    val shimmerInstance = rememberShimmer(shimmerBounds = ShimmerBounds.Window)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        Row {
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(10))
                    .shimmer(shimmerInstance)
                    .background(Color(0xFFDADADA))

            )
            Spacer(modifier = Modifier.width(20.dp))

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
            ) {

                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.Start) {
                    Box(modifier = Modifier.fillMaxWidth().height(15.dp).clip(
                        CircleShape
                    ).shimmer(shimmerInstance).background(Color(0xFFDADADA)))

                    Box(modifier = Modifier.fillMaxWidth().height(15.dp).clip(
                        CircleShape
                    ).shimmer(shimmerInstance).background(Color(0xFFDADADA)))

                    Box(modifier = Modifier.fillMaxWidth().height(15.dp).clip(
                        CircleShape
                    ).shimmer(shimmerInstance).background(Color(0xFFDADADA)))
                }
            }
        }
    }
}