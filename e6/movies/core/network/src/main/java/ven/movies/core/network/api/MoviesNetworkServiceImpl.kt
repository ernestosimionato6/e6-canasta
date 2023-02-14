package ven.movies.core.network.api

import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import ven.movies.core.domain.model.Movie
import ven.movies.core.network.BuildConfig
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.converter.moshi.MoshiConverterFactory

// private const val NiaBaseUrl = "http://192.168.0.16:6060/" // BuildConfig.BACKEND_URL
private const val NiaBaseUrl = "https://api.vecinos.com.ar/" // BuildConfig.BACKEND_URL

// @Inject constructor(
//     networkJson: Json
// ) : MoviesNetworkService {

// @Singleton
class MoviesNetworkServiceImpl() : MoviesNetworkService {

    private val networkApi = Retrofit.Builder()
        .baseUrl(NiaBaseUrl)
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                )
                .build()
        )
        .addConverterFactory(MoshiConverterFactory.create())
//        .addConverterFactory(
//            @OptIn(ExperimentalSerializationApi::class)
//            networkJson.asConverterFactory("application/json".toMediaType())
//        )
        .build()
        .create(MoviesNetworkApi::class.java)



    override suspend fun getMovies(): List<Movie> {
        val response = networkApi.getMovies("1234")
        return response.results
        // return listOf(
        //    Movie(0, "pokemon")
        // )
    }

}
