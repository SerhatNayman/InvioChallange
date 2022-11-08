package com.serosoft.inviochallange.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serosoft.inviochallange.R
import com.serosoft.inviochallange.data.entity.Movie
import com.serosoft.inviochallange.databinding.ItemMovieBinding

class MovieAdapter(
    var movieList: List<Movie>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<MovieAdapter.CardDesign>() {

    inner class CardDesign(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {

                txtTitle.text = "${movie.title}"
                txtGenre.text = "${movie.genre}"
                txtPlot.text = "${movie.plot}"
                Glide.with(imgItemView).load(movie.poster).into(imgItemView)

                root.setOnClickListener {
                    movie.let {
                        onItemClick
                    }
                }
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemMovieBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_movie, parent, false)
        return CardDesign(binding)
    }

    override fun onBindViewHolder(holder: CardDesign, position: Int) =
        holder.bind(movieList[position])

    override fun getItemCount(): Int = movieList.size

}