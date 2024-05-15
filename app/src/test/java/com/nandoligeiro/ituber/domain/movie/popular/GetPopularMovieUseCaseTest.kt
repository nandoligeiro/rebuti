package com.nandoligeiro.ituber.domain.movie.popular

import com.nandoligeiro.ituber.domain.abstration.coroutine.CoroutineContextProvider
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetPopularMovieUseCaseTest() {

    @MockK
    private lateinit var repository: GetPopularMovieRepository

    @MockK
    private lateinit var coroutineContextProvider: CoroutineContextProvider

    @InjectMockKs
    private lateinit var getPopularMovieUseCase: GetPopularMovieUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `Should call method repository`() = runBlocking {
        coEvery {
            repository.getPopularMovie()
        } returns mockk()

        getPopularMovieUseCase.executeInBackground("1")

        coVerify(exactly = 1) { repository.getPopularMovie() }


    }

}