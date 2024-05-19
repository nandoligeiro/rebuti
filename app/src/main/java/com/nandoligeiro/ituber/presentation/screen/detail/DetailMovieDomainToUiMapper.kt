package com.nandoligeiro.ituber.presentation.screen.detail

import com.nandoligeiro.ituber.domain.detail.entity.DetailMovieDomain
import com.nandoligeiro.ituber.presentation.screen.detail.model.BelongsToCollectionUi
import com.nandoligeiro.ituber.presentation.screen.detail.model.DetailMovieUi
import com.nandoligeiro.ituber.presentation.screen.detail.model.GenreUi
import com.nandoligeiro.ituber.presentation.screen.detail.model.ProductionCompanyUi
import com.nandoligeiro.ituber.presentation.screen.detail.model.ProductionCountryUi
import com.nandoligeiro.ituber.presentation.screen.detail.model.SpokenLanguageUi

class DetailMovieDomainToUiMapper {

    fun toUi(detailMovieDomain: DetailMovieDomain) =
        DetailMovieUi(
            adult = detailMovieDomain.adult,
            backdrop_path = detailMovieDomain.backdrop_path,
            belongs_to_collection = BelongsToCollectionUi(
                backdrop_path = detailMovieDomain.belongs_to_collection.backdrop_path,
                id = detailMovieDomain.belongs_to_collection.id,
                name = detailMovieDomain.belongs_to_collection.name,
                poster_path = detailMovieDomain.belongs_to_collection.poster_path
            ),
            budget = detailMovieDomain.budget,
            genres = detailMovieDomain.genres.map { genreUi ->
                GenreUi(
                    id = genreUi.id,
                    name = genreUi.name
                )
            },
            homepage = detailMovieDomain.homepage,
            id = detailMovieDomain.id,
            imdb_id = detailMovieDomain.imdb_id,
            origin_country = detailMovieDomain.origin_country,
            original_language = detailMovieDomain.original_language,
            original_title = detailMovieDomain.original_title,
            overview = detailMovieDomain.overview,
            popularity = detailMovieDomain.popularity,
            poster_path = detailMovieDomain.poster_path,
            production_companies = detailMovieDomain.production_companies.map {
                ProductionCompanyUi(
                    id = it.id,
                    logo_path = it.logo_path,
                    name = it.name,
                    origin_country = it.origin_country
                )

            },
            production_countries = detailMovieDomain.production_countries.map {
                ProductionCountryUi(
                    iso_3166_1 = it.iso_3166_1,
                    name = it.name
                )
            },
            release_date = detailMovieDomain.release_date,
            revenue = detailMovieDomain.revenue,
            runtime = detailMovieDomain.runtime,
            spoken_languages = detailMovieDomain.spoken_languages.map {
                SpokenLanguageUi(
                    english_name = it.english_name,
                    iso_639_1 = it.iso_639_1,
                    name = it.name
                )
            },
            status = detailMovieDomain.status,
            tagline = detailMovieDomain.tagline,
            title = detailMovieDomain.title,
            video = detailMovieDomain.video,
            vote_average = detailMovieDomain.vote_average,
            vote_count = detailMovieDomain.vote_count
        )
}
