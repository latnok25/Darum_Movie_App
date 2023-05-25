package com.latnok.darummovie.view.adapter

import android.view.LayoutInflater
import com.latnok.darummovie.model.data.Result
import android.view.ViewGroup
import com.latnok.darummovie.databinding.MymovieLayoutBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter  : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var movieList =  ArrayList<Result>()


    fun setMovieList(movieList: List<Result>) {
        this.movieList = movieList as ArrayList<Result>
        //this.movieList = dummyData as ArrayList<Result>
        notifyDataSetChanged()

    }

    class ViewHolder(val binding: MymovieLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MymovieLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500"+movieList[position].poster_path)
            .into(holder.binding.movieImage)
        holder.binding.movieName.text = movieList[position].title
    }

    override fun getItemCount(): Int {
        return movieList.size
    }


}