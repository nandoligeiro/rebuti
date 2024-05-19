package com.nandoligeiro.ituber.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun Poster(
    title: String,
    imageUrl: String,
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "$title Poster",
        contentScale = ContentScale.Crop
    )
}
