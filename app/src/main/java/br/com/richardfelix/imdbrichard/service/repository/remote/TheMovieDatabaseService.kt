package br.com.richardfelix.imdbrichard.service.repository.remote

import br.com.richardfelix.imdbrichard.service.model.response.CastResponse
import br.com.richardfelix.imdbrichard.service.model.response.PopularMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDatabaseService {

    companion object {
        val BASE_URL = "https://api.themoviedb.org/3/"
        val API_KEY = "0e2dac00805f35ebec9d5f90734184cb"
        val BASE_IMAGE_PATH_500 = "https://image.tmdb.org/t/p/w500/"
    }

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY
    ): Response<PopularMovieResponse>

    @GET("movie/{movie_id}/credits")
    suspend fun getCastOfMovie(
        @Path("movie_id") movieId: Long,
        @Query("api_key") apiKey: String = API_KEY
    ): Response<CastResponse>

}