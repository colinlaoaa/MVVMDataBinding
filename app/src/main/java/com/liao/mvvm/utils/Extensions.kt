package com.liao.mvvm.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.liao.mvvm.R

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String?){
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.ic_baseline_account_box_24)
        .into(this)
}