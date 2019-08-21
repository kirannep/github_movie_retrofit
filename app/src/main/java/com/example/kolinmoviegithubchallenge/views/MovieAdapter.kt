package com.example.kolinmoviegithubchallenge.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kolinmoviegithubchallenge.R
import com.example.kolinmoviegithubchallenge.constants.MovieConstants
import com.example.kolinmoviegithubchallenge.models.movie.MoviePopular
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie.view.*

class MovieAdapter(private val moviePopular: MoviePopular)
    :RecyclerView.Adapter<MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_movie,parent,false))
    }

    override fun getItemCount(): Int {
        return moviePopular.results.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.tvTitle.text = moviePopular.results[position].title
        Picasso.get().load(MovieConstants.PICTURE_PATH+moviePopular.results[position].poster_path).into(holder.img);

    }

}

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val tvTitle = view.tv_movieTitle
    val img = view.iv_image

}
