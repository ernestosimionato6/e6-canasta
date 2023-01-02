package ar.ven.apps.gro.feature.inbox.mock.layout.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ven.canasta.core.designsystem.theme.EniaFamily
import ven.canasta.core.designsystem.theme.enia3Bold
import ven.canasta.feature.grocery.inbox.R

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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),  // 18
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.canasta3),
            contentDescription = "",
            modifier = Modifier
                .size(28.dp) // 32
                .padding(horizontal = 4.dp)
                .padding(top = 4.dp)
        )
        Text(
            "canasta",
            fontFamily = enia3Bold, // EniaFamily,
            letterSpacing = -1.sp,
            fontSize = 28.sp, // 32
            color = Color(53, 86, 250).copy(alpha = .95f)
        )
        // CartButton()
    }
}