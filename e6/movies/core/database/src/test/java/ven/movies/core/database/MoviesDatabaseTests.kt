package ven.movies.core.database

import junit.framework.TestCase.assertEquals
import org.junit.Test

import kotlinx.coroutines.test.runTest

class MoviesDatabaseTests {


    @Test
    fun test() {
        print("[movies-database] testing...")

        // runTest {
        //     val builder = MoviesDatabaseBuilder()
        //     val db = builder.createDb()
        //     val dao = db.moviesDao
        //     print(dao.getAll())
        //     assertEquals(1, 1)
        // }
        assertEquals(1, 1)
    }

}