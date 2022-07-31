package com.example.myropstamtaskapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.myropstamtaskapp.R
import com.example.myropstamtaskapp.interfaces.ClickInterface
import com.example.myropstamtaskapp.models.ProductModel

class ProductsAdapter(private var productList: MutableList<ProductModel>,val clickInterface: ClickInterface) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.imgFlag?.load(currentItem.productImg) {
            crossfade(true)
        }
        holder.txtName?.text = currentItem.productName
        holder.txtComment?.text = currentItem.productRate

        holder.openItem?.setOnClickListener {
            clickInterface.openItem(currentItem.productImg,currentItem.productName,currentItem.productRate)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item_row, parent, false)

        return ViewHolder(itemView)
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var txtName: TextView? = null
        var txtComment: TextView? = null
        var imgFlag: ImageView? = null
        var openItem: LinearLayout? = null

        init {
            this.txtName = row.findViewById(R.id.txtName)
            this.txtComment = row.findViewById(R.id.txtComment)
            this.imgFlag = row.findViewById(R.id.imgFlag)
            this.openItem = row.findViewById(R.id.openItem)
        }
    }
}