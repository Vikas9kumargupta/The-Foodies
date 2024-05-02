package com.example.myapplication.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.CongratsBottomSheet
import com.example.myapplication.R
import com.example.myapplication.SignIn.PayOutActivity
import com.example.myapplication.adapter.CartAdapter
import com.example.myapplication.databinding.FragmentCartBinding
import com.example.myapplication.databinding.FragmentHistoryBinding
import com.example.myapplication.databinding.FragmentHomeBinding


class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater,container,false)
        val cartFoodname = listOf("Veg Roll","Salad","Ice-Cream","Dal-Makhni","Pasta","Burger","Fruit-Salad","Kadhai Paneer","Maggi","Pizza")
        val cartFoodPrice = listOf("$5","$6","$6","$8","$8","$6","$8","$10","$10","$15")
        val cartFoodImage = listOf(R.drawable.menu1,R.drawable.menu2,
            R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu5,R.drawable.menu6,
            R.drawable.menu7,R.drawable.menu_item8,
            R.drawable.menu_9,R.drawable.menu_10)

        val adapter = CartAdapter(ArrayList(cartFoodname),ArrayList(cartFoodPrice),ArrayList(cartFoodImage))
        binding.cartRV.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRV.adapter = adapter

        binding.proceedButton.setOnClickListener {
            val intent = Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }
}