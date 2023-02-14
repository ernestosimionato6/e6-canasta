package ven.movies.core

import ven.movies.core.domain.model.Movie
import kotlin.Float.Companion

object DummyMovies {

    fun getDomainMovies() = arrayListOf(
        Movie(
            0,
            "The last us",
            "",
            "/last_us.png",
            9.0f,
            vote_average = 5.0f,
            vote_count = 200
        ),
        Movie(
            0,
            "Lord of rings",
            "",
            "/lord_rings.png",
            9.5f,
            vote_average = 9.8f,
            vote_count = 1500
        )
    )

}

