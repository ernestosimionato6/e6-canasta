package ven.movies.core.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider

class MoviesDatabaseBuilder {

    fun createDb(): MoviesDatabase {

        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.inMemoryDatabaseBuilder(
            context,
            MoviesDatabase::class.java
        ).build()
        return db
    }

}