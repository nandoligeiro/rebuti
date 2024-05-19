import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nandoligeiro.ituber.domain.movie.popular.GetPopularMovieUseCase
import com.nandoligeiro.ituber.presentation.screen.home.HomeViewModel
import com.nandoligeiro.ituber.presentation.screen.home.PopularMovieDomainToUiMapper
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var useCase: GetPopularMovieUseCase

    @Inject
    lateinit var viewModel: HomeViewModel

    @MockK
    private lateinit var mapper: PopularMovieDomainToUiMapper


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = HomeViewModel(useCase)
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        UnconfinedTestDispatcher().cancel()
    }

    @Test
    fun `test getPopularMovie returns mapped UI state`() = runTest {
        coEvery { useCase(any()) } returns mockk()
        every { mapper.toUi(any()) } returns mockk()

        viewModel.getPopularMovie(1)

        coVerify { useCase(any()) }
    }
}
