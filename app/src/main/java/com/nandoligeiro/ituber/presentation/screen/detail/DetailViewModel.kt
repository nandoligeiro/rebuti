package com.nandoligeiro.ituber.presentation.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nandoligeiro.ituber.domain.detail.GetDetailMovieByIdUseCase
import com.nandoligeiro.ituber.presentation.screen.detail.model.DetailMovieUi
import com.nandoligeiro.ituber.presentation.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase: GetDetailMovieByIdUseCase,
) : ViewModel() {

    private val mutableMovieDetail by lazy { MutableStateFlow<UiState<DetailMovieUi>>(UiState.Loading) }
    val movieDetail: StateFlow<UiState<DetailMovieUi>> get() = mutableMovieDetail

    fun getMovieDetailById(movieId: Int) {

        viewModelScope.launch {

            mutableMovieDetail.value = try {
                val result = useCase(movieId)
                UiState.Success(DetailMovieDomainToUiMapper().toUi(result))
            } catch (e: Exception) {
                UiState.Error(e)
            }
        }
    }
}
