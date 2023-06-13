package com.example.appmovieremember

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import com.example.appmovieremember.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.commonWindowToolBar)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
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