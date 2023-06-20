package com.latnok.darummovie.model.interfaces
import com.latnok.darummovie.model.data.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET("popular")
    fun getPopularMovies( @Query("api_key") accessToken: String) : Call<Movies>
}