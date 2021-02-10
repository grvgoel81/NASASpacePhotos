package com.gaurav.nasaspacephotos

import android.app.Application
import com.gaurav.nasaspacephotos.utils.ReleaseTree
import timber.log.Timber

/**
 * Created by gauravgoel on 10/February/2021
 */
class NASAApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(ReleaseTree())
    }
}