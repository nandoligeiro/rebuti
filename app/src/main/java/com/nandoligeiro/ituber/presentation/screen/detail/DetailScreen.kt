import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.nandoligeiro.ituber.presentation.screen.detail.DetailViewModel
import com.nandoligeiro.ituber.presentation.screen.detail.model.DetailMovieUi
import com.nandoligeiro.ituber.presentation.state.UiState
import com.nandoligeiro.ituber.ui.components.DetailMovieInfo
import com.nandoligeiro.ituber.ui.components.DetailPosterTitle
import com.nandoligeiro.ituber.ui.components.DetailTopAppBar

@Composable
fun DetailScreen(
    movieId: Int,
    viewModel: DetailViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {

    val movieDetail by viewModel.movieDetail.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getMovieDetailById(movieId)
    }

    when (movieDetail) {
        is UiState.Success -> {
            val movie = (movieDetail as UiState.Success<DetailMovieUi>).data

            var selectedTab by remember { mutableIntStateOf(0) }

            Scaffold(
                topBar = { DetailTopAppBar(onBackClick) }
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .verticalScroll(rememberScrollState()),
                ) {
                    DetailPosterTitle(movie = movie)
                    DetailMovieInfo(movie = movie)
                }
            }
        }

        is UiState.Error -> {
            val exception = (movieDetail as UiState.Error).exception
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
