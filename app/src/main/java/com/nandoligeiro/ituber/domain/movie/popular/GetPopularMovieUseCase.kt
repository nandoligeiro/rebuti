package com.nandoligeiro.ituber.domain.movie.popular

import com.nandoligeiro.ituber.domain.movie.popular.entity.PopularMovieDomain

interface GetPopularMovieUseCase {
    suspend operator fun invoke(page: Int): PopularMovieDomain
}
