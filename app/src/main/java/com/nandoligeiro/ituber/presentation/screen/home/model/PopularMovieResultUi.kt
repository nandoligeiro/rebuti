package com.nandoligeiro.ituber.presentation.screen.home.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PopularMovieResultUi(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)
