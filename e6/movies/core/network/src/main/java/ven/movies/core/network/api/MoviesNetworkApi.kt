package ven.movies.core.network.api

import retrofit2.http.GET
import retrofit2.http.Query
import ven.movies.core.domain.model.MoviesResponse

interface MoviesNetworkApi {

    // @GET("movies/now_playing")
    @GET("movies")
    suspend fun getMovies(
        @Query("api_key") apikey: String
    ): MoviesResponse
}