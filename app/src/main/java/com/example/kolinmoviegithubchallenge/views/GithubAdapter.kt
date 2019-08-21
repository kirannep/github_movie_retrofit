package com.example.kolinmoviegithubchallenge.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kolinmoviegithubchallenge.R
import com.example.kolinmoviegithubchallenge.models.github.GithubRepo
import kotlinx.android.synthetic.main.activity_github.view.*

class GithubAdapter(private val githubRepo: List<GithubRepo>)
    : RecyclerView.Adapter<GithubViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        return GithubViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_github,parent,false))
    }

    override fun getItemCount(): Int {
        return githubRepo.size
    }

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        holder.tvTitle.text = githubRepo[position].full_name
        holder.tvDescription.text = githubRepo[position].description
    }


}

class GithubViewHolder(view:View): RecyclerView.ViewHolder(view) {
    val tvTitle = view.tv_githubTitle
    val tvDescription = view.tv_githubDescription

}


