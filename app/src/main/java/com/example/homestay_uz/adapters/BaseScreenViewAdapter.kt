package com.example.homestay_uz.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homestay_uz.R
import com.example.homestay_uz.adapters.subAdapter.MainAddsAdapters
import com.example.homestay_uz.adapters.subAdapter.ScreenViewAdapters
import com.example.homestay_uz.models.BaseScreenViews
import com.example.homestay_uz.models.MainAdds
import com.example.homestay_uz.models.ScreenView
import com.google.android.material.imageview.ShapeableImageView
import java.util.LinkedList

class BaseScreenViewAdapter(
    private var context: Context,
    private var listOfBaseScreenView: ArrayList<BaseScreenViews>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private var SCREEN_ADDS_ITEM = 0
        private var SCREEN_HEADER_VIEW_ITEM = 1
        private var SCREEN_FOOTER_VIEW_ITEM = 2
    }

    override fun getItemViewType(position: Int): Int {
        val baseScreenViews = listOfBaseScreenView[position]
        return if (isHeader(position)) SCREEN_ADDS_ITEM else if (baseScreenViews.screenView!!.size > 0) SCREEN_HEADER_VIEW_ITEM else SCREEN_FOOTER_VIEW_ITEM

       /* if (isHeader(position)) {
            return SCREEN_ADDS_ITEM

        } else if (baseScreenViews.screenView!!.size > 0) {
            return SCREEN_HEADER_VIEW_ITEM
        }
        return SCREEN_FOOTER_VIEW_ITEM*/
    }

    private fun isHeader(position: Int): Boolean {
        return position == 0
    }


    /*  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
          if (viewType == SCREEN_ADDS_ITEM) {
              val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_main_adds, parent, false)
              return ScreenAddsViewHolder(view)
          } else if (viewType == SCREEN_HEADER_VIEW_ITEM) {
              val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_screen_adds, parent, false)
              return ScreenHeaderViewHolder(view)
          }
          val view = LayoutInflater.from(parent.context).inflate(R.layout.adds_view_inmain_screen, parent, false)
          return ScreenFooterViewHolder(view)
      }   */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == SCREEN_ADDS_ITEM) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.screen_adds_item, parent, false)
            return ScreenAddsViewHolder(view)
        } else if (viewType == SCREEN_HEADER_VIEW_ITEM) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_screen_adds, parent, false)
            return ScreenHeaderViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adds_view_inmain_screen, parent, false)
        return ScreenFooterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val baseScreenViews = listOfBaseScreenView[position]

        if (holder is ScreenAddsViewHolder) {
            //val recyclerView = holder.recyclerViewAdds
            // baseScreenViews.mainAdds?.let { refreshMainAddsAdapters(it,recyclerView) }
        }

        if (holder is ScreenHeaderViewHolder) {
            val recyclerView = holder.recyclerViewHeader
            baseScreenViews.screenView?.let { refreshScreenViewAdapters(it, recyclerView) }
        }
        if (holder is ScreenFooterViewHolder) {
            holder.homeOfScreenInImageView.setImageResource(baseScreenViews.screenAddsView!!.addsMainImageView)
            holder.homeOfScreenInTitle.text = baseScreenViews.screenAddsView!!.homeOfScreenInTitle
            holder.homeOfScreenInPrice.text = baseScreenViews.screenAddsView!!.homeOfScreenInPrice
            holder.homeOfScreenInComment.text =
                baseScreenViews.screenAddsView!!.homeOfScreenInComment
        }
    }

    private fun refreshScreenViewAdapters(
        screenView: ArrayList<ScreenView>,
        recyclerView: RecyclerView
    ) {
        val adapter = ScreenViewAdapters(context, screenView)
        recyclerView.adapter = adapter
    }

    private fun refreshMainAddsAdapters(
        mainAdds: LinkedList<MainAdds>,
        recyclerView: RecyclerView
    ) {
        val adapter = MainAddsAdapters(context, mainAdds)
        recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return listOfBaseScreenView.size
    }

    inner class ScreenAddsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /* var recyclerViewAdds: RecyclerView
         var context: Context? = null

         init {
             recyclerViewAdds = itemView.findViewById(R.id.recyclerview_main_adds)
             recyclerViewAdds.layoutManager = GridLayoutManager(context, 1)
         }*/
    }

    inner class ScreenHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recyclerViewHeader: RecyclerView
        var context: Context? = null

        init {
            recyclerViewHeader = itemView.findViewById(R.id.recyclerview_screen_adds)
            recyclerViewHeader.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    inner class ScreenFooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val homeOfScreenInImageView: ShapeableImageView =
            itemView.findViewById(R.id.adds_main_shapeableImageView)
        val homeOfScreenInTitle: TextView = itemView.findViewById(R.id.home_screen_title_textView)
        val homeOfScreenInPrice: TextView = itemView.findViewById(R.id.home_screen_price_textView)
        val homeOfScreenInComment: TextView =
            itemView.findViewById(R.id.home_screen_comment_textView)
    }
}