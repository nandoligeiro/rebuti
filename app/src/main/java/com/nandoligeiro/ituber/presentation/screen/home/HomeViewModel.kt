package com.nandoligeiro.ituber.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nandoligeiro.ituber.domain.movie.popular.GetPopularMovieUseCase
import com.nandoligeiro.ituber.domain.result.DomainResult
import com.nandoligeiro.ituber.presentation.screen.home.model.PopularMovieUi
import com.squareup.moshi.Moshi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetPopularMovieUseCase,
) : ViewModel() {

    private val mutablePopularMovie by lazy { MutableStateFlow(initialState()) }
    val popularMovie: StateFlow<PopularMovieUi> get() = mutablePopularMovie

    fun getPopularMovie(page: Int) {
        viewModelScope.launch {

            when (val result = useCase(page)) {
                is DomainResult.Success -> {
                    mutablePopularMovie.value =
                        PopularMovieDomainToUiMapper().toUi(result.data)
                }

                else -> {
                    mutablePopularMovie.value = initialState()
                }
            }

        }
    }

    private fun initialState(): PopularMovieUi = PopularMovieUi()

}
