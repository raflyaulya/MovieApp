package com.example.movieapp.repository

import com.example.movieapp.model.Movie
//import com.example.movieapp.network.ApiService
import com.google.firebase.appdistribution.gradle.ApiService
//import com.google.firebase.appdistribution.gradle.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRepository {
    private val api: com.example.movieapp.network.ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(com.example.movieapp.network.ApiService::class.java)
    }

    suspend fun getPopularMovies(apiKey: String): List<Movie> {
        return api.getPopularMovies(apiKey).results
    }

    suspend fun getMovieDetail(id: Int, apiKey: String): Movie {
        return api.getMovieDetail(id, apiKey)
    }
}