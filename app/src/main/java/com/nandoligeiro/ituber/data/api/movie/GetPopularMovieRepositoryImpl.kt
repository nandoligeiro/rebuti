package com.nandoligeiro.ituber.data.api.movie

import com.nandoligeiro.ituber.data.api.MovieApi
import com.nandoligeiro.ituber.domain.movie.popular.GetPopularMovieRepository
import com.nandoligeiro.ituber.domain.movie.popular.entity.PopularMovieDomain
import javax.inject.Inject

class GetPopularMovieRepositoryImpl @Inject constructor(
    private val api: MovieApi,
    private val mapper: PopularMovieDataToDomainMapper
) : GetPopularMovieRepository {
    override suspend fun getPopularMovie(page: Int): PopularMovieDomain =
        mapper.toDomain(api.getPopularMovie(page))
}
