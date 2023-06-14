package com.example.appmovieremember.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appmovieremember.R
import com.example.appmovieremember.databinding.FragmentFavoriteMovieBinding
import com.example.appmovieremember.databinding.FragmentStackedMovieBinding

class StackedMovieFragment : Fragment() {
    private var binding:FragmentStackedMovieBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStackedMovieBinding.inflate(layoutInflater, container,false)
        return binding?.root
    }


    override fun onDestroyView() {
        binding= null
        super.onDestroyView()

    }
}