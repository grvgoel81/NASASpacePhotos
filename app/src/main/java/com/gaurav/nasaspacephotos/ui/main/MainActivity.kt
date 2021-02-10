package com.gaurav.nasaspacephotos.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.gaurav.nasaspacephotos.R
import com.gaurav.nasaspacephotos.databinding.ActivityMainBinding
import com.gaurav.nasaspacephotos.ui.photodetails.NASAPhotoDetailsActivity
import com.gaurav.nasaspacephotos.utils.extensions.bindContentView
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private var nasaPhotosAdapter: NASAPhotosAdapter? = null
    private val viewModel: NASAPhotosVewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding = bindContentView(R.layout.activity_main)
        activityMainBinding.viewModel = viewModel

        viewModel.spacePhotosList.observe(this, Observer {
            Timber.d("Size of Photos data = ${it.size}")
            activityMainBinding.rvSpacePhotos.apply {
                nasaPhotosAdapter = NASAPhotosAdapter(it) { position ->
                    goToNASAPhotoDetailActivity(position)
                }
                layoutManager = GridLayoutManager(this@MainActivity, 2)
                adapter = nasaPhotosAdapter
            }
        })
    }

    private fun goToNASAPhotoDetailActivity(itemPosition: Int) {
        startActivity(NASAPhotoDetailsActivity.getStartIntent(this, itemPosition))
    }
}

