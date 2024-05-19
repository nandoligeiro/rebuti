package com.nandoligeiro.ituber.data.detail

import com.nandoligeiro.ituber.data.api.MovieApi
import com.nandoligeiro.ituber.data.api.detail.DetailMovieDataToDomainMapper
import com.nandoligeiro.ituber.data.api.detail.GetDetailMovieByIdRepositoryImpl
import com.nandoligeiro.ituber.domain.detail.GetDetailMovieByIdRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetDetailMovieByIdRepositoryImplTest {

    @MockK
    private lateinit var repository: GetDetailMovieByIdRepository

    @MockK
    private lateinit var mapper: DetailMovieDataToDomainMapper

    @MockK
    private lateinit var api: MovieApi

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repository = GetDetailMovieByIdRepositoryImpl(api, mapper)
    }

    @Test
    fun `should call api`(): Unit = runBlocking {

        coEvery { api.getMovieDetail(any()) } returns mockk()
        coEvery { mapper.toDomain(any()) } returns mockk()

        repository.getDetailMovieById(1)

        coVerify(exactly = 1) { api.getMovieDetail(any()) }

    }
}
