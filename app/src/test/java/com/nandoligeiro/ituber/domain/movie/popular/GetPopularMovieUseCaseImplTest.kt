package com.nandoligeiro.ituber.domain.movie.popular

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

class GetPopularMovieUseCaseImplTest {

    @MockK
    private lateinit var repository: GetPopularMovieRepository

    private lateinit var getPopularMovieUseCase: GetPopularMovieUseCaseImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        getPopularMovieUseCase =
            spyk(GetPopularMovieUseCaseImpl(repository, Dispatchers.Unconfined))
    }

    @Test
    fun `Should call method repository`() = runBlocking {
        coEvery {
            repository.getPopularMovie(any())
        } returns mockk()

        getPopularMovieUseCase(1)

        coVerify(exactly = 1) { repository.getPopularMovie(any()) }

    }
}
