package com.latnok.darummovie.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.latnok.darummovie.model.data.Result
import com.latnok.darummovie.model.data.Movies
import com.latnok.darummovie.model.repo.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    private var movieLiveData = MutableLiveData<List<Result>>()

    fun getPopularMovies(accessToken: String) {
       val call = RetrofitInstance.api.getPopularMovies(accessToken)
        call.enqueue(object  : Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.body()!=null){
                    movieLiveData.value = response.body()!!.results
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }

    fun observeMovieLiveData() : LiveData<List<Result>> {
        return movieLiveData
    }
}


