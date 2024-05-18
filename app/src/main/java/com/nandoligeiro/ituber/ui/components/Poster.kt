package com.nandoligeiro.ituber.ui.components

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.nandoligeiro.ituber.presentation.common.moshi
import com.nandoligeiro.ituber.presentation.screen.home.model.PopularMovieResultUi

@Composable
fun Poster(
    navController: NavHostController,
    movie: PopularMovieResultUi,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    val movieJson = Uri.encode(moshi.adapter(PopularMovieResultUi::class.java).toJson(movie))
    Card(
        modifier = modifier
            .padding(8.dp)
            .width(124.dp)
            .height(230.dp)
            .clickable { navController.navigate("details/${movieJson}") },

        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation()
    ) {

        AsyncImage(
            model = imageUrl,
            contentDescription = "${movie.title} Poster",
            contentScale = ContentScale.FillBounds
        )
    }
}
