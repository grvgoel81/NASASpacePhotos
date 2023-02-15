package com.gaurav.nasaspacephotos.ui.photodetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gaurav.nasaspacephotos.R
import com.gaurav.nasaspacephotos.databinding.ActivityPhotoDetailsBinding
import com.gaurav.nasaspacephotos.ui.main.NASAPhotosVewModel
import com.gaurav.nasaspacephotos.utils.extensions.bindContentView

/**
 * Created by gauravgoel on 10/February/2021
 */
class NASAPhotoDetailsActivity : AppCompatActivity() {

    private lateinit var activityPhotoDetailsBinding: ActivityPhotoDetailsBinding
    private val viewModel: NASAPhotosVewModel by viewModels()
    private lateinit var nasaPhotosDetailsAdapter: NASAPhotosDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPhotoDetailsBinding = bindContentView(R.layout.activity_photo_details)
        nasaPhotosDetailsAdapter = NASAPhotosDetailsAdapter()
        activityPhotoDetailsBinding.viewpager.adapter = nasaPhotosDetailsAdapter

        supportActionBar?.hide()

        val position = intent.getSerializableExtra(KEY_POSITION) as Int

        viewModel.spacePhotosList.observe(this, Observer {
            it.let {
                nasaPhotosDetailsAdapter?.addPhotos(it)
                activityPhotoDetailsBinding.viewpager.setCurrentItem(position, false)
            }
        })
    }

    companion object {

        private const val KEY_POSITION = "positio"


        fun getStartIntent(context: Context, position: Int): Intent {
            return Intent(context, NASAPhotoDetailsActivity::class.java).apply {
                putExtra(KEY_POSITION, position)
            }
        }
    }
}
