package ven.canasta.core.ui.mock.layout.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ven.canasta.core.designsystem.theme.CanastaTheme
import ven.canasta.core.designsystem.theme.enia3Bold
import ven.canasta.core.ui.R
import ven.canasta.core.ui.R.drawable
import ven.canasta.core.ui.mock.Gray40

/**
grid-template-rows: 44px;
grid-auto-rows: min-content;
grid-template-columns: 60px minmax(0,1fr) 60px;
padding-top: 12px;
padding-right: 16px;
padding-bottom: 5px;
padding-left: 16px;

grid-template-areas:
    'menu logo cart'
    'row2 row2 row2'
    'search search search'
    'banner banner banner'
    'fulfillment fulfillment fulfillment';
 */
@Composable
fun GroceryTopBar() {
   GroceryTopBar(
       "canasta",
       painterResource(id = R.drawable.canasta3),
   )
}


@Composable
fun GroceryTopBar(
    appName: String = "",
   logo: Painter =  painterResource(id = drawable.canasta3),
    logoModifier: Modifier = Modifier,
    logoScale: ContentScale = ContentScale.Fit// None
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),  // 18
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = logo, // painterResource(id = R.drawable.canasta3),
            contentDescription = "",
            contentScale = logoScale,
            modifier = logoModifier.then(
                Modifier
                .size(28.dp) // 32
                .padding(horizontal = 4.dp)
                .padding(top = 4.dp)
            )
        )
        Text(
            appName,  // "canasta"
            fontFamily = enia3Bold, // EniaFamily,
            letterSpacing = -1.sp,
            fontSize = 28.sp, // 32
            color = Color(53, 86, 250).copy(alpha = .95f)
        )
        // CartButton()
    }
}


@Preview(name="grocery-top-bar", showBackground=true)
@Composable()
fun GroceryTopBarPreview() {

    CanastaTheme() {
       Surface(
           modifier = Modifier.fillMaxWidth()
       ) {
           Column(

           ) {
               Spacer(
                   Modifier
                       .height(50.dp)
                       .background(Gray40)
                       .border(1.dp, Black))
               GroceryTopBar()
               Spacer(
                   Modifier
                       .height(50.dp)
                       .background(Gray40)
                       .border(1.dp, Black))
               GroceryTopBar(
                  "planner",
                   painterResource(R.drawable.fish1),
                   Modifier
                       .width(36.dp)
                       .height(42.dp),
                   logoScale =  ContentScale.FillBounds
               )
               Spacer(
                   Modifier
                       .height(50.dp)
                       .background(Gray40)
                       .border(1.dp, Black))
              GroceryTopBar(
                  "planner",
                   painterResource(R.drawable.shark2),
                   Modifier.size(32.dp),
                   ContentScale.Crop
               )
               Spacer(
                   Modifier
                       .height(50.dp)
                       .background(Gray40)
                       .border(1.dp, Black))
           }
       }
    }
}
