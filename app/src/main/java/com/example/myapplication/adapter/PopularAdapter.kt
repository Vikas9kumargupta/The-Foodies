package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.PopularItemBinding

class PopularAdapter(private val items: List<String>,
                     private val price: List<String>,
                     private val image:List<Int>)
    : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,images,price)
    }

    class PopularViewHolder (private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root){
        private val imageView = binding.foodPopularImage
        fun bind(item: String, images: Int, price : String) {
            binding.popularFoodName.text = item
            binding.foodPopularPrice.text = price
            imageView.setImageResource(images)
        }

    }
}