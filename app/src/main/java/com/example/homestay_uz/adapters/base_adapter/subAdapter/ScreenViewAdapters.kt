package com.example.homestay_uz.adapters.base_adapter.subAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.homestay_uz.R
import com.example.homestay_uz.models.base_model.ScreenView
import com.google.android.material.imageview.ShapeableImageView

class ScreenViewAdapters(var context: Context, var listOfScreenViews: ArrayList<ScreenView>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.screen_views_items, parent, false)
        return ScreenViewViewHolder(view)
    }

   // @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val screenView = listOfScreenViews[position]

        if (holder is ScreenViewViewHolder) {
            holder.additionalListOfItemsTextView.text = screenView.additionalListOfItemsTextName
            holder.shapeableImageView.setImageResource(screenView.additionalListOfItemsImageView)

            //   val animationViewHotel = AnimationUtils.loadAnimation(holder.itemView.context, )
            // holder.addLottieAnimationView.startAnimation(animationViewHotel)


            /*    val animationViewWeather =
                    AnimationUtils.loadAnimation(holder.itemView.context, R.raw.weather)
                holder.addLottieAnimationView.startAnimation(animationViewWeather)

                val animationViewTicket =
                    AnimationUtils.loadAnimation(holder.itemView.context, R.raw.ticket)
                holder.addLottieAnimationView.startAnimation(animationViewTicket)

                val animationViewMap = AnimationUtils.loadAnimation(holder.itemView.context, R.raw.map)
                holder.addLottieAnimationView.startAnimation(animationViewMap)

                val animationViewTransportation =
                    AnimationUtils.loadAnimation(holder.itemView.context, R.raw.transportation)
                holder.addLottieAnimationView.startAnimation(animationViewTransportation)*/
        }
    }

    override fun getItemCount(): Int {
        return listOfScreenViews.size
    }


    inner class ScreenViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val additionalListOfItemsTextView: TextView =
            itemView.findViewById(R.id.list_items_textName_id)

        //    val addLottieAnimationView: LottieAnimationView =
        //      itemView.findViewById(R.id.horizontal_view_animation_id)
        val shapeableImageView: ShapeableImageView =
            itemView.findViewById(R.id.list_items_image_id)
    }

}