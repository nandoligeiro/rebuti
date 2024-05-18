package com.nandoligeiro.ituber.domain.movie.popular

import com.nandoligeiro.ituber.data.api.movie.model.PopularMovieData
import com.nandoligeiro.ituber.data.api.movie.model.PopularMovieResultData
import com.nandoligeiro.ituber.domain.movie.popular.entity.PopularMovieDomain
import com.nandoligeiro.ituber.domain.movie.popular.entity.PopularMovieResultDomain


class DummyGetPopularMovieRepository : GetPopularMovieRepository {
    override suspend fun getPopularMovie(): PopularMovieDomain = PopularMovieDomain(
        page = 1,
        results = listOf(
            PopularMovieResultDomain(
                adult = false,
                backdropPath = "/fqv8v6AycXKsivp1T5yKtLbGXce.jpg",
                genreIds = listOf(878, 12, 28),
                id = 940721,
                originalLanguage = "en",
                originalTitle = "Kingdom of the Planet of the Apes",
                overview = "Several generations in the future following Caesar's reign, apes are now the dominant species and live harmoniously while humans have been reduced to living in the shadows. As a new tyrannical ape leader builds his empire, one young ape undertakes a harrowing journey that will cause him to question all that he has known about the past and to make choices that will define a future for apes and humans alike.",
                popularity = 3264.146,
                posterPath = "/gKkl37BQuKTanygYQG1pyYgLVgf.jpg",
                releaseDate = "2024-05-08",
                title = "Kingdom of the Planet of the Apes",
                video = false,
                voteAverage = 7.235,
                voteCount = 257

            )
        ),
        totalPages = 1000,
        totalResults = 99000
    )
}
