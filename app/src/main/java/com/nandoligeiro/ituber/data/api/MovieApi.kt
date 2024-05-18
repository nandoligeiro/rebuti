package com.nandoligeiro.ituber.data.api

import com.nandoligeiro.ituber.data.api.movie.model.PopularMovieData
import retrofit2.http.GET

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovie(): PopularMovieData

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(): PopularMovieData
}