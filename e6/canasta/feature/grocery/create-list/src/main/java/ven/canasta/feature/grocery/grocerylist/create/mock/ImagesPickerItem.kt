package ven.canasta.feature.grocery.grocerylist.create.mock

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import coil.compose.AsyncImage
import coil.request.ImageRequest
import ven.canasta.core.designsystem.theme.CanastaTheme
import ven.canasta.core.ui.mock.Gray60
import ven.canasta.core.ui.mock.Green60
import ven.canasta.feature.grocery.R

/**
 * The default images picker item.
 *
 * @param imageItem The attachment item.
 * @param onImageSelected Handler when the user selects the image.
 */
@Composable
internal fun ImagesPickerItem(
    imageUrl: String, // imageUri: Uri,
    onImageSelected: () -> Unit = {}
) {
    var isSelected by rememberSaveable { mutableStateOf(false) }

    // val attachmentMetaData = imageItem.attachmentMetaData
    // val isVideo = attachmentMetaData.type == ModelType.attach_video

    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data(imageUrl)
        .build()

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
        AsyncImage(
            model = imageRequest,
            imageLoader = LocalStreamImageLoader.current,
            modifier = Modifier.fillMaxSize(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            onSuccess = {
            }
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
                    painter = painterResource(id = R.drawable.stream_compose_ic_checkmark),
                    contentDescription = null,
                    tint = Green60
                )
            }
        }

    }
}


@Preview(showBackground = true, name = "DefaultImagePicker")
@Composable
public fun DefaultImagePickerPreview() {
    CanastaTheme {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(Modifier.padding(50.dp))
            Text("Hola Mundo!")
            Spacer(Modifier.padding(50.dp))
            ImagesPickerItem(
                imageUrl = "https://www.techotopia.com/c/kotlin_dolphin_front_cover_150x190.png",
            )
            Spacer(Modifier.padding(50.dp))
        }
    }
}

