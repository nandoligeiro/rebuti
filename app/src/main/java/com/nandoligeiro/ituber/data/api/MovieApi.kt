package com.nandoligeiro.ituber.data.api

import com.nandoligeiro.ituber.data.api.detail.entity.DetailMovieData
import com.nandoligeiro.ituber.data.api.movie.model.PopularMovieData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovie(@Query("page") page: Int): PopularMovieData

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: Int): DetailMovieData
}