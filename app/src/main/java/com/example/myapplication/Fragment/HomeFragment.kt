package com.example.myapplication.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
//import com.denzcoskun.imageslider.constants.ScaleTypes
//import com.denzcoskun.imageslider.interfaces.ItemChangeListener
//import com.denzcoskun.imageslider.interfaces.ItemClickListener
//import com.denzcoskun.imageslider.models.SlideModel
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val imageList = ArrayList<SlideModel>()
//        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
//        imageList.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
//        imageList.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))
//
//        val imageSlider = binding.imageSlider
//        imageSlider.setImageList(imageList)
//        imageSlider.setImageList(imageList, ScaleTypes.FIT)

//
    }

}