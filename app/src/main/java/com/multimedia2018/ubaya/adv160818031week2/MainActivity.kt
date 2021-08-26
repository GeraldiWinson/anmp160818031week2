package com.multimedia2018.ubaya.adv160818031week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout) //drawerLayout => Week 3 add-ons

        //Week 3 add-ons
        NavigationUI.setupWithNavController(navView, navController)

        bottomNav.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp()
    }
}
//Nyalakan semua comment line untuk mengaktifkan soft back button
//Untuk sistem game ini, justru sebaiknya tidak menggunakan soft back agar pemain tidak 'berbuat curang'


//CTRL + Shift + [/] untuk auto comment versi block
//CTRL + [/] untuk auto comment versi line