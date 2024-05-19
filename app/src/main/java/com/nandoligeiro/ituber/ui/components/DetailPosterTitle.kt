package com.nandoligeiro.ituber.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.nandoligeiro.ituber.R
import com.nandoligeiro.ituber.presentation.screen.detail.model.DetailMovieUi
import com.nandoligeiro.ituber.presentation.screen.home.model.PopularMovieResultUi

@Composable
fun DetailPosterTitle(movie: DetailMovieUi) {
    Column(modifier = Modifier.padding(16.dp)) {

        Poster(
            title = movie.title,
            imageUrl = LocalContext.current.getString(
                R.string.url_image_tmdb_w1280,
                movie.backdrop_path,
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = movie.title, style = MaterialTheme.typography.titleMedium)
    }
}
