package ven.canasta.core.ui.mock.layout

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ven.canasta.core.ui.mock.layout.header.GroceryHeader

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GroceryLayout(
    bottomMenu: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    var showMenu by remember { mutableStateOf(true) }

    Box() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp),
            verticalArrangement = Arrangement.Top
        ) {
            GroceryHeader(
                modifier = Modifier//.border(1.dp, Color.Red)
            )
            Surface(
                Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp
                    )
            ) {
                content()
            }
        }
        AnimatedVisibility(
            visible = showMenu,
            enter = fadeIn(),
            exit = fadeOut(animationSpec = tween(durationMillis = AnimationConstants.DefaultDurationMillis / 2))
        ) {

            BottomMenus(
                modifier = Modifier
                    .clickable { showMenu = false }
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
                onDismiss = { showMenu = false },
                bottomMenu
            )

        }
    }
}



val bottomSheet = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)

@Composable
fun BottomMenus(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Box (
        modifier = Modifier
            .background(Color.White.copy(alpha = 0.85f))
            .fillMaxSize()
            .clickable(
                onClick = onDismiss,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
    ) {
        androidx.compose.material.Card(
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
                    interactionSource = remember { MutableInteractionSource() }
                ),
            shape = bottomSheet, // ChatTheme.shapes.bottomSheet,
            backgroundColor = Color.White // ChatTheme.colors.barsBackground
        ) {
            Column(
                Modifier.padding(top = 16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                content()
            }
        }
    }
}