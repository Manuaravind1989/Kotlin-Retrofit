package com.mobledev.weather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.mobledev.weather.model.MovieModel
import com.mobledev.weather.network.ApiClient
import com.mobledev.weather.network.HttpConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity(), Callback<MovieModel> {

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView!!.layoutManager = LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false)
        ApiClient.apiInterface.getAlbum(HttpConstants.API_KEY).enqueue(this)
    }

    override fun onFailure(call: Call<MovieModel>?, t: Throwable?) {
        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<MovieModel>?, response: Response<MovieModel>?) {
        if (response!!.isSuccessful) {
//            for (item: MovieModel.ResultsEntity in response.body().results!!) {
//                println(item.original_title)
//            }

            var recyclerAdapter = RecyclerViewAdapter(this, response.body().results!!)
            recyclerView!!.adapter = recyclerAdapter
        }
    }
}
