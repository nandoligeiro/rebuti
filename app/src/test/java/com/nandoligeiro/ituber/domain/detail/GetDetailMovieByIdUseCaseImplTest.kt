package com.nandoligeiro.ituber.domain.detail

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetDetailMovieByIdUseCaseImplTest {

    @MockK
    private lateinit var repository: GetDetailMovieByIdRepository

    private lateinit var getDetailMovieByIdUseCase: GetDetailMovieByIdUseCaseImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        getDetailMovieByIdUseCase =
            spyk(GetDetailMovieByIdUseCaseImpl(repository, Dispatchers.Unconfined))
    }

    @Test
    fun `Should call method repository`() = runBlocking {
        coEvery {
            repository.getDetailMovieById(any())
        } returns mockk()

        getDetailMovieByIdUseCase(11)

        coVerify(exactly = 1) { repository.getDetailMovieById(any()) }

    }

}
