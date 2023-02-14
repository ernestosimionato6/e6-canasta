package ven.canasta.feature.chat.channels

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.getstream.chat.android.compose.ui.theme.ChatTheme
import io.getstream.chat.android.compose.ui.theme.ChatTheme.colors
import io.getstream.chat.android.compose.ui.theme.ChatTheme.shapes
import ven.canasta.core.designsystem.theme.CanastaTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ChannelsScreen() {

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )  {
        var showMenu by remember { mutableStateOf(false) }

        Box(
            Modifier
                .clickable { showMenu = true }
                .background(Color.Green)
                .padding(8.dp)
                .border(1.dp, Color.Black)
        ) {
            Text("<chanels-screen>")
        }

        AnimatedVisibility(
            visible = showMenu,
            enter = fadeIn(),
            exit = fadeOut(animationSpec = tween(durationMillis = AnimationConstants.DefaultDurationMillis / 2))
        ) {

            ChannelMenus(
                modifier = Modifier.clickable { showMenu = false }
                    .align(Alignment.BottomCenter)
                    .animateEnterExit(
                        enter = slideInVertically(
                            initialOffsetY = { height -> height },
                            animationSpec = tween()
                        ),
                        exit = slideOutVertically(
                            targetOffsetY = { height -> height },
                            animationSpec = tween(durationMillis = AnimationConstants.DefaultDurationMillis / 2)
                        )
                    ),
                onDismiss = { showMenu = false }
            )
//            CanastaMenu(
//                Modifier
//                    .align(Alignment.BottomCenter)
//                    .animateEnterExit(
//                        enter = slideInVertically(
//                            initialOffsetY = { height -> height },
//                            animationSpec = tween()
//                        ),
//                        exit = slideOutVertically(
//                            targetOffsetY = { height -> height },
//                            animationSpec = tween(durationMillis = AnimationConstants.DefaultDurationMillis / 2)
//                        )
//                    )
//
//            )

        }
    }
}


val bottomSheet = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)

@Composable
fun ChannelMenus(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = {}
) {
    Box (
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .clickable(
                onClick = onDismiss,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
        ) {
        Card(
            modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.Yellow)
                .height(128.dp)
                .padding(top = 8.dp)
                .border(1.dp, Color.Black)
                .clickable(
                    onClick = {},
                    indication = null,
                    interactionSource =  remember { MutableInteractionSource()  }
                )
                ,
             shape = bottomSheet, // ChatTheme.shapes.bottomSheet,
             backgroundColor = Color.White // ChatTheme.colors.barsBackground
        ) {
            Column(
                Modifier.padding(top = 16.dp),
                verticalArrangement= Arrangement.Top,
                horizontalAlignment= Alignment.CenterHorizontally,
            ) {
                Text("<CHANNEL-MENU>")
                Text("[ ... channel menu details ... ]")
            }
        }
    }
}


@Preview(name="channels-screen", showBackground=true)
@Composable
fun ChannelsScreenPreview() {

    CanastaTheme() {
       Box(
           Modifier.fillMaxSize(),
           contentAlignment = Alignment.Center
       )  {
           ChannelsScreen()
       }
    }
}




@Composable
fun CanastaMenu(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = {},
    //headerContent: @Composable ColumnScope.() -> Unit = {},
    // centerContent: @Composable ColumnScope.() -> Unit = {},
) {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .clickable(
                onClick = onDismiss,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
    ) {
        Card(
            modifier = modifier
                .clickable(
                    onClick = {},
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ),
            // shape = shape,
            backgroundColor = colors.barsBackground
        ) {
            Column {
                //           headerContent()

                ChannelMenus()
                // centerContent()
            }
        }
    }

}


