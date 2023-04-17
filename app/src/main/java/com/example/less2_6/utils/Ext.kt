package com.example.less2_6.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url : String) {
    Glide.with(this).load(url).into(this)
}