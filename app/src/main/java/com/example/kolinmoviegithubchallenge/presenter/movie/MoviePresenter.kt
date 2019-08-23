package com.example.kolinmoviegithubchallenge.presenter.movie

import android.util.Log
import com.example.kolinmoviegithubchallenge.common.constants.MovieConstants
import com.example.kolinmoviegithubchallenge.models.movie.MoviePopular
import com.example.kolinmoviegithubchallenge.network.movieNetwork.MovieRequest
import com.example.kolinmoviegithubchallenge.network.movieNetwork.RetrofitInstanceMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter:BasePresenter<MovieView>() {

    override fun onViewAttached(view: MovieView) {
        super.onViewAttached(view)
        val movieRequest = RetrofitInstanceMovie().retrofitInstance.create(MovieRequest::class.java)
        val call = movieRequest.getMoviesPopular(MovieConstants.API_KEY)
        call.enqueue(object : Callback<MoviePopular> {
            override fun onFailure(call: Call<MoviePopular>, t: Throwable) {
                Log.i("errormsg", t.message)
            }

            override fun onResponse(call: Call<MoviePopular>, response: Response<MoviePopular>) {
                val res = response.body()
                view.showMovieInfo(res!!)
            }
        })
    }
}

interface MovieView:BasePresenter.View {
    fun showMovieInfo(moviePopular: MoviePopular)
    fun showLoading()
}



