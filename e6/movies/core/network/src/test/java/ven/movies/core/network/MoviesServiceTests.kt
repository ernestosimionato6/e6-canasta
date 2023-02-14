package ven.movies.core.network

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test
import ven.movies.core.network.api.MoviesNetworkServiceImpl

class MoviesServiceTests {


    @Test
    fun test() {
        val service = MoviesNetworkServiceImpl()
        runTest {
            print(service.getMovies())
            print("[e6:movies:network] testing networking.")
            assertEquals(true, true)
        }
    }

}