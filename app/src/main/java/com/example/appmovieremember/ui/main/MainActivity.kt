package com.example.appmovieremember.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmovieremember.R
import com.example.appmovieremember.databinding.ActivityMainBinding
import com.example.appmovieremember.databinding.FragmentBasicMovieBinding
import com.example.appmovieremember.domain.entity.MovieClass
import com.example.appmovieremember.domain.impl.MovieRepositoryImplementation
import com.example.appmovieremember.domain.repo.MovieRepository
import com.example.appmovieremember.ui.adapters.MoviesAdapter
import com.example.appmovieremember.ui.fragments.BasicMovieFragment
import com.example.appmovieremember.ui.fragments.FavoriteMovieFragment
import com.example.appmovieremember.ui.fragments.StackedMovieFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    public var repoMovieEasy: MovieRepository = MovieRepositoryImplementation()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.commonWindowToolBar)
        initFragmentAndOnClickBottomNavigationBar()
        createRepoEasy()
       // makeCurrentFragment(BasicMovieFragment())
    }



    private fun createRepoEasy() {
        repoMovieEasy.createMovie(
                MovieClass("https://thumbs.dfs.ivi.ru/storage5/contents/9/e/afef00f071174caaa41933f332524f.jpg",
                    "Duna","Я Фильм про1",2020,  6.9F, false)
        )
        repoMovieEasy.createMovie(
            MovieClass("https://www.kino-teatr.ru/movie/posters/big/9/130649.jpg",
                "Dgek","Я Фильм про2", 2019,  6.8F, true)
        )
        repoMovieEasy.createMovie(
            MovieClass("https://b1.filmpro.ru/c/812189.246x347.jpg",
                "Doctor","Я Фильм про3" ,2021,  6.7F,false)
        )
        repoMovieEasy.createMovie(
            MovieClass("https://www.vokrug.tv/pic/product/5/3/4/b/534b3e682082993013e1c27f5d039e8b.jpg",
            "Cosmos", "Я Фильм про4",2018,  6.5F,false)
        )
        repoMovieEasy.createMovie(MovieClass("https://b1.filmpro.ru/c/814656.492x694.jpg",
            "Rasomaxa", "Я Фильм про5",2010, 6.4F,false))
    }

    private fun initFragmentAndOnClickBottomNavigationBar() {
        val basicMovieFragment = BasicMovieFragment()
        val favoriteMovieFragment = FavoriteMovieFragment()
        val stackedMovieFragment = StackedMovieFragment()
        makeCurrentFragment(basicMovieFragment)
        binding.movieNavigationBar.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.home_navigation_bar ->  makeCurrentFragment(basicMovieFragment)
                R.id.favorite_navigation_bar ->  makeCurrentFragment(favoriteMovieFragment)
                R.id.stacked_navigation_bar ->  makeCurrentFragment(stackedMovieFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.movie_basic_fragment, fragment)
                .commit()
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.common_toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)

    }
    override fun onOptionsItemSelected(item: MenuItem)= when (item.itemId) {
        R.id.search_movie -> {
            // User chose the "Print" item
            Toast.makeText(this,"Поиск", Toast.LENGTH_LONG).show()
            true
        }
        R.id.setting_movie ->{
            Toast.makeText(this,"Настрояка",Toast.LENGTH_LONG).show()
            true
        }
        R.id.exit_movie ->{
            Toast.makeText(this,"Выход",Toast.LENGTH_LONG).show()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}