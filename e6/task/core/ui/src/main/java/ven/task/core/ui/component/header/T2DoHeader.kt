package ven.task.core.ui.component.header

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ven.canasta.core.designsystem.theme.CanastaTheme
import ven.canasta.core.designsystem.theme.EniaFamily
import ven.task.core.ui.R
import ven.task.core.ui.mock.Blue40
import ven.task.core.ui.mock.Gray40
import ven.task.core.ui.mock.Gray60

@Composable
public fun T2DoHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .height(140.dp),

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp)
                .padding(bottom = 4.dp)
        ) {
            T2DoTopBar(
                "planner",
                painterResource(id = R.drawable.shark2),
                Modifier.size(32.dp),
                ContentScale.Crop
            )
        }
//        Row(modifier = Modifier
//            .fillMaxWidth()
//            .height(30.dp) // 48
//            .padding(bottom = 4.dp),
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            GroLocationSelector()
//        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp) // 64
                .padding(horizontal = 24.dp)
                .padding(bottom = 8.dp) // 8.dp
            ,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            T2DoTaskSearchBar(
                "Buscar tareas o projectos..."
            )
        }
        Divider( thickness = 1.dp, color = Gray60)
    }
}


@SuppressLint("DesignSystem")
@Composable
fun T2DoTaskSearchBar(
    placeHolder: String = ""
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .height(48.dp)
                .background(Gray40)
                .padding(top = 4.dp, bottom = 4.dp)
                .padding(start = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(placeHolder,
               style = TextStyle(
                  fontFamily = EniaFamily,
                   fontSize = 16.sp // 18.sp
               ),
                color = Color(52,53,56).copy(alpha = 0.85f),
               modifier = Modifier.align(Alignment.CenterStart)
           )
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(
                    Icons.Outlined.Search, "", Modifier.size(18.dp)
                )
            }
        }
    }
}

@SuppressLint("DesignSystem")
@Composable
fun GroLocationSelector() {
    Row(
        modifier = Modifier
    ){
       Text("Venezuela 2796, Buenos Aires",
           color = Color(52,53,56).copy(alpha = 0.85f),
           style = TextStyle(
              fontFamily = EniaFamily, //eniaSemiBold,
               fontSize = 14.sp
           )
       )
        Icon(Icons.Filled.KeyboardArrowDown, "")
    }
}


@Preview(name="grocery-header2", showBackground = true, showSystemUi = true)
@Composable
fun T2DoHeaderPreview() {

        CanastaTheme { // NiaTheme {  //  GroTheme() {

            Column(modifier = Modifier.fillMaxSize()){
                T2DoHeader(Modifier)
                Box(modifier = Modifier.border(1.dp, Blue40))
            }
        }

}


