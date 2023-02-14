package ven.canasta.feature.grocery.inbox.mock.inbox

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ven.canasta.core.designsystem.theme.CanastaTheme
import ven.canasta.core.designsystem.theme.eniaBold
import ven.canasta.core.designsystem.theme.eniaSemiBold
import ven.canasta.feature.grocery.inbox.R
import ven.canasta.core.ui.mock.Black60
import ven.canasta.core.ui.mock.Green60

@Composable
fun EmptyInbox() {

    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
        Column(
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {// NoListYet Hero //
            Image( // HeroPic
                painter = painterResource(R.drawable.empty_list),
                contentDescription = "no list yet!",
                modifier = Modifier
                    .width(240.dp)
                    .height(180.dp)
                    .padding(top = 24.dp, bottom = 4.dp)
                    //.border(1.dp, Gray40)
            )
            Text(
                "Aún no hay listas",
                modifier = Modifier//.border(1.dp, Gray40)
                .padding(top= 4.dp, bottom= 4.dp),
                style = TextStyle(
                    fontFamily = eniaBold,
                    fontWeight = FontWeight(600),
                    fontSize = 18.sp,
                    color = Black60
                )
            )
            Text(
                "Las listas que escribas seran guardadas aqui.",
                modifier = Modifier//.border(1.dp, Gray40)
                .padding(top= 4.dp, bottom= 4.dp),
                style = TextStyle(
                    fontFamily = eniaSemiBold,
                    fontWeight = FontWeight(400),
                    fontSize = 15.sp,
                    color = Black60
                )
            )
            Text(
                "Crear una lista",
                modifier = Modifier.padding(top = 24.dp),
                style = TextStyle(
                    color = Green60, // Blue80,
                    fontWeight = FontWeight(600),
                    fontFamily = eniaSemiBold,
                    fontSize = 18.sp
                )
            )

        }
    }
}


@Preview(name="empty-inbox", showBackground = true)
@Composable()
fun EmptyInboxPreview() {
    CanastaTheme {
        Box(Modifier.fillMaxWidth()) {
            EmptyInbox()
        }
    }
}

@Preview(name="pic", showBackground = true)
@Composable
fun PicPreview() {
    Text("hoal")
   // Image( // HeroPic
   //     painter = painterResource(R.drawable.empty_list),
   //     contentDescription = "no list yet!",
   //     modifier = Modifier.width(120.dp).height(120.dp)
   // )
}