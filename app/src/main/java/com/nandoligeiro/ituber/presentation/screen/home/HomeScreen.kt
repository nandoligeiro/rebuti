package com.nandoligeiro.ituber.presentation.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.nandoligeiro.ituber.R
import com.nandoligeiro.ituber.presentation.screen.Screen
import com.nandoligeiro.ituber.presentation.screen.home.model.PopularMovieUi
import com.nandoligeiro.ituber.presentation.state.UiState
import com.nandoligeiro.ituber.ui.components.Poster

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel(),
) {

    val popularMovie by viewModel.popularMovie.collectAsState()

    LaunchedEffect(Unit) {
        if (popularMovie !is UiState.Success) {
            viewModel.getPopularMovie(2)
        }
    }

    when (popularMovie) {
        is UiState.Success -> {
            val popularMovies = (popularMovie as UiState.Success<PopularMovieUi>).data
            HomeSuccessState(navController, popularMovies)
        }

        is UiState.Error -> {
            val exception = (popularMovie as UiState.Error).exception
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Error: ${exception.message}")
            }
        }

        UiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeSuccessState(navController: NavHostController, popularMovie: PopularMovieUi) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                title = {
                    Text(
                        stringResource(R.string.popular_movies),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        Column {
            Spacer(Modifier.height(16.dp))

            LazyVerticalGrid(
                contentPadding = innerPadding,
                columns = GridCells.Adaptive(minSize = 128.dp),
                modifier = Modifier
                    .padding(8.dp),
                content = {

                    items(popularMovie.results) { movie ->
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .width(124.dp)
                                .height(230.dp)
                                .clickable { navController.navigate(Screen.Details.createRoute(movie.id)) },
                            shape = RoundedCornerShape(8.dp),
                            elevation = CardDefaults.cardElevation()
                        ) {
                            Poster(
                                title = movie.title,
                                imageUrl = LocalContext.current.getString(
                                    R.string.url_image_tmdb_w1280,
                                    movie.posterPath,
                                )
                            )
                        }
                    }
                })
        }

    }
}