package com.example.watched2.data.remote.omdb

import android.text.Editable
import com.example.watched2.data.remote.omdb.MovieSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbService {

    @GET("/")
    fun getMovie(
        @Query("apikey") apiKey: String,
        @Query("s") title: Editable
    ): Call<MovieSearchResponse>

}