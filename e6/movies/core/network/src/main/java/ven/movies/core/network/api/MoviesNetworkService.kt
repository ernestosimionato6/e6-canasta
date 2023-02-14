package ven.movies.core.network.api

import ven.movies.core.domain.model.Movie

interface MoviesNetworkService {

    suspend fun getMovies(): List<Movie>
}