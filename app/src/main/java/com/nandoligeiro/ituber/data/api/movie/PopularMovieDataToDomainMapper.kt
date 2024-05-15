package com.nandoligeiro.ituber.data.api.movie

import com.nandoligeiro.ituber.data.api.movie.model.PopularMovieData
import com.nandoligeiro.ituber.domain.movie.popular.entity.PopularMovieDomain
import com.nandoligeiro.ituber.domain.movie.popular.entity.PopularMovieResultDomain

class PopularMovieDataToDomainMapper {

    fun toDomain(popularMovieData: PopularMovieData) =
        PopularMovieDomain(
            page = popularMovieData.page,
            results = popularMovieData.results.map { result ->
                PopularMovieResultDomain(
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
            totalPages = popularMovieData.totalPages,
            totalResults = popularMovieData.totalResults,
        )
}