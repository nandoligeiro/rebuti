package com.nandoligeiro.ituber.domain.movie.popular

import com.nandoligeiro.ituber.domain.movie.popular.entity.PopularMovieDomain
import com.nandoligeiro.ituber.domain.result.DomainResult

interface GetPopularMovieUseCase {
    suspend operator fun invoke(request: Int): DomainResult<PopularMovieDomain>
}
