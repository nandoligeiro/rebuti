package com.nandoligeiro.ituber.di

import com.nandoligeiro.ituber.domain.detail.GetDetailMovieByIdUseCase
import com.nandoligeiro.ituber.domain.detail.GetDetailMovieByIdUseCaseImpl
import com.nandoligeiro.ituber.domain.movie.popular.GetPopularMovieUseCase
import com.nandoligeiro.ituber.domain.movie.popular.GetPopularMovieUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {
    @Binds
    fun bindGetPopularMovieUseCase(
        useCase: GetPopularMovieUseCaseImpl
    ): GetPopularMovieUseCase

    @Binds
    fun bindGetDetailMovieByIdUseCase(
        useCase: GetDetailMovieByIdUseCaseImpl
    ): GetDetailMovieByIdUseCase
}
