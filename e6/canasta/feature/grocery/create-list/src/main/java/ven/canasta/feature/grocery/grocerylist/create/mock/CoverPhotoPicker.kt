package ven.canasta.feature.grocery.grocerylist.create.mock

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ven.canasta.core.designsystem.theme.CanastaTheme
import ven.canasta.core.designsystem.theme.eniaSemiBold
import ven.canasta.core.ui.mock.Black80
import ven.canasta.core.ui.mock.Gray60
import ven.canasta.core.ui.mock.Green60
import ven.canasta.feature.grocery.R
import ven.canasta.feature.grocery.R.drawable

@Composable
fun CoverPhotoPicker(
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 4.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        val scrollState = rememberScrollState()


        Text("Eligi una portada para tu lista",
            modifier = Modifier.padding(bottom = 8.dp),
            style = TextStyle(
                    fontFamily = eniaSemiBold,
                    fontWeight = FontWeight(600),
                    fontSize = 15.sp,
                    color = Black80
            )
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 1.dp)
                .horizontalScroll(scrollState, enabled = true),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PhotoItem(image = R.drawable.banner_1, {})
            PhotoItem(image = R.drawable.banner_2, {})
            PhotoItem(image = R.drawable.banner_3, {})
            PhotoItem(image = R.drawable.banner_4, {})
            PhotoItem(image = R.drawable.banner_5, {})
            PhotoItem(image = R.drawable.banner_6, {})
            PhotoItem(image = R.drawable.banner_7, {})
            PhotoItem(image = R.drawable.banner_8, {})
            PhotoItem(image = R.drawable.banner_9, {})
            PhotoItem(image = R.drawable.banner_10, {})
        }
    }
}

@Composable
fun PhotoItem(image: Int) {
        Image(
            // HeroPic
            painter = painterResource(image),
            contentDescription = "Elegi tu tienda",
            //.border(1.dp, Gray40)
            modifier = Modifier
                .width(133.dp)
                .height(96.dp)
                .padding(end = 8.dp)
                .clip(RoundedCornerShape(10.dp))
        )
}


@Composable
internal fun PhotoItem(
    image: Int,
    onImageSelected: () -> Unit = {}
) {
    var isSelected by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .height(125.dp)
            .padding(2.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                onClick = {
                    isSelected = !isSelected
                    onImageSelected()
                }
            )
    ) {
        Image(
            painter = painterResource(id = image),
            modifier = Modifier.fillMaxSize(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        if (isSelected) { // imageItem.isSelected) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp)
                    .size(24.dp)
                    .background(shape = CircleShape, color = Gray60)
            ) {
                Icon(
                    modifier = Modifier.align(Alignment.Center),
                    painter = painterResource(id = drawable.stream_compose_ic_checkmark),
                    contentDescription = null,
                    tint = Green60
                )
            }
        }

    }
}




@Preview(name="cover-photo-picker", showBackground = true)
@Composable
fun CoverPhotoPickerPreview() {

    CanastaTheme() {

        Surface(Modifier.fillMaxSize()) {

            CoverPhotoPicker()
        }
        
    }
}