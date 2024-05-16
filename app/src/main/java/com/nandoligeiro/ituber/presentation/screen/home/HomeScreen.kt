package com.nandoligeiro.ituber.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nandoligeiro.ituber.presentation.MainViewModel
import com.nandoligeiro.ituber.ui.components.Poster
import com.nandoligeiro.ituber.ui.components.SearchBar

@Composable
fun HomeScreen(viewModel: MainViewModel) {

    viewModel.getPopularMovie(1)
    val popularMovie = viewModel.popularMovie.collectAsState()

    Column {
        SearchBar()
        Spacer(Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp),
            modifier = Modifier.padding(8.dp),
            content = {

                items(popularMovie.value.results) { movie ->
                    Poster(
                        movie = movie.title,
                        imageUrl = "https://image.tmdb.org/t/p/w1280${movie.posterPath}"
                    )
                }
            })
    }
}
