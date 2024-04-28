package com.example.watched2.ui.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.watched2.R
import com.example.watched2.databinding.ActivityMainBinding
import com.example.watched2.ui.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieSearchEditText: EditText
    private lateinit var movieSearchButton: Button

    private lateinit var movieViewModel: MovieViewModel
    private val TAG = "CHECK_RESPONSE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBindigs()
        movieViewModel = MovieViewModel()
        listenSearchButton()
    }

    private fun setupBindigs() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieSearchEditText = binding.movieSearchEditText
        movieSearchButton = binding.movieSearchButton
    }
    private fun listenSearchButton() {
        movieSearchButton.setOnClickListener{
            val textToSearch = movieSearchEditText.text
            movieViewModel.fetchMovieBySearch(textToSearch)
        }
    }
}