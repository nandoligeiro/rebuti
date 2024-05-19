package com.nandoligeiro.ituber.domain.detail

import com.nandoligeiro.ituber.di.IoDispatcher
import com.nandoligeiro.ituber.domain.detail.entity.DetailMovieDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetDetailMovieByIdUseCaseImpl @Inject constructor(
    private val repository: GetDetailMovieByIdRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : GetDetailMovieByIdUseCase {
    override suspend fun invoke(movieId: Int): DetailMovieDomain =
        withContext(dispatcher) { repository.getDetailMovieById(movieId) }
}
