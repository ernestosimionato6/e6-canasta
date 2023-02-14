package com.google.samples.apps.niacatalog.demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme
import ven.canasta.apps.grocery.R

@Composable
fun VnImage(
    image: Int,
    scale: ContentScale = ContentScale.None,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(image),
        contentDescription = "",
        contentScale = scale, // contentScale = ContentScale.Crop,
        modifier = modifier
            .border(4.dp, Black)
    )
}


@Preview(name="vn-image", showBackground = true)
@Composable
fun VnImagePreview() {

    @Composable
    fun MainScreen() {

        Column(
            Modifier
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                "[vn-image]",
                Modifier
                    .border(width = 2.dp, color = Black)
                    .padding(all = 10.dp),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(16.dp))
            VnImage(R.drawable.canasta)

            Spacer(Modifier.height(16.dp))
            Text( "[vn-image] { content-scale: none }")
            VnImage(
                R.drawable.canasta,
                scale = ContentScale.None,
                modifier = Modifier
                    .padding(16.dp)
                    .width(270.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Yellow.copy(alpha = 0.35f))
            )


            Spacer(Modifier.height(16.dp))
            Text( "[vn-image] { content-scale: cover }")
            VnImage(
                R.drawable.canasta,
                scale = ContentScale.Crop,
                modifier = Modifier
                    .padding(16.dp)
                    .width(270.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Yellow.copy(alpha = 0.35f))
            )
            Spacer(Modifier.height(16.dp))
            Text( "[vn-image] { content-scale: fill-bounds }")
            VnImage(
                R.drawable.canasta,
                scale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(16.dp)
                    .width(270.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Yellow.copy(alpha = 0.35f))
            )

            Spacer(Modifier.height(16.dp))
            Text( "[vn-image] { content-scale: fill-height }")
            VnImage(
                R.drawable.canasta,
                scale = ContentScale.FillHeight,
                modifier = Modifier
                    .padding(16.dp)
                    .width(270.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Yellow.copy(alpha = 0.35f))
            )

            Spacer(Modifier.height(16.dp))
            Text( "[vn-image] { content-scale: fill-width }")
            VnImage(
                R.drawable.canasta,
                scale = ContentScale.FillWidth,
                modifier = Modifier
                    .padding(16.dp)
                    .width(270.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Yellow.copy(alpha = 0.35f))
            )
            Spacer(Modifier.height(16.dp))
            Text( "[vn-image] { content-scale: fit }")
            VnImage(
                R.drawable.canasta,
                scale = ContentScale.Fit,
                modifier = Modifier
                    .padding(16.dp)
                    .width(270.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Yellow.copy(alpha = 0.35f))
            )

            Spacer(Modifier.height(16.dp))
            Text( "[vn-image] { content-scale: inside }")
            VnImage(
                R.drawable.canasta,
                scale = ContentScale.Inside,
                modifier = Modifier
                    .padding(16.dp)
                    .width(270.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Yellow.copy(alpha = 0.35f))
            )

        }
    }


    NiaTheme() {
        Surface(
            Modifier.fillMaxSize()
        ) {
            MainScreen()
        }

    }
}