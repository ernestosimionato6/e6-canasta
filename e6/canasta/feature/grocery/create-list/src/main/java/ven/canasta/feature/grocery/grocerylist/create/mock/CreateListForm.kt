package ven.canasta.feature.grocery.grocerylist.create.mock

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ven.canasta.core.designsystem.theme.CanastaTheme
import ven.canasta.core.designsystem.theme.enia
import ven.canasta.core.designsystem.theme.enia3
import ven.canasta.core.designsystem.theme.enia3SemiBold
import ven.canasta.core.designsystem.theme.eniaBold
import ven.canasta.core.ui.mock.Black60
import ven.canasta.core.ui.mock.Black80
import ven.canasta.core.ui.mock.Gray60
import ven.canasta.core.ui.mock.Gray80
import ven.canasta.core.ui.mock.Green60

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CreateListForm(
    navigateToAddItemToList: (String) -> Unit = { listId -> {}}
) {

    var showStoreChooserMenu by remember { mutableStateOf(false) }
    Box() {

        Column(
            Modifier
                .fillMaxWidth()
                //.border(0.5.dp, Gray60)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
            //     .border(0.5.dp, Gray60)
            ,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start

        ) {
            FormHeader {
                FormTitle("Lista del supermercado")
            }
            StoreSelect(
                onClick = { showStoreChooserMenu = true }
            )
            Divider(
                thickness = 1.dp, color = Gray60,
                modifier = Modifier.padding(top = 0.dp, bottom = 16.dp)
            )
            TitleField("lista del 2 de enero")
            DescriptionField("Ingredientes para la cena de hoy.")
            Divider(
                thickness = 1.dp, color = Gray60,
                modifier = Modifier.padding(top = 24.dp, bottom = 20.dp)
            )
            CoverPhotoPicker()

            Spacer(Modifier.weight(1f))
            Divider(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 18.dp),
                thickness = 1.dp,
                color = Gray60
            )
            NextButton(
               onClick = {
                   Log.d("GROCERY", "CreateListForm: Next Button clicked. ")
                   navigateToAddItemToList("lista-1")
               }
            )
            Divider(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                thickness = 1.dp,
                color = Gray60
            )

        }


        AnimatedVisibility(
            visible = showStoreChooserMenu,
            enter = fadeIn(),
            exit = fadeOut(animationSpec = tween(durationMillis = AnimationConstants.DefaultDurationMillis / 2))
        ) {

            StoreChooserBottomMenus(
                modifier = Modifier
                    .clickable { showStoreChooserMenu = false }
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
                onDismiss = { showStoreChooserMenu = false },
                content = {
                    StoreChooser(
                       dismiss = { showStoreChooserMenu = false }
                    ){ storeId: String ->
                        showStoreChooserMenu = false
                        Log.d("GROCERY", "CreateListForm: {$storeId}")
                    }
                }
            )

        }

    }
}

@Composable
fun StoreChooser(
    dismiss: () -> Unit = {},
    onSelected: (String) -> Unit = { storeId: String -> {}}
)  {

    Column(
        Modifier
            .fillMaxSize()
            .clickable(
                onClick = {
                    Log.d("GROCERY", "StoreChooser: dismiss. ")
                    dismiss()
                })
            .background(Color.White) // .copy(alpha = 0.5f))
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
    ) {

        StoreSelect( onClick = { onSelected("coto") } )
        StoreSelect( onClick = { onSelected("dia") } )
        StoreSelect( onClick = { onSelected("carrefour") } )
        StoreSelect( onClick = { onSelected("disco") } )
        StoreSelect( onClick = { onSelected("jumbo") } )
        StoreSelect( onClick = { onSelected("la economia") } )

    }

}

@Composable
fun FormHeader(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 16.dp)
      //  .border(0.5.dp, Gray60)
    ,
    content: @Composable () -> Unit
) {
    Row(modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Composable
fun NextButton(
    modifier: Modifier = Modifier.fillMaxWidth(),
    onClick: () -> Unit = {}
) {
    Row(
        Modifier
            .clickable(onClick = onClick)
            .padding(bottom = 24.dp)
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(25))
            .background(Green60),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Next",
            style = TextStyle(
                fontFamily = enia3SemiBold,
                fontSize = 18.sp,

            ),
            color = White
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleField(s: String,
    label: String = "Escribi un titulo", // titulo",
    placeholder: String = "Escibi un comentario",
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        value = s,
        onValueChange = {},
        textStyle = TextStyle(
                fontFamily = enia3, // SemiBold, // eniaSemiBold,
                color = Companion.Black, //Black80,
                fontSize = 18.sp
        ),
        label = { Text(
            text = label,
            style = TextStyle(
                fontFamily = enia, // Bold,
                color = Black60
            )
        ) },
        singleLine = true,
        shape = RoundedCornerShape(25),
        colors = TextFieldDefaults.outlinedTextFieldColors(
      //      focusedBorderColor = Green60,
            unfocusedBorderColor = Gray80
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescriptionField(s: String,
    label: String = "Escribi un comentario", // titulo",
    placeholder: String = "Escibi un comentario",
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 4.dp)
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(164.dp),
        value = s,
        onValueChange = {},
        textStyle = TextStyle(
                fontFamily = enia, // SemiBold,
                color = Black80,
                fontSize = 15.sp
        ),
        label = { Text(
            text = label,
            style = TextStyle(
                fontFamily = enia, // Bold,
                color = Black60
            )
        ) },
        singleLine = false,
        maxLines = 5,
        shape = RoundedCornerShape(10),
        colors = TextFieldDefaults.outlinedTextFieldColors(
       //     focusedBorderColor = Green60,
            unfocusedBorderColor = Gray80
        )
    )
}

@Composable
fun FormTitle(s: String,
    style: TextStyle = TextStyle(
        color = Black80,
        fontFamily = eniaBold,
        fontSize = 31.sp
    )
) {
    Text(s, style = style)
}


@Preview(name="create-list-form", showBackground = true)
@Composable()
fun CreateListFormPreview() {
    CanastaTheme {
        Surface(Modifier.fillMaxWidth()) {
            CreateListForm()
        }
    }
}




val bottomSheet = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)

@Composable
fun StoreChooserBottomMenus(
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
                //  .background(Color.Yellow)
                .height(768.dp) // 624.dp) // 768.dp) // 256.dp) // 128.dp)
                //   .padding(top = 8.dp)
                //   .border(1.dp, Color.Black.copy(alpha = 0.3f))
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