package com.example.kolinmoviegithubchallenge.network.movieNetwork
import com.example.kolinmoviegithubchallenge.models.movie.MoviePopular
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieRequest {
    @GET("movie/popular")
    fun getMoviesPopular(@Query("api_key")  apiKey:String): Call<MoviePopular>

}