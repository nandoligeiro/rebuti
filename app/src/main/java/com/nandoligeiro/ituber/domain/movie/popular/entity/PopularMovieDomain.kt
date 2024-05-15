package com.nandoligeiro.ituber.domain.movie.popular.entity

data class PopularMovieDomain(
    val page: Int,
    val results: List<PopularMovieResultDomain>,
    val totalPages: Int,
    val totalResults: Int
)
