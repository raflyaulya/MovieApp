package com.example.movieapp.repository

import com.example.movieapp.model.Movie
import com.example.movieapp.model.MovieResponse
import com.example.movieapp.network.ApiService

class MovieRepository {

    suspend fun getPopularMovies(): List<Movie> {
        return try {
            val response = ApiService.instance.getPopularMovies()
            response.results ?: emptyList()
        } catch (e: Exception) {
            println("❌ Error di repository: ${e.message}")
            emptyList()
        }
    }

    suspend fun getMovieDetails(movieId: Int): Movie {
        return try {
            ApiService.instance.getMovieDetails(movieId)
        } catch (e: Exception) {
            println("❌ Error saat fetch detail movie: ${e.message}")
            throw e
        }
    }
}




//package com.example.movieapp.repository
//
//import com.example.movieapp.model.Movie
//import com.example.movieapp.network.ApiService
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//class MovieRepository {
//    private val api: ApiService by lazy {
//        Retrofit.Builder()
//            .baseUrl("https://api.themoviedb.org/3/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiService::class.java)
//    }
//
//    suspend fun getPopularMovies(apiKey: String): List<Movie> {
//        return api.getPopularMovies(apiKey).results
//    }
//
//    suspend fun getMovieDetails(movieId: Int, apiKey: String): Movie {
//        return api.getMovieDetails(movieId, apiKey)
//    }
//}