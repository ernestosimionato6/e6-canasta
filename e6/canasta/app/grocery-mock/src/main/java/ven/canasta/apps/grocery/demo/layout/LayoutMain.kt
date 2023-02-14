package ven.canasta.apps.grocery.demo.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme
import ven.canasta.core.designsystem.theme.Eina1Family
import ven.canasta.core.designsystem.theme.Eina2Family
import ven.canasta.core.designsystem.theme.Eina3Family
import ven.canasta.core.designsystem.theme.enia3
import ven.canasta.core.designsystem.theme.enia3Bold
import ven.canasta.core.designsystem.theme.enia3SemiBold
import ven.canasta.core.designsystem.theme.eniaBold
import ven.canasta.core.designsystem.theme.eniaSemiBold

@Composable
fun LayoutMain() {
}

@Preview(name="layout-demo5", showBackground = true)
@Composable
fun Rows2Preview(
) {
    VnColumnPreview {
        Text("[ Layout #1 ]", fontSize = 24.sp)
        Text("[ Layout #2 ]", fontSize = 24.sp , fontFamily = Eina1Family)
        Text("[ Layout #3 ]", fontSize = 24.sp , fontFamily = Eina2Family)
        Text("[ Layout #4 ]", fontSize = 24.sp , fontFamily = Eina3Family)
        Text("[ Layout #5 ]", fontSize = 24.sp , fontFamily = Eina1Family)
        Text("[ Layout #6 ]", fontSize = 24.sp , fontFamily = Eina1Family)

        Text("[ Layout #7 ]", fontSize = 24.sp , fontFamily = eniaSemiBold)
        Text("[ Layout #8 ]", fontSize = 24.sp , fontFamily = enia3Bold)
        Text("[ Layout #9 ]", fontSize = 24.sp , fontFamily = eniaBold)
        Text("[ Layout #10 ]", fontSize = 24.sp, fontFamily = enia3)
        Text("[ Layout #11 ]", fontSize = 24.sp, fontFamily = enia3SemiBold)
    }
}

@Composable
fun VnPreview(
    content: @Composable () -> Unit
) {
    NiaTheme {
        Box(
            Modifier
                .fillMaxSize()
                .padding(8.dp)
                .border(1.dp, Black)
                .padding(16.dp),
            contentAlignment = Alignment.TopCenter,
        ) {
            content()
        }
    }
}

@Composable
fun VnColumnPreview(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    VnPreview {
        Column(
            modifier = Modifier
                .background(Yellow.copy(alpha = 0.15F))
                .fillMaxSize()
                .padding(4.dp)
                .border(1.dp, Black)
                .padding(16.dp)
                .then(modifier),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            content()
        }
    }
}