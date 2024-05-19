package com.nandoligeiro.ituber.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nandoligeiro.ituber.presentation.screen.detail.model.DetailMovieUi

@Composable
fun DetailMovieInfo(movie: DetailMovieUi) {
    Column {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.CalendarMonth, contentDescription = "Year")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = movie.release_date)

            Spacer(modifier = Modifier.width(8.dp))

            Icon(imageVector = Icons.Default.Movie, contentDescription = "Genre")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = movie.genres[0].name)

            Spacer(modifier = Modifier.width(8.dp))

            Icon(imageVector = Icons.Default.AccessTime, contentDescription = "Duration")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = movie.runtime.toString())
        }

        Spacer(modifier = Modifier.width(16.dp))

        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = movie.overview)
        }
    }
}
