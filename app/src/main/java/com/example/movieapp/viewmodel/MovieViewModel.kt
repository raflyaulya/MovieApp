package com.example.movieapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.model.Movie
import com.example.movieapp.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchPopularMovies()
    }

    // ✅ Fetch daftar film populer dari API
    fun fetchPopularMovies() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                println("🔍 Fetching popular movies...")
                val movieList = repository.getPopularMovies()
                println("✅ Data diterima: ${movieList.size} film")
                _movies.value = movieList
            } catch (e: Exception) {
                println("❌ Error saat fetch movies: ${e.message}")
                _error.value = e.message
            } finally {
                _isLoading.value = false
                println("🔄 Loading selesai")
            }
        }
    }

    // ✅ Fetch detail film berdasarkan movieId
    fun fetchMovieDetails(movieId: Int) {
        viewModelScope.launch {
            try {
                val movieDetail = repository.getMovieDetails(movieId)
                println("🎥 Detail film: $movieDetail")
                // Tambahkan state untuk menyimpan detail movie jika diperlukan
            } catch (e: Exception) {
                println("❌ Error saat fetch movie details: ${e.message}")
                _error.value = e.message
            }
        }
    }
}



//package com.example.movieapp.viewmodel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.movieapp.model.Movie
//import com.example.movieapp.repository.MovieRepository
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//class MovieViewModel(private val repository: MovieRepository) : ViewModel() {
//    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
//    val movies: StateFlow<List<Movie>> = _movies
//
//    private val _error = MutableStateFlow<String?>(null)
//    val error: StateFlow<String?> = _error
//    fun fetchPopularMovies(apiKey: String) {
//        viewModelScope.launch {
//            try {
//                val popularMovies = repository.getPopularMovies(apiKey)
//                _movies.value = popularMovies
//            } catch (e: Exception) {
//                _error.value = e.message
//            }
//        }
//    }
//    fun fetchMovieDetail(id: Int, apiKey: String) {
//        viewModelScope.launch {
//            try {
//                val movieDetail = repository.getMovieDetail(id, apiKey)
//                // Handle detail movie logic here
//            } catch (e: Exception) {
//                _error.value = e.message
//            }
//        }
//    }
//}