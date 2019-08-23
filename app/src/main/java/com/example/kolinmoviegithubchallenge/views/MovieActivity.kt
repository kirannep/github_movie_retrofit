package com.example.kolinmoviegithubchallenge.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kolinmoviegithubchallenge.R
import com.example.kolinmoviegithubchallenge.common.enqueue
import com.example.kolinmoviegithubchallenge.common.removeFirstLetter
import com.example.kolinmoviegithubchallenge.common.constants.MovieConstants
import com.example.kolinmoviegithubchallenge.models.movie.MoviePopular
import com.example.kolinmoviegithubchallenge.network.githubNetwork.RetrofitInstance
import com.example.kolinmoviegithubchallenge.network.movieNetwork.MovieRequest
import com.example.kolinmoviegithubchallenge.network.movieNetwork.RetrofitInstanceMovie
import com.example.kolinmoviegithubchallenge.presenter.movie.MoviePresenter
import com.example.kolinmoviegithubchallenge.presenter.movie.MovieView
import kotlinx.android.synthetic.main.recyclerview_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MovieActivity : AppCompatActivity(),MovieView {
    val presenter:MoviePresenter = MoviePresenter()
    //var adapter:MovieAdapter? = null
    override fun showMovieInfo(moviePopular: MoviePopular) {
        recyclerView.layoutManager = LinearLayoutManager(this@MovieActivity)
        recyclerView.adapter = MovieAdapter(moviePopular)

    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview_layout)
        presenter.onViewAttached(this)

//        call.enqueue(object:Callback<MoviePopular>{
//            override fun onFailure(call: Call<MoviePopular>, t: Throwable) {
//                Log.i("errormsg",t.message)
//            }
//
//            override fun onResponse(call: Call<MoviePopular>, response: Response<MoviePopular>) {
//                val res = response.body()

//        call.enqueue{
//            onResponse = {
//             success -> val res = success.body()
//                Log.i("MainActivity",res!!.results[0].title.removeFirstLetter())
//                val adapter:MovieAdapter = MovieAdapter(res)
//                recyclerView.adapter = adapter
//            }
//            onFailure = {
//            error -> Log.d("error",error?.message)
//
//            }
//
//        }



        }

    }

