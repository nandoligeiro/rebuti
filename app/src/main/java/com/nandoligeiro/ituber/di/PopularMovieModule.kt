package com.nandoligeiro.ituber.di

import com.nandoligeiro.ituber.data.api.MovieApi
import com.nandoligeiro.ituber.data.api.movie.GetPopularMovieRepositoryImpl
import com.nandoligeiro.ituber.data.api.movie.PopularMovieDataToDomainMapper
import com.nandoligeiro.ituber.domain.movie.popular.GetPopularMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PopularMovieModule {

    @Provides
    fun providesPopularMovieDataToDomainMapper() = PopularMovieDataToDomainMapper()

    @Provides
    fun providesGetPopularMovieRepository(
        api: MovieApi,
        popularMovieDataToDomainMapper: PopularMovieDataToDomainMapper
    ): GetPopularMovieRepository = GetPopularMovieRepositoryImpl(
        api,
        popularMovieDataToDomainMapper
    )
}
