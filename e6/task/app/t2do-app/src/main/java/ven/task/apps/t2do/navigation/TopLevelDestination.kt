package ven.task.apps.t2do.navigation

import com.google.samples.apps.nowinandroid.core.designsystem.icon.Icon
import com.google.samples.apps.nowinandroid.core.designsystem.icon.Icon.DrawableResourceIcon
import com.google.samples.apps.nowinandroid.core.designsystem.icon.Icon.ImageVectorIcon
import com.google.samples.apps.nowinandroid.core.designsystem.icon.NiaIcons
import ven.task.apps.t2do.R
import com.google.samples.apps.nowinandroid.feature.bookmarks.R as bookmarksR
import com.google.samples.apps.nowinandroid.feature.foryou.R as forYouR
import com.google.samples.apps.nowinandroid.feature.interests.R as interestsR

/**
 * Type for the top level destinations in the application. Each of these destinations
 * can contain one or more screens (based on the window size). Navigation from one screen to the
 * next within a single destination will be handled directly in composables.
 */
enum class TopLevelDestination(
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val iconTextId: Int,
    val titleTextId: Int
) {
    FOR_YOU(
        selectedIcon = DrawableResourceIcon(NiaIcons.Upcoming),
        unselectedIcon = DrawableResourceIcon(NiaIcons.UpcomingBorder),
        iconTextId = forYouR.string.for_you,
        titleTextId = R.string.app_name
    ),
    BOOKMARKS(
        selectedIcon = DrawableResourceIcon(NiaIcons.Bookmarks),
        unselectedIcon = DrawableResourceIcon(NiaIcons.BookmarksBorder),
        iconTextId = bookmarksR.string.saved,
        titleTextId = bookmarksR.string.saved
    ),
    INTERESTS(
        selectedIcon = ImageVectorIcon(NiaIcons.Grid3x3),
        unselectedIcon = ImageVectorIcon(NiaIcons.Grid3x3),
        iconTextId = interestsR.string.interests,
        titleTextId = interestsR.string.interests
    )
}
