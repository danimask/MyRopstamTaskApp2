package com.example.myropstamtaskapp.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myropstamtaskapp.R
import com.example.myropstamtaskapp.activities.ProductDetailActivity
import com.example.myropstamtaskapp.adapters.ProductsAdapter
import com.example.myropstamtaskapp.databinding.FragmentHomeBinding
import com.example.myropstamtaskapp.interfaces.ClickInterface
import com.example.myropstamtaskapp.models.ProductModel
import com.example.myropstamtaskapp.utils.EasyFunctions


class HomeFragment : Fragment(), AdapterView.OnItemSelectedListener,ClickInterface {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var myView: View
    private var listOfItemsSpinner = arrayOf("Gurgaan", "Gurgaan 2", "Gurgaan 3", "Gurgaan 4")
    private lateinit var productItemList: ArrayList<ProductModel>
    private lateinit var productsAdapter: ProductsAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )
        myView = binding.root
        init()
        return myView
    }

    private fun init() {
        productItemList = ArrayList()
        populateList()

        binding.spinner.onItemSelectedListener = this
        val spinnerAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, listOfItemsSpinner)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = spinnerAdapter


        binding.trendingRecyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.trendingRecyclerView.itemAnimator = DefaultItemAnimator()
        productsAdapter = ProductsAdapter(productItemList,this)
        binding.trendingRecyclerView.adapter = productsAdapter

        binding.recentRecyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.recentRecyclerView.itemAnimator = DefaultItemAnimator()
        productsAdapter = ProductsAdapter(productItemList,this)
        binding.recentRecyclerView.adapter = productsAdapter



    }



    override fun onItemSelected(parent: AdapterView<*>?, itemView: View?, position: Int, p3: Long) {
        (itemView as TextView).setTextColor(Color.WHITE)
        EasyFunctions.showLog("spinnerItem",listOfItemsSpinner[position] + "is selected")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun populateList() {
        productItemList.add(
            0,
            ProductModel(R.drawable.ic_home_upperbg, "Sofa Baleria", "₹849/month")
        )
        productItemList.add(
            1,
            ProductModel(R.drawable.ic_home_upperbg, "Sofa Baleria", "₹849/month")
        )
        productItemList.add(
            2,
            ProductModel(R.drawable.ic_home_upperbg, "Sofa Baleria", "₹849/month")
        )
        productItemList.add(
            3,
            ProductModel(R.drawable.ic_home_upperbg, "Sofa Baleria", "₹849/month")
        )
        productItemList.add(
            4,
            ProductModel(R.drawable.ic_home_upperbg, "Sofa Baleria", "₹849/month")
        )
    }

    override fun openItem(productImage: Int, productName: String, productRate: String) {
        EasyFunctions.nextActivity(requireActivity(),ProductDetailActivity())
    }

}