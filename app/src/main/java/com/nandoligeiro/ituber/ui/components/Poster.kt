package com.nandoligeiro.ituber.ui.components

import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun Poster(movie: String, imageUrl: String, modifier: Modifier = Modifier) {

    Log.d("URL", imageUrl)
    Card(
        modifier = modifier
            .padding(8.dp)
            .width(128.dp)
            .height(200.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "$movie Poster",
            contentScale = ContentScale.FillBounds
        )
    }
}
