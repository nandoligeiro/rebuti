package com.nandoligeiro.ituber.data.api.detail

import com.nandoligeiro.ituber.data.api.MovieApi
import com.nandoligeiro.ituber.domain.detail.GetDetailMovieByIdRepository
import com.nandoligeiro.ituber.domain.detail.entity.DetailMovieDomain
import javax.inject.Inject

class GetDetailMovieByIdRepositoryImpl @Inject constructor(
    private val api: MovieApi,
    private val mapper: DetailMovieDataToDomainMapper
) : GetDetailMovieByIdRepository {
    override suspend fun getDetailMovieById(movieId: Int): DetailMovieDomain =
        mapper.toDomain(api.getMovieDetail(movieId))
}
