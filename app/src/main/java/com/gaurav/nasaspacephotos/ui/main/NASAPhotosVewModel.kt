package com.gaurav.nasaspacephotos.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.gaurav.nasaspacephotos.data.NASAPhotoRepository
import com.gaurav.nasaspacephotos.data.model.SpacePhotos

/**
 * Created by gauravgoel on 10/February/2021
 */
class NASAPhotosVewModel (application: Application) : AndroidViewModel(application) {

    private val nasaPhotoRepository = NASAPhotoRepository()
    val spacePhotosList: LiveData<List<SpacePhotos>> = nasaPhotoRepository.spacePhotosListMutableLiveData

    init {
        nasaPhotoRepository.getSpacePhotos(application.applicationContext)
    }
}