package com.example.myapplication.SignIn

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.myapplication.CongratsBottomSheet
import com.example.myapplication.Fragment.CartFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityPayOutBinding

class PayOutActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPayOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.placeMyOrderButton.setOnClickListener {
            val bottomSheetDialog = CongratsBottomSheet()

        }
    }
}
