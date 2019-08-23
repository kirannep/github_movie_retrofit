package com.example.kolinmoviegithubchallenge.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kolinmoviegithubchallenge.R
import com.example.kolinmoviegithubchallenge.common.enqueue
import com.example.kolinmoviegithubchallenge.models.github.GithubRepo
import com.example.kolinmoviegithubchallenge.network.githubNetwork.RetrofitInstance
import com.example.kolinmoviegithubchallenge.network.githubNetwork.GetRepo
import com.example.kolinmoviegithubchallenge.presenter.github.GithubPresenter
import com.example.kolinmoviegithubchallenge.presenter.github.GithubView
import kotlinx.android.synthetic.main.recyclerview_layout.*
//import com.example.kolinmoviegithubchallenge.constants.GithubConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GithubActivity : AppCompatActivity(),GithubView {
    val presenter:GithubPresenter = GithubPresenter()
    override fun showGithubInfo(github: List<GithubRepo>) {
        adapter = GithubAdapter(github)

        recyclerView.layoutManager = LinearLayoutManager(this@GithubActivity)
        recyclerView.adapter = adapter
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var adapter:GithubAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview_layout)
        presenter.onViewAttached(this)

//        call.enqueue(object: Callback<List<GithubRepo>> {
//            override fun onFailure(call: Call<List<GithubRepo>>, t: Throwable) {
//                Log.i("errormsg",t.message)
//            }
//
//            override fun onResponse(call: Call<List<GithubRepo>>, response: Response<List<GithubRepo>>) {
//                val res = response.body()
//                Log.i("hello",res!![0].full_name)
//                Log.i("hello1",res!![1].description)
//
//                adapter = GithubAdapter(res)
//
//                recyclerView.layoutManager = LinearLayoutManager(this@GithubActivity)
//                recyclerView.adapter = adapter
//
//            }
//        })




    }
}
