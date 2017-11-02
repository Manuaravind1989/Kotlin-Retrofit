package com.mobledev.weather.network

import com.mobledev.weather.model.MovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Manu on 11/2/2017.
 */

interface ApiInterface {
    @GET("popular?")
    fun getAlbum(@Query("api_key") api_key: String): Call<MovieModel>
}