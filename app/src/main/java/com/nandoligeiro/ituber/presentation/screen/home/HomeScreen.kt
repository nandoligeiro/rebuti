package com.nandoligeiro.ituber.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.nandoligeiro.ituber.R
import com.nandoligeiro.ituber.ui.components.Poster
import com.squareup.moshi.Moshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel(),
) {

    viewModel.getPopularMovie(1)

    val popularMovie = viewModel.popularMovie.collectAsState()

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
                modifier = Modifier.padding(8.dp),
                content = {

                    items(popularMovie.value.results) { movie ->
                        Poster(
                            navController = navController,
                            movie = movie,
                            imageUrl = LocalContext.current.getString(
                                R.string.url_image_tmdb_w1280,
                                movie.posterPath,
                            )
                        )
                    }
                })

        }

    }
}
