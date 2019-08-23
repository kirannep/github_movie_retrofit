package com.example.kolinmoviegithubchallenge.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kolinmoviegithubchallenge.R
import com.example.kolinmoviegithubchallenge.common.inflate
import com.example.kolinmoviegithubchallenge.common.loadUrl
import com.example.kolinmoviegithubchallenge.common.removeFirstLetter
import com.example.kolinmoviegithubchallenge.common.constants.MovieConstants
import com.example.kolinmoviegithubchallenge.models.movie.MoviePopular
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie.view.*

class MovieAdapter(private val moviePopular: MoviePopular)
    :RecyclerView.Adapter<MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        //return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_movie,parent,false))
        return MovieViewHolder(parent.inflate(R.layout.activity_movie,false))
    }

    override fun getItemCount(): Int {
        return moviePopular.results.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.tvTitle.text = moviePopular.results[position].title.removeFirstLetter()
        //Picasso.get().load(MovieConstants.PICTURE_PATH+moviePopular.results[position].poster_path).into(holder.img);
        holder.img.loadUrl(MovieConstants.PICTURE_PATH+moviePopular.results[position].poster_path)
    }

}

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val tvTitle = view.tv_movieTitle
    val img = view.iv_image

}
