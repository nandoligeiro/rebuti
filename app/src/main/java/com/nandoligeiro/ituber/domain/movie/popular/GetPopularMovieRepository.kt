package com.nandoligeiro.ituber.domain.movie.popular

import com.nandoligeiro.ituber.domain.movie.popular.entity.PopularMovieDomain

interface GetPopularMovieRepository {
    suspend fun getPopularMovie(): PopularMovieDomain
}