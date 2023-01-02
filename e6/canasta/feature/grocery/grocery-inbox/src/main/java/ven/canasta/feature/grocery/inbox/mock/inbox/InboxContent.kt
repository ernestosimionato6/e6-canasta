package ar.ven.apps.gro.feature.inbox.mock.inbox

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import ven.canasta.feature.grocery.inbox.mock.inbox.EmptyInbox

@Composable
public fun InboxContent()  {
    val isEmpty = true // by remember { mutableStateOf(true) }

    if(isEmpty)
        EmptyInbox()
    else
        Text("<inbox-content>")
}

