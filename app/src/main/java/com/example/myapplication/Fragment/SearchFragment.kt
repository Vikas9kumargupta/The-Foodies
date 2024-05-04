package com.example.myapplication.Fragment

import android.app.DownloadManager.Query
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.MenuAdapter
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    private lateinit var adapter : MenuAdapter
    private val originalMenuFoodName = listOf("Veg Roll","Salad","Ice-Cream","Dal-Makhni","Pasta","Burger","Fruit-Salad","Kadhai Paneer","Maggi","Pizza")
    private val originalMenuFoodPrice = listOf("$5","$6","$6","$8","$8","$6","$8","$10","$10","$15")
    private val originalMenuFoodImage = listOf(R.drawable.menu1,R.drawable.menu2,
        R.drawable.menu3,R.drawable.menu4,
        R.drawable.menu5,R.drawable.menu6,
        R.drawable.menu7,R.drawable.menu_item8,
        R.drawable.menu_9,R.drawable.menu_10)

    private val filterMenuFoodName = mutableListOf<String>()
    private val filterMenuFoodPrice = mutableListOf<String>()
    private val filterMenuFoodImage = mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSearchBinding.inflate(layoutInflater,container,false)
        adapter = MenuAdapter(filterMenuFoodName,
            filterMenuFoodPrice,
            filterMenuFoodImage,
            requireContext()
        )
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        setupSearchView()

        //show All menu Items
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filterMenuFoodName.clear()
        filterMenuFoodPrice.clear()
        filterMenuFoodImage.clear()

        filterMenuFoodName.addAll(originalMenuFoodName)
        filterMenuFoodPrice.addAll(originalMenuFoodPrice)
        filterMenuFoodImage.addAll(originalMenuFoodImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {
        filterMenuFoodName.clear()
        filterMenuFoodPrice.clear()
        filterMenuFoodImage.clear()

        originalMenuFoodName.forEachIndexed{index, foodName ->
            if(foodName.contains(query.toString(),ignoreCase = true)){
                filterMenuFoodName.add(foodName)
                filterMenuFoodPrice.add(originalMenuFoodPrice[index])
                filterMenuFoodImage.add(originalMenuFoodImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }
}
