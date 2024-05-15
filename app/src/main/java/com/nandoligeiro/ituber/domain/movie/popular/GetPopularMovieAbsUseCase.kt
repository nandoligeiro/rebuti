package com.nandoligeiro.ituber.domain.movie.popular

import com.nandoligeiro.ituber.domain.abstration.coroutine.CoroutineContextProvider
import com.nandoligeiro.ituber.domain.abstration.usecase.BackgroundExecutingUseCase
import com.nandoligeiro.ituber.domain.movie.popular.entity.PopularMovieDomain

class GetPopularMovieAbsUseCase(
    private val repository: GetPopularMovieRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<Int, PopularMovieDomain>(coroutineContextProvider) {
    override suspend fun executeInBackground(
        request: Int
    ): PopularMovieDomain = repository.getPopularMovie()
}
