package ven.movies.core.domain.model

data class MoviesResponse (
    val page: Int,
    val results: List<Movie>
)