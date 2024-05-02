package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.MenuAdapter
import com.example.myapplication.databinding.FragmentCartBinding
import com.example.myapplication.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        binding.buttonBack.setOnClickListener {
            dismiss()
        }
        val menuFoodName = listOf("Veg Roll","Salad","Ice-Cream","Dal-Makhni","Pasta","Burger",
            "Fruit-Salad","Kadhai Paneer","Maggi","Pizza")
        val menuFoodPrice = listOf("$5","$6","$6","$8","$8","$6","$8","$10","$10","$15")
        val menuFoodImage = listOf(R.drawable.menu1,R.drawable.menu2,
            R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu5,R.drawable.menu6,
            R.drawable.menu7,R.drawable.menu_item8,
            R.drawable.menu_9,R.drawable.menu_10)

        val adapter = MenuAdapter(ArrayList(menuFoodName),ArrayList(menuFoodPrice),ArrayList(menuFoodImage))
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        return binding.root
    }

}