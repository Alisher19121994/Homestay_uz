package com.example.homestay_uz.adapters.base_adapter.favorite_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homestay_uz.R
import com.example.homestay_uz.models.favorite_model.Favorites
import com.google.android.material.imageview.ShapeableImageView

class FavoriteAdapter(var listOfFavorites: ArrayList<Favorites>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.favorite_items, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        val favorites = listOfFavorites[position]
        if (holder is FavoriteViewHolder) {

            val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.translate)
            holder.itemView.startAnimation(animation)


            holder.shapeableImageView.setImageResource(favorites.image)
            holder.title.text = favorites.title
            holder.price.text = favorites.price
            holder.comment.text = favorites.comment
        }
    }

    override fun getItemCount(): Int {
        return listOfFavorites.size
    }


    inner class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val shapeableImageView: ShapeableImageView =
            view.findViewById(R.id.favorite_shapeableImageView)
        val title: TextView = view.findViewById(R.id.favorite_title_textView)
        val price: TextView = view.findViewById(R.id.favorite_price_textView)
        val comment: TextView = view.findViewById(R.id.favorite_comment_textView)
    }

}