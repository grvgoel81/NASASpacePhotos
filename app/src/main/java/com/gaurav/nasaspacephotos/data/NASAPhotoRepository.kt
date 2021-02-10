package com.gaurav.nasaspacephotos.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gaurav.nasaspacephotos.data.model.SpacePhotos
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.IOException
import java.lang.reflect.Type

/**
 * Created by gauravgoel on 10/February/2021
 */
class NASAPhotoRepository {

    val spacePhotosListMutableLiveData = MutableLiveData<List<SpacePhotos>>()
    private val moshi = Moshi.Builder().build()
    private val type: Type = Types.newParameterizedType(List::class.java, SpacePhotos::class.java)
    private val jsonAdapter: JsonAdapter<List<SpacePhotos>> = moshi.adapter(type)

    fun getSpacePhotos(context: Context): LiveData<List<SpacePhotos>> {
        getSpacePhotoJsonData(context)?.let { json ->
            val photos: List<SpacePhotos>? = jsonAdapter.fromJson(json)
            photos?.let { listOfPhotos ->
                spacePhotosListMutableLiveData.value = listOfPhotos.reversed()
            }
        }
        return spacePhotosListMutableLiveData
    }

    private fun getSpacePhotoJsonData(context: Context): String? {
        val json: String
        try {
            val inputStream = context.assets.open("data.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.use { it.read(buffer) }
            json = String(buffer)
            inputStream.close()
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return json
    }
}