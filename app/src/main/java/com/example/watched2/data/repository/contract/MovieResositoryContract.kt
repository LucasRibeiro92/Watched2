package com.example.watched2.data.repository.contract

import android.text.Editable
import com.example.watched2.data.remote.omdb.MovieSearchResponse
import retrofit2.Callback

interface MovieResositoryContract {
    fun fetchMovieBySearch(apiKey: String, title: Editable, callback: Callback<MovieSearchResponse>)
}