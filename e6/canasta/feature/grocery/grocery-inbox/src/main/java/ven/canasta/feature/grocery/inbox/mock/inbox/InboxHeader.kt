package ar.ven.apps.gro.feature.inbox.mock.inbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ven.canasta.core.designsystem.theme.CanastaTheme
import ven.canasta.core.designsystem.theme.eniaBold
import ven.canasta.feature.grocery.inbox.mock.Black80
import ven.canasta.feature.grocery.inbox.mock.Green60

@Composable
public fun InboxHeader(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                bottom = 16.dp
            )
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}


@Composable
public fun InboxTitle(s: String) {
    Text( s,
        style = TextStyle(
            color = Black80, // Color(52, 53, 56),
            fontFamily = eniaBold,
            fontSize = 31.sp
        )
    )
}


@Composable
public fun CreateListButton(s: String) {
    Text(
        s,
        style = TextStyle(
            color = Green60, // Color(10, 173, 10),
            fontFamily = eniaBold,
            fontWeight = FontWeight(600),
            fontSize = 15.sp
        )
    )
}


@Preview(name="inbox-header", showBackground=true)
@Composable
fun InboxHeaderPreview() {
   CanastaTheme {
        Surface(modifier = Modifier.fillMaxWidth()) {
            InboxHeader{
                InboxTitle("Tus listas") //  de compra")
                CreateListButton("crear nueva") //  lista")
            }
        }
   }
}