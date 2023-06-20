package com.example.appmovieremember.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appmovieremember.databinding.FragmentFavoriteMovieBinding
import com.example.appmovieremember.ui.main.GithubRepoUsecase
import com.example.appmovieremember.ui.main.app
import java.lang.StringBuilder


class FavoriteMovieFragment : Fragment() {
    private var binding: FragmentFavoriteMovieBinding? = null
    private val gitHubRepoEntity: GithubRepoUsecase by lazy { requireActivity().app.githubRepoUsecase }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.downloadButton?.setOnClickListener {
            val userName  =binding?.userNameEditText?.text.toString()

            gitHubRepoEntity.getReposForUser(userName).observe(requireActivity()){
                val sb = StringBuilder()
                it.forEach {
                    sb.appendLine(it.toString())
                }

                    binding?.resultTextView?.text = sb.toString()
            }

/*
    gitHubRepoEntity.getReposForUserAsync(userName){
          val repos =   gitHubRepoEntity.getReposForUserSync(userName)
          val sb = StringBuilder()
          repos.forEach {
              sb.appendLine(it.toString())
          }
          requireActivity().runOnUiThread{
              binding?.resultTextView?.text = sb.toString()
          }
      } */


  }
}
override fun onDestroyView() {
  binding = null
  super.onDestroyView()

}
}