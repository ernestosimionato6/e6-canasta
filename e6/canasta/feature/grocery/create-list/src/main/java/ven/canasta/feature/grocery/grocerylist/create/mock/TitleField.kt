
package ven.canasta.feature.grocery.grocerylist.create.mock

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment.Center
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import ven.canasta.core.designsystem.theme.CanastaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun XTitleField(s: String,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    var text by remember { mutableStateOf("Hello") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },

        // modifier = Modifier.clip(RoundedCornerShape(12.dp)),
        label = {}, // "", // { Text("Label") },

        modifier = Modifier.border(
                BorderStroke(
                    width = 2.dp,
                    color = Companion.Green
                ),
                    shape = RoundedCornerShape(50)
        ),

        colors = TextFieldDefaults.run {
            textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        },
        // textStyle = inputTextStyle,


    )
}

@Preview(name="title-field", showBackground = true)
@Composable
fun TitleFieldPreview() {

    CanastaTheme {
        Box(
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            FlowColumn(
                Modifier.fillMaxWidth()
                    .height(200.dp),
                mainAxisSpacing = 20.dp,
                mainAxisAlignment = FlowMainAxisAlignment.Center,
                crossAxisAlignment = Center
            ) {
                XTitleField(
                    s = "hola mundo",
                )
                BasicTextField(
                    value = "12341234",
                    onValueChange = {},
                )
            }
        }

    }
}