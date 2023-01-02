package ven.canasta.feature.grocery.inbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import ar.ven.apps.gro.feature.inbox.mock.OnboardingMock
import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun GroceryInboxRoute(
) {

    GroceryInboxScreen(
    )
}

@Composable
internal fun GroceryInboxScreen(
) {
    OnboardingMock()
}

@Preview(name="grocery-inbox-screen", showBackground = true)
@Composable
fun GroceryInboxScreenPreview() {
   NiaTheme {
      GroceryInboxScreen()
   }
}
