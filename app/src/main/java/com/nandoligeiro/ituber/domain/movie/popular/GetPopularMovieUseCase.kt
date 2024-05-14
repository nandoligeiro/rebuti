package com.nandoligeiro.ituber.domain.movie.popular

import com.nandoligeiro.ituber.domain.abstration.coroutine.CoroutineContextProvider
import com.nandoligeiro.ituber.domain.movie.popular.entity.PopularMovieDomain
import com.nandoligeiro.ituber.domain.abstration.usecase.BackgroundExecutingUseCase

class GetPopularMovieUseCase(repository: GetPopularMovieRepository,
    coroutineContextProvider: CoroutineContextProvider) :
    BackgroundExecutingUseCase<String, PopularMovieDomain>(coroutineContextProvider) {
    override fun executeInBackground(request: String): PopularMovieDomain {
        TODO("Not yet implemented")
    }

}