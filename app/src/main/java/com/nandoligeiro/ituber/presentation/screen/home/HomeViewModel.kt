package com.nandoligeiro.ituber.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nandoligeiro.ituber.domain.movie.popular.GetPopularMovieUseCase
import com.nandoligeiro.ituber.presentation.screen.home.model.PopularMovieUi
import com.nandoligeiro.ituber.presentation.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetPopularMovieUseCase,
) : ViewModel() {

    private val mutablePopularMovie by lazy { MutableStateFlow<UiState<PopularMovieUi>>(UiState.Loading) }
    val popularMovie: StateFlow<UiState<PopularMovieUi>> get() = mutablePopularMovie

    fun getPopularMovie(page: Int) {

        viewModelScope.launch {

            mutablePopularMovie.value = try {
                val result = useCase(page)
                UiState.Success(PopularMovieDomainToUiMapper().toUi(result))
            } catch (e: Exception) {
                UiState.Error(e)
            }
        }
    }
}
