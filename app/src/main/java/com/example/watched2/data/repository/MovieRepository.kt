package com.example.watched2.data.repository

import android.text.Editable
import com.example.watched2.data.remote.omdb.MovieSearchResponse
import com.example.watched2.data.remote.omdb.OmdbClient
import com.example.watched2.data.repository.contract.MovieResositoryContract
import retrofit2.Callback

class MovieRepository : MovieResositoryContract {

        private val omdbClient = OmdbClient.create()

        override fun fetchMovieBySearch(apiKey: String, title: Editable, callback: Callback<MovieSearchResponse>) {
            omdbClient.getMovie(apiKey, title).enqueue(callback)
        }

}