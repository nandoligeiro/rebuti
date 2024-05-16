package com.nandoligeiro.ituber.presentation.screen.home

import com.nandoligeiro.ituber.domain.movie.popular.entity.PopularMovieDomain
import com.nandoligeiro.ituber.presentation.screen.home.model.PopularMovieResultUi
import com.nandoligeiro.ituber.presentation.screen.home.model.PopularMovieUi

class PopularMovieDomainToUiMapper {

    fun toUi(popularMovieDomain: PopularMovieDomain) =
        PopularMovieUi(
            page = popularMovieDomain.page,
            results = popularMovieDomain.results.map { result ->
                PopularMovieResultUi(
                    adult = result.adult,
                    backdropPath = result.backdropPath,
                    genreIds = result.genreIds,
                    id = result.id,
                    originalLanguage = result.originalLanguage,
                    originalTitle = result.originalTitle,
                    overview = result.overview,
                    popularity = result.popularity,
                    posterPath = result.posterPath,
                    releaseDate = result.releaseDate,
                    title = result.releaseDate,
                    video = result.video,
                    voteAverage = result.voteAverage,
                    voteCount = result.voteCount
                )
            },
            totalPages = popularMovieDomain.totalPages,
            totalResults = popularMovieDomain.totalResults,
        )
}