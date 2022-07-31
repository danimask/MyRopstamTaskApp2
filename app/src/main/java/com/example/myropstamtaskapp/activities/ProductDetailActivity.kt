package com.example.myropstamtaskapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myropstamtaskapp.R
import com.example.myropstamtaskapp.utils.EasyFunctions

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EasyFunctions.setStatusBarGradiant(this)
        setContentView(R.layout.activity_product_detail)
    }
}