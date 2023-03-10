package ven.canasta.core.ui

import android.content.Context
import android.net.Uri
import androidx.annotation.ColorInt
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.samples.apps.nowinandroid.core.domain.model.SaveableNewsResource
import com.google.samples.apps.nowinandroid.core.model.data.previewNewsResources
import ven.canasta.core.designsystem.theme2.Nia2Theme
import ven.canasta.core.ui.NewsFeedUiState.Loading
import ven.canasta.core.ui.NewsFeedUiState.Success

/**
 * An extension on [LazyListScope] defining a feed with news resources.
 * Depending on the [feedState], this might emit no items.
 */
fun LazyGridScope.newsFeed(
    feedState: NewsFeedUiState,
    onNewsResourcesCheckedChanged: (String, Boolean) -> Unit
) {
    when (feedState) {
        Loading -> Unit
        is Success -> {
            items(feedState.feed, key = { it.newsResource.id }) { saveableNewsResource ->
                val resourceUrl by remember {
                    mutableStateOf(Uri.parse(saveableNewsResource.newsResource.url))
                }
                val context = LocalContext.current
                val backgroundColor = MaterialTheme.colorScheme.background.toArgb()

                NewsResourceCardExpanded(
                    newsResource = saveableNewsResource.newsResource,
                    isBookmarked = saveableNewsResource.isSaved,
                    onClick = { launchCustomChromeTab(context, resourceUrl, backgroundColor) },
                    onToggleBookmark = {
                        onNewsResourcesCheckedChanged(
                            saveableNewsResource.newsResource.id,
                            !saveableNewsResource.isSaved
                        )
                    }
                )
            }
        }
    }
}

fun launchCustomChromeTab(context: Context, uri: Uri, @ColorInt toolbarColor: Int) {
    val customTabBarColor = CustomTabColorSchemeParams.Builder()
        .setToolbarColor(toolbarColor).build()
    val customTabsIntent = CustomTabsIntent.Builder()
        .setDefaultColorSchemeParams(customTabBarColor)
        .build()

    customTabsIntent.launchUrl(context, uri)
}

/**
 * A sealed hierarchy describing the state of the feed of news resources.
 */
sealed interface NewsFeedUiState {
    /**
     * The feed is still loading.
     */
    object Loading : NewsFeedUiState

    /**
     * The feed is loaded with the given list of news resources.
     */
    data class Success(
        /**
         * The list of news resources contained in this feed.
         */
        val feed: List<SaveableNewsResource>
    ) : NewsFeedUiState
}

@Preview
@Composable
private fun NewsFeedLoadingPreview() {
    Nia2Theme {
        LazyVerticalGrid(columns = GridCells.Adaptive(300.dp)) {
            newsFeed(
                feedState = Loading,
                onNewsResourcesCheckedChanged = { _, _ -> }
            )
        }
    }
}

@Preview
@Preview(device = Devices.TABLET)
@Composable
private fun NewsFeedContentPreview() {
    Nia2Theme {
        LazyVerticalGrid(columns = GridCells.Adaptive(300.dp)) {
            newsFeed(
                feedState = Success(
                    previewNewsResources.map {
                        SaveableNewsResource(
                            it,
                            false
                        )
                    }
                ),
                onNewsResourcesCheckedChanged = { _, _ -> }
            )
        }
    }
}
