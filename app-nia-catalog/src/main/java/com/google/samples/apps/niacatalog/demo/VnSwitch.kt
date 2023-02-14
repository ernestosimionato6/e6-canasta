package com.google.samples.apps.niacatalog.demo

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme

@Composable
fun VnSwitch() {

    var checked = remember { mutableStateOf(true) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("[ vn-switch ]")
        Switch (
           checked = checked.value,
           onCheckedChange =  { checked.value = it }
        )
        if ( checked.value ) {
            Text(" [ switch is on ] ")
        } else {
            Text(" [ switch is off ] ")
        }
    }
}

@Preview(name="vn-switch", showBackground = true)
@Composable
fun VnSwitchPreview() {
    NiaTheme() {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            VnSwitch()
        }
    }
}