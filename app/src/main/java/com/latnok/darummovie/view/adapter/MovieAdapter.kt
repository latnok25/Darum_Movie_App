package com.latnok.darummovie.view.adapter
import android.view.LayoutInflater
import com.latnok.darummovie.model.data.Result
import android.view.ViewGroup
import com.latnok.darummovie.databinding.MymovieLayoutBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MovieAdapter(private val itemClickListener: OnItemClickListener)  : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var movieList =  ArrayList<Result>()

    interface OnItemClickListener {
        fun onItemClick(movie: Result)
    }

    fun setMovieList(movieList: List<Result>) {
        this.movieList = movieList as ArrayList<Result>
        notifyDataSetChanged()

    }

    class ViewHolder(val binding: MymovieLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MymovieLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList[position]
        with(holder.binding) {
            Glide.with(root)
                .load("https://image.tmdb.org/t/p/w500${movie.poster_path}")
                .into(movieImage)
            movieName.text = movie.title
            root.setOnClickListener {
                itemClickListener.onItemClick(movie)
            }
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}