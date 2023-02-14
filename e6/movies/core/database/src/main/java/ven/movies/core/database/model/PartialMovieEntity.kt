package ven.movies.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class PartialMovieEntity (
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean
)
