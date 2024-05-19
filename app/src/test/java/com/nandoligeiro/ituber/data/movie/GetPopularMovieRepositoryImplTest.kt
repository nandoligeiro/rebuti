package com.nandoligeiro.ituber.data.movie

import com.nandoligeiro.ituber.data.api.MovieApi
import com.nandoligeiro.ituber.data.api.movie.GetPopularMovieRepositoryImpl
import com.nandoligeiro.ituber.data.api.movie.PopularMovieDataToDomainMapper
import com.nandoligeiro.ituber.domain.movie.popular.GetPopularMovieRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetPopularMovieRepositoryImplTest {

    @MockK
    private lateinit var repository: GetPopularMovieRepository

    @MockK
    private lateinit var mapper: PopularMovieDataToDomainMapper

    @MockK
    private lateinit var api: MovieApi

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repository = GetPopularMovieRepositoryImpl(api, mapper)
    }

    @Test
    fun `should call api`(): Unit = runBlocking {

        coEvery { api.getPopularMovie(any()) } returns mockk()
        coEvery { mapper.toDomain(any()) } returns mockk()

        repository.getPopularMovie(1)

        coVerify(exactly = 1) { api.getPopularMovie(any()) }

    }
}
