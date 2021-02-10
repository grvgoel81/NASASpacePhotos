package com.gaurav.nasaspacephotos.ui.photodetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gaurav.nasaspacephotos.data.model.SpacePhotos
import com.gaurav.nasaspacephotos.databinding.ItemViewpagerBinding

/**
 * Created by gauravgoel on 10/February/2021
 */
class NASAPhotosDetailsAdapter :
    RecyclerView.Adapter<NASAPhotosDetailsAdapter.PhotoDetailsViewHolder>() {

    private var spacePhotosList = ArrayList<SpacePhotos>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NASAPhotosDetailsAdapter.PhotoDetailsViewHolder {
        return PhotoDetailsViewHolder(
            ItemViewpagerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = spacePhotosList.size

    override fun onBindViewHolder(
        holder: NASAPhotosDetailsAdapter.PhotoDetailsViewHolder,
        position: Int
    ) {
        holder.bind(spacePhotosList[position])
    }

    inner class PhotoDetailsViewHolder(private val binding: ItemViewpagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            spacePhoto: SpacePhotos
        ) {
            binding.spacePhoto = spacePhoto
        }
    }

    fun addPhotos(photosList: List<SpacePhotos>){
        this.spacePhotosList.clear()
        val position = photosList.size
        photosList.forEach {
            this.spacePhotosList.add(it)
            notifyItemInserted(position - 1)
        }
    }
}