import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.watched2.data.repository.MovieRepository
import com.example.watched2.databinding.ActivityMainBinding
import com.example.watched2.ui.viewmodel.MovieViewModel
import com.example.watched2.data.repository.contract.MovieResositoryContract

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieSearchEditText: EditText
    private lateinit var movieSearchButton: Button

    private lateinit var movieViewModel: MovieViewModel
    private val TAG = "CHECK_RESPONSE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBindigs()

        // Inicialize o MovieViewModel com uma instância de MovieRepository
        val movieRepository: MovieResositoryContract = MovieRepository()
        movieViewModel = MovieViewModel(movieRepository)

        listenSearchButton()
    }

    private fun setupBindigs() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieSearchEditText = binding.movieSearchEditText
        movieSearchButton = binding.movieSearchButton
    }

    private fun listenSearchButton() {
        movieSearchButton.setOnClickListener {
            val textToSearch = movieSearchEditText.text
            movieViewModel.fetchMovieBySearch(textToSearch)
        }
    }
}
