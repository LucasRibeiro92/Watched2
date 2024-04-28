package com.example.watched2.ui.viewmodel

import android.text.Editable
import android.util.Log
import com.example.watched2.data.remote.omdb.MovieSearchResponse
import com.example.watched2.data.remote.omdb.OmdbClient
import com.example.watched2.data.remote.omdb.OmdbClient.Companion.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel {
    val omdbClient = OmdbClient.create()
    private val TAG = "CHECK_RESPONSE"


    fun fetchMovieBySearch(title: Editable) {
        omdbClient.getMovie(apiKey = API_KEY, title)
            .enqueue(object : Callback<MovieSearchResponse> {
                override fun onResponse(
                    p0: Call<MovieSearchResponse>,
                    p1: Response<MovieSearchResponse>
                )
                {
                    if (p1.isSuccessful)
                    {
                        val movieResponse = p1.body()
                        movieResponse?.let {
                            Log.d(TAG, "${p1.body()}")
                        }
                    }
                }
                override fun onFailure(p0: Call<MovieSearchResponse>, p1: Throwable) {
                    Log.d(TAG, "${p1.message}")
                }
            })
    }
}