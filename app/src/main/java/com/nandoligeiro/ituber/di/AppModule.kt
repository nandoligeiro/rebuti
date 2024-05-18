package com.nandoligeiro.ituber.di

import android.content.res.Resources
import com.nandoligeiro.ituber.MovieApplication
import com.nandoligeiro.ituber.domain.movie.popular.GetPopularMovieUseCase
import com.nandoligeiro.ituber.domain.movie.popular.GetPopularMovieUseCaseImpl
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesResources(application: MovieApplication): Resources =
        application.resources
}
