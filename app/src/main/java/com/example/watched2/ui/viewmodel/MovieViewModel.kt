package com.example.watched2.ui.viewmodel

import android.text.Editable
import android.util.Log
import com.example.watched2.data.remote.omdb.MovieSearchResponse
import com.example.watched2.data.remote.omdb.OmdbClient
import com.example.watched2.data.repository.contract.MovieResositoryContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel(private val movieRepository: MovieResositoryContract) {

    private val omdbClient = OmdbClient.create()
    private val TAG = "CHECK_RESPONSE"

    /*
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
    */
    fun fetchMovieBySearch(title: Editable) {
        movieRepository.fetchMovieBySearch(OmdbClient.API_KEY, title, object : Callback<MovieSearchResponse> {
            override fun onResponse(
                call: Call<MovieSearchResponse>,
                response: Response<MovieSearchResponse>) {
                if (response.isSuccessful) {
                    val movieResponse = response.body()
                    movieResponse?.let {
                        Log.d(TAG, "${response.body()}")
                    }
                }
            }
            override fun onFailure(call: Call<MovieSearchResponse>, t: Throwable) {
                Log.d(TAG, "${t.message}")
            }
        })
    }
}