package com.example.kolinmoviegithubchallenge.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kolinmoviegithubchallenge.R
import com.example.kolinmoviegithubchallenge.models.github.GithubRepo
import com.example.kolinmoviegithubchallenge.network.githubNetwork.RetrofitInstance
import com.example.kolinmoviegithubchallenge.network.githubNetwork.GetRepo
import kotlinx.android.synthetic.main.recyclerview_layout.*
//import com.example.kolinmoviegithubchallenge.constants.GithubConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GithubActivity : AppCompatActivity() {
    var adapter:GithubAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview_layout)

        val getRepo = RetrofitInstance().retrofitInstance.create(GetRepo::class.java)
        val call: Call<List<GithubRepo>> = getRepo.getRepos("kirannep")
        call.enqueue(object: Callback<List<GithubRepo>> {
            override fun onFailure(call: Call<List<GithubRepo>>, t: Throwable) {
                Log.i("errormsg",t.message)
            }

            override fun onResponse(call: Call<List<GithubRepo>>, response: Response<List<GithubRepo>>) {
                val res = response.body()
                Log.i("hello",res!![0].full_name)
                Log.i("hello1",res!![1].description)

                adapter = GithubAdapter(res)

                recyclerView.layoutManager = LinearLayoutManager(this@GithubActivity)
                recyclerView.adapter = adapter

            }
        })


    }
}
