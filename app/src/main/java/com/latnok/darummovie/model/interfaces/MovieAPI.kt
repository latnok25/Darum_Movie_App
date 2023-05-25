package com.latnok.darummovie.model.interfaces

import com.latnok.darummovie.model.data.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieAPI {

    @GET("popular")
    fun getPopularMovies( @Header("Authorization") accessToken: String) : Call<Movies>
}