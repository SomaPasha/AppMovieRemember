package com.example.appmovieremember.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.appmovieremember.R
import com.example.appmovieremember.databinding.ActivityMainBinding
import com.example.appmovieremember.ui.fragments.BasicMovieFragment
import com.example.appmovieremember.ui.fragments.FavoriteMovieFragment
import com.example.appmovieremember.ui.fragments.StackedMovieFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.commonWindowToolBar)
        initFragmentAndOnClickBottomNavigationBar()
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
            replace(R.id.movie_basic_fragment, fragment).commit()
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