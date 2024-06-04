package com.stiki.slider

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stiki.slider.databinding.ItemSliderBinding

class SliderAdapter(
    private val data : List<String>
)  : RecyclerView.Adapter<SliderAdapter.ImageViewHolder>() {

    class ImageViewHolder(
        private val binding : ItemSliderBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : String) {
            // Set View Disini
            binding.txtWord.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemSliderBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
       holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}