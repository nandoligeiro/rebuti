package com.nandoligeiro.ituber.data.api.detail

import com.nandoligeiro.ituber.data.api.detail.entity.DetailMovieData
import com.nandoligeiro.ituber.domain.detail.entity.BelongsToCollectionDomain
import com.nandoligeiro.ituber.domain.detail.entity.DetailMovieDomain
import com.nandoligeiro.ituber.domain.detail.entity.GenreDomain
import com.nandoligeiro.ituber.domain.detail.entity.ProductionCompanyDomain
import com.nandoligeiro.ituber.domain.detail.entity.ProductionCountryDomain
import com.nandoligeiro.ituber.domain.detail.entity.SpokenLanguageDomain

class DetailMovieDataToDomainMapper {

    fun toDomain(detailMovieData: DetailMovieData) =
        DetailMovieDomain(
            adult = detailMovieData.adult,
            backdrop_path = detailMovieData.backdrop_path  ?: "",
            belongs_to_collection = BelongsToCollectionDomain(
                backdrop_path = detailMovieData.belongs_to_collection?.backdrop_path ?: "",
                id = detailMovieData.belongs_to_collection?.id ?: 0,
                name = detailMovieData.belongs_to_collection?.name ?: "",
                poster_path = detailMovieData.belongs_to_collection?.poster_path ?: ""
            ),
            budget = detailMovieData.budget,
            genres = detailMovieData.genres.map { genreData ->
                GenreDomain(
                    id = genreData.id,
                    name = genreData.name
                )
            },
            homepage = detailMovieData.homepage,
            id = detailMovieData.id,
            imdb_id = detailMovieData.imdb_id ?: "",
            origin_country = detailMovieData.origin_country,
            original_language = detailMovieData.original_language,
            original_title = detailMovieData.original_title,
            overview = detailMovieData.overview,
            popularity = detailMovieData.popularity,
            poster_path = detailMovieData.poster_path,
            production_companies = detailMovieData.production_companies.map {
                ProductionCompanyDomain(
                    id = it.id,
                    logo_path = it.logo_path ?: "",
                    name = it.name,
                    origin_country = it.origin_country
                )

            },
            production_countries = detailMovieData.production_countries.map {
                ProductionCountryDomain(
                    iso_3166_1 = it.iso_3166_1,
                    name = it.name
                )
            },
            release_date = detailMovieData.release_date,
            revenue = detailMovieData.revenue,
            runtime = detailMovieData.runtime,
            spoken_languages = detailMovieData.spoken_languages.map {
                SpokenLanguageDomain(
                    english_name = it.english_name,
                    iso_639_1 = it.iso_639_1,
                    name = it.name
                )
            },
            status = detailMovieData.status,
            tagline = detailMovieData.tagline,
            title = detailMovieData.title,
            video = detailMovieData.video,
            vote_average = detailMovieData.vote_average,
            vote_count = detailMovieData.vote_count
        )
}
