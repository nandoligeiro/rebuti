import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nandoligeiro.ituber.domain.detail.GetDetailMovieByIdUseCase
import com.nandoligeiro.ituber.presentation.screen.detail.DetailMovieDomainToUiMapper
import com.nandoligeiro.ituber.presentation.screen.detail.DetailViewModel
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
class DetailViewModelTest {


    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var useCase: GetDetailMovieByIdUseCase

    @Inject
    lateinit var viewModel: DetailViewModel

    @MockK
    private lateinit var mapper: DetailMovieDomainToUiMapper


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = DetailViewModel(useCase)
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        UnconfinedTestDispatcher().cancel()
    }

    @Test
    fun `test getMovieDetailById returns mapped UI state`() = runTest {
        coEvery { useCase(any()) } returns mockk()
        every { mapper.toUi(any()) } returns mockk()

        viewModel.getMovieDetailById(1)

        coVerify { useCase(any()) }
    }
}
