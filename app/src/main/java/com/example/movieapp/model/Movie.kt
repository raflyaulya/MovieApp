package com.example.movieapp.model

//data class Movie(
//    val id:Int,
//    val title: String,
//    val description: String,
//    val posterUrl: String,
//    val rating: Float,
////    val poster_path: String,
//)

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String, // Sesuaikan dengan respons API
    val vote_average: Double,
    val release_date: String
)

//Movie(
//id = 1,
//title = "Movie 1",
//description = "Description of Movie 1",
//posterUrl = "https://example.com/poster1.jpg",
//rating = 4.5f
//),