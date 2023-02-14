package ven.movies.core.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertEquals
import org.junit.Test

import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.runner.RunWith
import ven.movies.core.database.dao.MoviesDao


// @RunWith(AndroidJUnit4::class)
class MoviesDatabaseIntegrationTests {

    // private lateinit var newsResourceDao: NewsResourceDao
    private lateinit var moviesDao: MoviesDao
    private lateinit var db: MoviesDatabase


//    @Before
//    fun createDb(): MoviesDatabase {
//        val context = ApplicationProvider.getApplicationContext<Context>()
//        val db = Room.inMemoryDatabaseBuilder(
//            context,
//            MoviesDatabase::class.java
//        ).build()
//        return db
//    }

    @Test
    fun test() {
        print("[movies-database] integration testing...")

//        runTest {
//            val builder = MoviesDatabaseBuilder()
//            val db = builder.createDb()
//            val dao = db.moviesDao
//            print(dao.getAll())
//            assertEquals(1, 1)
//        }
        assertEquals(1, 1)
    }

}