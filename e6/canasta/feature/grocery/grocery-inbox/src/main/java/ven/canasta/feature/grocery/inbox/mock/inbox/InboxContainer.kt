package ar.ven.apps.gro.feature.inbox.mock.inbox

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable

@Composable
public fun InboxContainer(
    content: @Composable ColumnScope.() -> Unit
) {
    Column {
        content
    }
}