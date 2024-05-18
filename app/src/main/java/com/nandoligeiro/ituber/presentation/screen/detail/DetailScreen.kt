import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nandoligeiro.ituber.presentation.screen.home.model.PopularMovieResultUi
import com.nandoligeiro.ituber.ui.components.DetailPosterTitle
import com.nandoligeiro.ituber.ui.components.DetailTopAppBar

@Composable
fun DetailScreen(movie: PopularMovieResultUi, onBackClick: () -> Unit) {
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = { DetailTopAppBar(onBackClick) }
    ){ paddingValues ->
        Column (modifier = Modifier.padding(paddingValues)) {
            DetailPosterTitle(movie = movie)
        }
    }

}
