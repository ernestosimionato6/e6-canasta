package ven.task.apps.t2do.navigation

import android.annotation.SuppressLint
import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Vertical
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Horizontal
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import ven.canasta.core.designsystem.theme.CanastaTheme
import ven.canasta.core.designsystem.theme.enia3Bold

@Composable
@SuppressLint("DesignSystem")
fun T2DoInboxScreen(
    navigateToCreateList: () -> Unit
) {
    val  name = remember { mutableStateOf("")}
    val nameEntered = remember { mutableStateOf(false) }

    Column() {

    VnText(
        text = " [ inbox-screen ] ",
        textAlign = Companion.Center ,
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 20.dp)
    )

        VnPanel(
            title = "Button And Text"
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                if(nameEntered.value) {
                    VnText(
                        "[ {$name.value} ]",
                        Modifier.fillMaxWidth()
                    )
                } else {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        VnText("[ ingrese su nombre ]")
                        Spacer(Modifier.height(20.dp))
                        VnTextAndButton(name = name, nameEntered = nameEntered)
                    }
                }
            }
        }

    }
}

@Composable
fun VnPanel(
    title: String,
    modifier: Modifier = Modifier,
    verticalArrangement: Vertical = Arrangement.Top,
    horizontalAlignment: Horizontal = Alignment.Start,
    content: @Composable () -> Unit
) {

Box(
    Modifier
        .fillMaxWidth()
        .then(modifier)
) {
    Column(
       Modifier.fillMaxWidth(),
       verticalArrangement = verticalArrangement,
       horizontalAlignment = horizontalAlignment
    ) {
        VnText(title, Modifier.fillMaxWidth(),
            textAlign = TextAlign.End)
        VnDivider()
        content()
    }
}

}

@Composable
fun VnDivider(modifier: Modifier = Modifier) {
   Divider(modifier)
}

@Composable
fun VnSpacer(modifier: Modifier = Modifier) {
    Spacer(modifier)
}

@Composable
fun VnText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: androidx.compose.ui.text.font.FontFamily = enia3Bold,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current
) {
    Text(
        text =text,
        modifier =modifier,
        color = color,
        fontSize = fontSize,
        fontStyle = null,
        fontWeight = null,
        fontFamily = fontFamily,
        letterSpacing,
        textDecoration,
        textAlign,
        lineHeight,
        overflow,
        softWrap,
        maxLines,
        onTextLayout,
        style
    )
}

@Composable
@Preview(name="t2do-inbox-screen", showBackground = true)
fun T2DoInboxScreenPreview() {

    CanastaTheme {
        Surface {
            T2DoInboxScreen { }
        }
    }
}

