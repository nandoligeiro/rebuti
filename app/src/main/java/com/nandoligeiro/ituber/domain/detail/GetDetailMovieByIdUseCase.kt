package com.nandoligeiro.ituber.domain.detail

import com.nandoligeiro.ituber.domain.detail.entity.DetailMovieDomain

interface GetDetailMovieByIdUseCase {
    suspend operator fun invoke(movieId: Int): DetailMovieDomain

}