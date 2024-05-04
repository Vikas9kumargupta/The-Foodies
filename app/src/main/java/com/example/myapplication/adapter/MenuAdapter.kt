package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DetailsActivity
import com.example.myapplication.databinding.MenuItemBinding

class MenuAdapter(private val menuItemsName:MutableList<String>,
                  private val menuItemPrice:MutableList<String>,
                  private val menuItemImage:MutableList<Int>,
                  private val requireContext: Context)
    : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
        interface OnClickListener{
            fun onItemClick(position: Int)
        }
        private val itemClickListener : OnClickListener ?= null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return menuItemsName.size
    }

    inner class MenuViewHolder(private val binding : MenuItemBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener{
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION){
                    itemClickListener?.onItemClick(position)
                }

                val intent = Intent(requireContext, DetailsActivity::class.java)
                intent.putExtra("MenuItemName", menuItemsName[position])
                intent.putExtra("MenuItemImage", menuItemImage[position])

                requireContext.startActivity(intent)
            }
        }
        fun bind(position: Int) {
            binding.apply {
                menuFoodName.text = menuItemsName[position]
                menuFoodPrice.text = menuItemPrice[position]
                menuImage.setImageResource(menuItemImage[position])

                //set on Click Listener to open Details
            }
        }
    }
//    fun setOnClickListener(listener: OnClickListener){
//        itemClickListener = listener
//    }
}
