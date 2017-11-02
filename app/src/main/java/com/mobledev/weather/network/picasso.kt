package com.mobledev.weather.network

import android.content.Context
import com.squareup.picasso.Picasso

/**
 * Created by Manu on 11/2/2017.
 */
public val Context.picasso: Picasso
    get() = Picasso.with(this)