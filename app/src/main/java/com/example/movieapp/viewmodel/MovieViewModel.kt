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

    fun fetchPopularMovies(apiKey: String) {
        viewModelScope.launch {
            try {
                val popularMovies = repository.getPopularMovies(apiKey)
                _movies.value = popularMovies
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

    fun fetchMovieDetail(id: Int, apiKey: String) {
        viewModelScope.launch {
            try {
                val movieDetail = repository.getMovieDetail(id, apiKey)
                // Handle detail movie logic here
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}