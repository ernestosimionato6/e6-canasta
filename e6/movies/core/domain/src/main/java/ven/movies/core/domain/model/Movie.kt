package ven.movies.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/* 181.47.108.159 */

/* 181.46.255.96 */
@Parcelize
data class Movie(
    val id: Int = 0,
    val title: String = "",
    val overview: String = "",
    val poster_path: String = "",
    val popularity: Float = 0f,
    val vote_average: Float = 0f,
    val vote_count: Int = 0
) : Parcelable
