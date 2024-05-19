package com.nandoligeiro.ituber.domain.movie.popular

import com.nandoligeiro.ituber.di.IoDispatcher
import com.nandoligeiro.ituber.domain.movie.popular.entity.PopularMovieDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPopularMovieUseCaseImpl @Inject constructor(
    private val repository: GetPopularMovieRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : GetPopularMovieUseCase {

    override suspend fun invoke(page: Int):
            PopularMovieDomain = withContext(dispatcher) { repository.getPopularMovie(page) }
}
