package com.example.reqres.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.reqres.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        //
        val navController = supportFragmentManager.findFragmentById(R.id.nav_host)!!.findNavController()
        val appBarConfiguration = AppBarConfiguration.Builder(
                R.id.mainFragment
        ).build()
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        NavigationUI.setupWithNavController(navView, navController)
    }
}