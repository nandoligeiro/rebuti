package com.nandoligeiro.ituber.domain.detail

import com.nandoligeiro.ituber.domain.detail.entity.DetailMovieDomain

interface GetDetailMovieByIdRepository {
    suspend fun getDetailMovieById(movieId: Int): DetailMovieDomain
}