package com.google.samples.apps.niacatalog.demo

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldDemo() {
    Column(Modifier.padding(16.dp)) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it }
        )
        Text("The textfield has this text: " + textState.value.text)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VnTextField(
    text: String,
    onTextChange: (String) -> Unit
) {

    val textState = remember { mutableStateOf(TextFieldValue(text)) }

    TextField(
        value = textState.value,
        onValueChange = {
            textState.value = it
            onTextChange(it.text)
        }
    )
}

@Preview(name="vn-text-field", showBackground=true)
@Composable
fun DemoScreenPreview() {

    @Composable
    fun DemoScreen() {
        var textState by rememberSaveable { mutableStateOf("$ 500")}

        val onTextChange = { text: String ->
            textState = text
        }

        Box(
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Black)
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text("[ vn-text-field ] ${textState}")
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    VnTextField(text = textState, onTextChange = onTextChange)
                }
            }
        }
    }

    NiaTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            DemoScreen()
        }
    }
}

