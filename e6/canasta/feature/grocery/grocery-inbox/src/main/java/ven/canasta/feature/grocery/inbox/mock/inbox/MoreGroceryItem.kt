package ven.canasta.feature.grocery.inbox.mock.inbox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ven.canasta.core.designsystem.layout.VnRowPreview
import ven.canasta.core.designsystem.theme.enia
import ven.canasta.core.designsystem.theme.eniaBold
import ven.canasta.core.ui.mock.Black60
import ven.canasta.core.ui.mock.Black80
import ven.canasta.core.ui.mock.Gray40
import ven.canasta.core.ui.mock.Green60
import ven.canasta.grocerylist.GroceryBackground.Companion

@Composable
fun MoreGroceryItem(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.then(modifier)
    ) {
        Spacer(Modifier.weight(2f, true))
        Text(
            "+54",
            maxLines = 2,
            color = Black80,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontFamily = eniaBold,
        )
        Spacer(Modifier.weight(0.5f, true))
        Text(
            "Productos adicionales",
            maxLines = 2,
            color = Black60,
             lineHeight = 15.sp,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            fontFamily = eniaBold,
        )
        Spacer(Modifier.weight(1f, true))
        Text(
            "Ver todas",
            color = Green60.copy(alpha=0.75f),
             lineHeight = 15.sp,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            fontFamily = eniaBold,
        )
        Spacer(Modifier.weight(1f, true))
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(48.dp)
                .clip(CircleShape)
                .border(2.dp, Green60.copy(alpha=0.65f), CircleShape)
                .background(Green60.copy(alpha=0.35f))
        ) {
            Text(
                ">",
                color = Color.White,
                fontSize = 28.sp,
                fontFamily = eniaBold, // Bold, // Eina1Family,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.TopCenter)

            )
        }
        Spacer(Modifier.weight(5f, true))

    }
}

@Preview(name="more-grocery-item", showBackground=true)
@Composable
fun MoreGroceryItemPreview() {
    VnRowPreview(
        modifier = Modifier.height(300.dp)
    ){
        MoreGroceryItem(
            Modifier.fillMaxHeight()
                .padding(2.dp)
                .border(0.1.dp, Black80)
                .padding(2.dp)
                .background(White)
                .weight(1f, true)
        )
        MoreGroceryItem(
            Modifier.fillMaxHeight()
                .padding(2.dp)
                .border(0.1.dp, Black80)
                .padding(2.dp)
                .background(White)
                .weight(1f, true)
        )
        MoreGroceryItem(
            Modifier.fillMaxHeight()
                .padding(2.dp)
                .border(0.1.dp, Black80)
                .padding(2.dp)
                .background(White)
                .weight(1f, true)
        )
    }
}


@Composable
fun MoreGroceryItem2(
    modifier: Modifier = Modifier
) {
    // Box(
    //     contentAlignment = Alignment.TopCenter,
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        // modifier = Modifier
        //     .padding(16.dp)
        //     .width(135.dp)
        //     .height(280.dp)
        //     .then(modifier),
    ) {

        Text(
            "Productos adicionales",
            color = Black80,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontFamily = eniaBold, // Eina1Family,
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Gray40)
                .padding(horizontal = 8.dp, vertical = 24.dp),
        )
    }
}
