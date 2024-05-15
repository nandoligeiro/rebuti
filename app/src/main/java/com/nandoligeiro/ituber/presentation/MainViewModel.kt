package com.nandoligeiro.ituber.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nandoligeiro.ituber.domain.movie.popular.GetPopularMovieUseCase
import com.nandoligeiro.ituber.presentation.coroutine.UseCaseExecutorProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: GetPopularMovieUseCase
) : ViewModel() {

    fun getPopularMovie(page: Int) {
        viewModelScope.launch {

            val result = useCase(1)

        }
    }

}