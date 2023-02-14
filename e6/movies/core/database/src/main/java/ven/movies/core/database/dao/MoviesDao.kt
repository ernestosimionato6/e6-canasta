package ven.movies.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ven.movies.core.database.model.MovieEntity
import ven.movies.core.database.model.PartialMovieEntity

@Dao
interface MoviesDao {

  @Query("SELECT * FROM movies")
  suspend fun getAll(): List<MovieEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun addAll(movies: List<MovieEntity>)

  @Update(entity = MovieEntity::class)
  suspend fun update(partialMovie: PartialMovieEntity)

  @Update(entity = MovieEntity::class)
  suspend fun updateAll(partialMovies: List<PartialMovieEntity>)

  @Query("SELECT * FROM movies WHERE is_favorite = 1")
  suspend fun getAllFavorited(): List<MovieEntity>
}