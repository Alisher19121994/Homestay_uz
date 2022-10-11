package com.example.homestay_uz.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homestay_uz.R
import com.example.homestay_uz.models.Items
import com.google.android.material.imageview.ShapeableImageView

class AdditionalsAdapter( var context: Context,  var listOfItems: ArrayList<Items>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.additional_list_items, parent, false)
        return AdditionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val items = listOfItems[position]

        if (holder is AdditionsViewHolder) {
            holder.additional_list_items_textName.text = items.additional_list_items_textName
            holder.additional_list_items_image.setImageResource(items.additional_list_items_image)
        }
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }

    class AdditionsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var additional_list_items_textName: TextView =
            view.findViewById(R.id.additional_list_items_textName_id)
        var additional_list_items_image: ShapeableImageView =
            view.findViewById(R.id.additional_list_items_image_id)

    }
}