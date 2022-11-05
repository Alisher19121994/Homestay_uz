package com.example.homestay_uz.adapters.base_adapter.subAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homestay_uz.R
import com.example.homestay_uz.models.base_model.MainAdds
import com.google.android.material.imageview.ShapeableImageView
import java.util.LinkedList

class MainAddsAdapters(var context: Context, var listOfMainAdds: LinkedList<MainAdds>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.screen_adds_item, parent, false)
        return MainAddsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mainAdds = listOfMainAdds[position]

        if (holder is MainAddsViewHolder) {
            holder.mainAdds.setImageResource(mainAdds.mainAdds)
        }
    }

    override fun getItemCount(): Int {
        return listOfMainAdds.size
    }


    inner class MainAddsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val mainAdds: ShapeableImageView = itemView.findViewById(R.id.screen_adds_item)
    }

}