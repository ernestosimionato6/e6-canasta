package ar.ven.apps.gro.feature.inbox.mock


import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import ar.ven.apps.gro.feature.inbox.mock.inbox.InboxView
import ar.ven.apps.gro.feature.inbox.mock.layout.GroceryLayout

import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme
import ven.canasta.core.designsystem.theme.CanastaTheme

@Composable
fun OnboardingMock() {

    GroceryLayout{
       InboxView()
    }

}

@Preview(name="grocery-onboarding-mock", showBackground = true, showSystemUi = true)
@Composable
fun OnboardingMockPreview() {

        CanastaTheme {
        OnboardingMock()
    }
}