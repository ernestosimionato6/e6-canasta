package ven.canasta.feature.grocery.grocerylist.create.mock

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ven.canasta.core.designsystem.theme.CanastaTheme
import ven.canasta.core.designsystem.theme.eniaBold
import ven.canasta.core.designsystem.theme.eniaSemiBold
import ven.canasta.core.ui.mock.Black60
import ven.canasta.core.ui.mock.Black80
import ven.canasta.feature.grocery.R


@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("DesignSystem")
@Composable
fun StoreSelect(
    modifier: Modifier = Modifier
        // .fillMaxWidth()
        // .padding(top = 14.dp, bottom = 16.dp)
        // .size(72.dp)
       // .background(Color.Yellow.copy(alpha = 0.2f))
     //   .border(0.5.dp, Gray60)
    , onClick: () -> Unit = {}
) {

        Row(
            modifier
                .clickable(onClick = onClick)
                .fillMaxWidth()
                .padding(top = 14.dp, bottom = 16.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    // HeroPic
                    painter = painterResource(R.drawable.placeholder_store),
                    contentDescription = "Elegi tu tienda",
                    //.border(1.dp, Gray40)
                    modifier = Modifier.size(48.dp),
                )
                Column(
                    Modifier.padding(start = 8.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Elige tu tienda",
                        modifier = Modifier//.border(1.dp, Gray40)
                            .padding(top = 4.dp, bottom = 0.dp),
                        style = TextStyle(
                            fontFamily = eniaBold,
                            fontWeight = FontWeight(600),
                            fontSize = 18.sp,
                            color = Black80
                        )
                    )
                    Text(
                        "Listado de los supermercados de cercania.",
                        modifier = Modifier//.border(1.dp, Gray40)
                            .padding(top = 0.dp, bottom = 4.dp),
                        style = TextStyle(
                            fontFamily = eniaSemiBold,
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            color = Black60
                        )
                    )
                }
            }
                    Icon( // IconButton
                    Icons.Outlined.ArrowForwardIos,
                    contentDescription = "More",
                    tint = Black60
                )
        }
}



@Preview(name="store-select", showBackground = true)
@Composable
fun StoreSelectPreview() {
    CanastaTheme() {
        Surface(Modifier.fillMaxWidth()) {
            StoreSelect()
        }
        
    }
}