package com.example.kolinmoviegithubchallenge.presenter.github

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kolinmoviegithubchallenge.models.github.GithubRepo
import com.example.kolinmoviegithubchallenge.network.githubNetwork.GetRepo
import com.example.kolinmoviegithubchallenge.network.githubNetwork.RetrofitInstance
import com.example.kolinmoviegithubchallenge.views.GithubAdapter
import kotlinx.android.synthetic.main.recyclerview_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubPresenter :BasePresenter<GithubView>() {

    override fun onViewAttached(view: GithubView) {
        super.onViewAttached(view)
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
                view.showGithubInfo(res)


            }
        })
    }
}

interface GithubView:BasePresenter.View{
    fun showGithubInfo(github:List<GithubRepo>)
    fun showLoading()
}