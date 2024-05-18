package com.nandoligeiro.ituber.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nandoligeiro.ituber.presentation.screen.home.model.PopularMovieResultUi

@Composable
fun DetailMovieInfo(movie: PopularMovieResultUi) {
    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = Icons.Default.DateRange, contentDescription = "Year")
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = movie.releaseDate)

        Spacer(modifier = Modifier.width(16.dp))
//
//        Icon(imageVector = Icons.Default.AccessTime, contentDescription = "Duration")
//        Spacer(modifier = Modifier.width(4.dp))
//        Text(text = movie.)
//
//        Spacer(modifier = Modifier.width(16.dp))
//
//        Icon(imageVector = Icons.Default.Movie, contentDescription = "Genre")
//        Spacer(modifier = Modifier.width(4.dp))
//        Text(text = movie.genre)
    }
}
