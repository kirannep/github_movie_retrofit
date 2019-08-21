package com.example.kolinmoviegithubchallenge.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kolinmoviegithubchallenge.R
import com.example.kolinmoviegithubchallenge.constants.MovieConstants
import com.example.kolinmoviegithubchallenge.models.movie.MoviePopular
import com.example.kolinmoviegithubchallenge.network.githubNetwork.RetrofitInstance
import com.example.kolinmoviegithubchallenge.network.movieNetwork.MovieRequest
import com.example.kolinmoviegithubchallenge.network.movieNetwork.RetrofitInstanceMovie
import kotlinx.android.synthetic.main.recyclerview_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview_layout)

        val movieRequest = RetrofitInstanceMovie().retrofitInstance.create(MovieRequest::class.java)
        val call = movieRequest.getMoviesPopular(MovieConstants.API_KEY)
        call.enqueue(object:Callback<MoviePopular>{
            override fun onFailure(call: Call<MoviePopular>, t: Throwable) {
                Log.i("errormsg",t.message)
            }

            override fun onResponse(call: Call<MoviePopular>, response: Response<MoviePopular>) {
                val res = response.body()
                Log.i("MainActivity",res!!.results[0].title)

                val adapter:MovieAdapter = MovieAdapter(res)
                recyclerView.layoutManager = LinearLayoutManager(this@MovieActivity)
                recyclerView.adapter = adapter
            }

        })

    }
}
