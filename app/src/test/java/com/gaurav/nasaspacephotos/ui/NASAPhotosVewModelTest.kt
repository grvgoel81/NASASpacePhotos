package com.gaurav.nasaspacephotos.ui

import com.gaurav.nasaspacephotos.data.SpacePhotosTest
import com.gaurav.nasaspacephotos.data.model.SpacePhotos
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.IOException
import java.lang.reflect.Type

/**
 * Created by gauravgoel on 10/February/2021
 */
class NASAPhotosVewModelTest {

    private lateinit var spacePhotos: SpacePhotos
    private val moshi = Moshi.Builder().build()
    private val type: Type = Types.newParameterizedType(List::class.java, SpacePhotos::class.java)
    private val jsonAdapter: JsonAdapter<List<SpacePhotos>> = moshi.adapter(type)

    @Before
    fun setUpDetailViewModelTest() {
        spacePhotos = SpacePhotosTest.photos
    }

    @Test
    fun getPhotos() {
        try {
            val inputStream = javaClass.classLoader?.getResourceAsStream("assets/data.json")
            val size = inputStream?.available()
            val buffer = size?.let { ByteArray(it) }
            inputStream.use { it?.read(buffer) }
            val json = buffer?.let { String(it) }
            inputStream?.close()
            json?.let {
                val photosList: List<SpacePhotos>? = jsonAdapter.fromJson(json)?.reversed()
                photosList?.let { listOfPhotos ->
                    assertEquals(listOfPhotos[0].copyright, spacePhotos.copyright)
                    assertEquals(listOfPhotos[0].date, spacePhotos.date)
                    assertEquals(listOfPhotos[0].explanation, spacePhotos.explanation)
                    assertEquals(listOfPhotos[0].hdurl, spacePhotos.hdurl)
                    assertEquals(listOfPhotos[0].media_type, spacePhotos.media_type)
                    assertEquals(listOfPhotos[0].service_version, spacePhotos.service_version)
                    assertEquals(listOfPhotos[0].title, spacePhotos.title)
                    assertEquals(listOfPhotos[0].url, spacePhotos.url)
                }
            }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }
    }
}