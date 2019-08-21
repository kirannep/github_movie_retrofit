package com.example.kolinmoviegithubchallenge.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kolinmoviegithubchallenge.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onClick(view: View?) {
        var intent: Intent? = null
        when (view!!.id){
            R.id.btn_github ->{
                intent = Intent(this,GithubActivity::class.java)
            }
            R.id.btn_movie ->{
                intent = Intent(this, MovieActivity::class.java)
            }
        }
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_github.setOnClickListener(this)
        btn_movie.setOnClickListener(this)
    }
}
