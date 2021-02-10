package com.gaurav.nasaspacephotos.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import timber.log.Timber

/**
 * Created by gauravgoel on 10/February/2021
 */
@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?) {
    if (url != null) {
        val requestOption = RequestOptions()
        Timber.d("original image url: $url")
        Timber.d("trimmed image url: ${url.trim()}")

        Glide.with(imageView.context)
            .load(url)
            .apply(requestOption)
            .into(imageView)
    }
}

@BindingAdapter("visibility")
fun setVisibility(view: View, boolean: Boolean) {
    view.visibility = if (boolean) View.VISIBLE else View.GONE
}