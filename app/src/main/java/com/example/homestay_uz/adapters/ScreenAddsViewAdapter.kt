package com.example.homestay_uz.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homestay_uz.R
import com.example.homestay_uz.models.ScreenAddsView
import com.google.android.material.imageview.ShapeableImageView

class ScreenAddsViewAdapter(private var context: Context, private var listOfScreenAddsView:ArrayList<ScreenAddsView>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.adds_view_inmain_screen,parent,false)
        return ScreenAddsViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val screenAddsView = listOfScreenAddsView[position]
        if (holder is ScreenAddsViewViewHolder){
            holder.homeOfScreenInImageView.setImageResource(screenAddsView.addsMainImageView)
            holder.homeOfScreenInTitle.text = screenAddsView.homeOfScreenInTitle
            holder.homeOfScreenInPrice.text = screenAddsView.homeOfScreenInPrice
            holder.homeOfScreenInComment.text = screenAddsView.homeOfScreenInComment
        }
    }

    override fun getItemCount(): Int {

        return listOfScreenAddsView.size
    }

    inner class ScreenAddsViewViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val homeOfScreenInImageView:ShapeableImageView = itemView.findViewById(R.id.adds_main_shapeableImageView)
        val homeOfScreenInTitle:TextView = itemView.findViewById(R.id.home_screen_title_textView)
        val homeOfScreenInPrice:TextView = itemView.findViewById(R.id.home_screen_price_textView)
        val homeOfScreenInComment:TextView = itemView.findViewById(R.id.home_screen_comment_textView)
    }
}