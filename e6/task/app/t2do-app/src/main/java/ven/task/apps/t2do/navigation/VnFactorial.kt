package ven.task.apps.t2do.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ven.canasta.core.designsystem.theme.enia3Bold

@SuppressLint("DesignSystem")
@Composable
fun VnFactorial() {
    var expanded by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf(factorialAsString(0)) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.clickable {
                expanded = true
            },
            text = text,
            style = MaterialTheme.typography.titleMedium
        )
        Column(
           horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top

        ) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }) {
                for (n in 0 until 10) {
                    androidx.compose.material.DropdownMenuItem(
                        onClick = {
                            expanded = false
                            text = factorialAsString(n)
                        }
                    ) {
                        Text("${n.toString()}!")
                    }
                }
            }
        }
    }
}



@SuppressLint("DesignSystem")
@Preview(
    name="vn-factorial",
    showBackground=true
)
@Composable
fun VnFactorialPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        VnFactorial()
    }
}


fun factorialAsString(n: Int): String {
    var result = 1L
    for (i in 1..n) {
        result *= i
    }
    return "$n! = $result"
}