package com.latnok.darummovie.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.latnok.darummovie.R
import com.latnok.darummovie.databinding.ActivityMainBinding
import com.latnok.darummovie.view.adapter.MovieAdapter
import com.latnok.darummovie.viewmodel.MovieViewModel
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter : MovieAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val properties = readPropertiesFile(applicationContext)
        val value = properties.getProperty("token")

        prepareRecyclerView()

        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        viewModel.getPopularMovies(value)

        viewModel.observeMovieLiveData().observe(this, Observer { movieList ->
            movieAdapter.setMovieList(movieList)
            movieAdapter.notifyDataSetChanged()
        })

    }

    fun readPropertiesFile(context: Context): Properties {
        val properties = Properties()
        try {
            val inputStream = context.assets.open("my_properties_file.properties")
            properties.load(inputStream)
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return properties
    }

    private fun prepareRecyclerView() {
        movieAdapter = MovieAdapter()
        binding.rvMovies.apply {
            layoutManager = GridLayoutManager(applicationContext,2)
            adapter = movieAdapter
        }
    }
}