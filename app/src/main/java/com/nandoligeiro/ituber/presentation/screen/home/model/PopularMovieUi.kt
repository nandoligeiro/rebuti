package com.nandoligeiro.ituber.presentation.screen.home.model

data class PopularMovieUi(
    val page: Int = 1,
    val results: List<PopularMovieResultUi> = emptyList(),
    val totalPages: Int = 0,
    val totalResults: Int = 0
)
