package com.example.movieapp.network

import com.example.movieapp.model.Movie
import com.example.movieapp.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("movie/{id}")
    suspend fun getMovieDetail(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-US"
    ): Movie
}