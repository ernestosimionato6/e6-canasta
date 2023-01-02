package ar.ven.apps.gro.feature.inbox.mock.layout.header

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme
import ven.canasta.core.designsystem.theme.EniaFamily
import ven.canasta.feature.grocery.inbox.mock.Blue40
import ven.canasta.feature.grocery.inbox.mock.Gray40
import ven.canasta.feature.grocery.inbox.mock.Gray60

@Composable
public fun GroceryHeader(modifier: Modifier = Modifier) {
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
            GroceryTopBar()
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(30.dp) // 48
            .padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            GroLocationSelector()
        }
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
            GroProductsSearchBar()
        }
        Divider( thickness = 1.dp, color = Gray60)
    }
}


@SuppressLint("DesignSystem")
@Composable
fun GroProductsSearchBar() {
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
            Text("Buscar productos o tiendas...",
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
fun GroceryHeaderPreview() {

        NiaTheme { // NiaTheme {  //  GroTheme() {

            Column(modifier = Modifier.fillMaxSize()){
                GroceryHeader(Modifier)
                Box(modifier = Modifier.border(1.dp, Blue40))
            }
        }

}


