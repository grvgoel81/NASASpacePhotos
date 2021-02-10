package com.gaurav.nasaspacephotos.ui.main

import android.app.Application
import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaurav.nasaspacephotos.data.NASAPhotoRepository
import com.gaurav.nasaspacephotos.data.model.SpacePhotos

/**
 * Created by gauravgoel on 10/February/2021
 */
class NASAPhotosVewModel (application: Application) : AndroidViewModel(application) {

    private val nasaPhotoRepository = NASAPhotoRepository()
    val spacePhotosList: LiveData<List<SpacePhotos>> = nasaPhotoRepository.listOfPhotosMutableLiveData

    init {
        nasaPhotoRepository.getSpacePhotos(application.applicationContext)
    }
}