package com.example.homestay_uz.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homestay_uz.R
import com.example.homestay_uz.models.ScreenView
import com.google.android.material.imageview.ShapeableImageView

class ScreenViewAdapter(var context: Context, var listOfScreenViews: ArrayList<ScreenView>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.screen_views_items, parent, false)
        return ScreenViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val screenView = listOfScreenViews[position]

        if (holder is ScreenViewViewHolder) {
            holder.additionalListOfItemsTextView.text = screenView.additionalListOfItemsTextName
            holder.additionalListOfItemsImageView.setImageResource(screenView.additionalListOfItemsImageView)
          //  holder.additionalListOfItemsImageView.setOnClickListener {}
        }
    }

    override fun getItemCount(): Int {
        return listOfScreenViews.size
    }


    inner class ScreenViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val additionalListOfItemsTextView: TextView =
            itemView.findViewById(R.id.list_items_textName_id)
        val additionalListOfItemsImageView: ShapeableImageView =
            itemView.findViewById(R.id.list_items_image_id)
    }

}