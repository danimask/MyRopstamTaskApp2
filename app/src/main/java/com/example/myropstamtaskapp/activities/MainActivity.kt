package com.example.myropstamtaskapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myropstamtaskapp.R
import com.example.myropstamtaskapp.databinding.ActivityMainBinding
import com.example.myropstamtaskapp.fragments.CartFragment
import com.example.myropstamtaskapp.fragments.HomeFragment
import com.example.myropstamtaskapp.fragments.ProductsFragment
import com.example.myropstamtaskapp.fragments.ProfileFragment
import com.example.myropstamtaskapp.utils.EasyFunctions

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EasyFunctions.showCustomUI(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initUi()
    }

    private fun initUi() {

        replaceFragment(HomeFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.products -> replaceFragment(ProductsFragment())
                R.id.cart -> replaceFragment(CartFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
            }

            true

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}