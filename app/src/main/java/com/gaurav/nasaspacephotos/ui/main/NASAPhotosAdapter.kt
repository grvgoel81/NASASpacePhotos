package com.gaurav.nasaspacephotos.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gaurav.nasaspacephotos.data.model.SpacePhotos
import com.gaurav.nasaspacephotos.databinding.ItemSpacePhotoBinding

/**
 * Created by gauravgoel on 10/February/2021
 */
class NASAPhotosAdapter(private val items: List<SpacePhotos>, private val callback: (Int) -> Unit) :
    RecyclerView.Adapter<NASAPhotosAdapter.PhotosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(
            ItemSpacePhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount() = items.size

    inner class PhotosViewHolder(private val binding: ItemSpacePhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            spacePhoto: SpacePhotos,
            itemPosition: Int
        ) {
            binding.spacePhoto = spacePhoto
            itemView.setOnClickListener {
                callback(itemPosition)
            }
        }
    }
}