package com.example.appmovieremember.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmovieremember.R
import com.example.appmovieremember.databinding.FragmentBasicMovieBinding
import com.example.appmovieremember.domain.repo.MovieRepository
import com.example.appmovieremember.ui.adapters.MoviesAdapter
import com.example.appmovieremember.ui.main.MainActivity

class BasicMovieFragment : Fragment() {
    private  var binding: FragmentBasicMovieBinding? = null
    var recyclerView: RecyclerView? = null
    var adapter: MoviesAdapter = MoviesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


      binding =  FragmentBasicMovieBinding.inflate(layoutInflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecyclerView(view)
        super.onViewCreated(view, savedInstanceState)
    }
    private fun initRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.movie_basic_recycler_view)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        adapter.setDataBase((requireActivity() as  MainActivity).repoMovieEasy.getMovie())

    }

    private fun initRecyclerViewGroup(
        recyclerView: RecyclerView?,
        adapter: MoviesAdapter,
        moviesRepo: MovieRepository
    ) {


    }

    override fun onDestroyView() {
        binding= null
        super.onDestroyView()

    }
}