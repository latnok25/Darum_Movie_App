package com.latnok.darummovie.view
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.latnok.darummovie.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayMovieDetails()
    }

    private fun displayMovieDetails() {
        val intent = intent
        // Retrieve the "selectedMovie" extra from the intent
        val selectedMovie = intent.getSerializableExtra("selectedMovie") as com.latnok.darummovie.model.data.Result
        with(binding) {
            Glide.with(root)
                .load("https://image.tmdb.org/t/p/w500${selectedMovie.poster_path}")
                .into(movieImage)
            movieName.text = selectedMovie.title
            movieoview.text = selectedMovie.overview
        }
    }
}