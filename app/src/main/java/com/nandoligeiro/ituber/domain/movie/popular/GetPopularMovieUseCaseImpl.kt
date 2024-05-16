package com.nandoligeiro.ituber.domain.movie.popular

import com.nandoligeiro.ituber.di.IoDispatcher
import com.nandoligeiro.ituber.domain.movie.popular.entity.PopularMovieDomain
import com.nandoligeiro.ituber.domain.result.DomainResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPopularMovieUseCaseImpl @Inject constructor(
    private val repository: GetPopularMovieRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : GetPopularMovieUseCase {

    override suspend fun invoke(request: Int):
            DomainResult<PopularMovieDomain> = withContext(dispatcher) {
        try {
            val result = repository.getPopularMovie()
            DomainResult.Success(result)
        } catch (e: Exception) {
            DomainResult.Error(e)
        }
    }
}
