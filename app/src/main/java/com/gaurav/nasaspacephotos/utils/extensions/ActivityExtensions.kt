package com.gaurav.nasaspacephotos.utils.extensions

import android.app.Activity
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by gauravgoel on 10/February/2021
 */
fun <B : ViewDataBinding> Activity.bindContentView(@LayoutRes layout: Int): B {
    return DataBindingUtil.setContentView(this, layout)
}