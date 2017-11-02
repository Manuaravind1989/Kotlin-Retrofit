package com.mobledev.weather

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mobledev.weather.model.MovieModel
import com.mobledev.weather.network.HttpConstants
import com.squareup.picasso.Picasso

/**
 * Created by Manu on 11/2/2017.
 */
class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    var act: Context? = null
    var movieItem: List<MovieModel.ResultsEntity>? = null

    constructor(recyclerViewActivity: Context, movieList: List<MovieModel.ResultsEntity>) {
        act = recyclerViewActivity
        movieItem = movieList
    }

    override fun getItemCount(): Int {
        return movieItem?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(act).inflate(R.layout.recycler_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.text_list?.setText(movieItem!![position].original_title)
        holder?.image_list?.loadUrl(HttpConstants.IMAGE_URL + movieItem!![position].poster_path as String)
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var text_list: TextView? = itemView?.findViewById<TextView>(R.id.text_wadah)
        var image_list: ImageView? = itemView?.findViewById<ImageView>(R.id.image_wadah)
        var card_list: CardView? = itemView?.findViewById<CardView>(R.id.card_view_wadah)
    }

    fun ImageView.loadUrl(url: String) {
        Picasso.with(context).load(url).into(this)
    }


}