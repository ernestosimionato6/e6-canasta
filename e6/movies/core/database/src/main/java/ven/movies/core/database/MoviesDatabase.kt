package ven.movies.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ven.movies.core.database.dao.MoviesDao
import ven.movies.core.database.model.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = true
)
abstract class MoviesDatabase : RoomDatabase() {

    abstract val moviesDao: MoviesDao
}