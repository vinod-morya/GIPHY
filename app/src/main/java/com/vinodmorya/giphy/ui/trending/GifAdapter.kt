package com.vinodmorya.giphy.ui.trending

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.vinodmorya.giphy.R
import kotlinx.android.synthetic.main.item_gif.view.*


class GifAdapter(val items: ArrayList<GiphyModelGif>, val context: Context, private val listener: FavoriteInterface) : RecyclerView.Adapter<ViewHolder>() {

    private lateinit var favoriteListener: FavoriteInterface
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        favoriteListener = listener
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_gif, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var url = ""
        val item = items[position]
        url = if (item.images?.fixedWidth?.fixedUrl != null) {
            items[position].images?.fixedWidth?.fixedUrl!!
        } else {
            items[position].fixedWidthURL!!
        }
        val controller = Fresco.newDraweeControllerBuilder()
                .setUri(url)
                .setAutoPlayAnimations(true)
                .build()
        val frescoHierarchy = GenericDraweeHierarchyBuilder(context.resources).setPlaceholderImage(R.drawable.placeholder)
                .setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).build()
        holder.ivGif.controller = controller
        holder.ivGif.hierarchy = frescoHierarchy
        holder.sbFavorite.tag = items[position]

        holder.sbFavorite.isChecked = item.checked
        holder.sbFavorite.setOnCheckStateChangeListener { view, checked ->
            val gif = view?.tag as GiphyModelGif
            if (checked) {
                gif.checked = true
                favoriteListener.addToFavorite(gif)
            } else {
                gif.checked = false
                favoriteListener.removeFromFavorite(gif)

            }
        }
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivGif = view.iv_gif!!
    val sbFavorite = view.sb_favorite!!
}

interface FavoriteInterface {
    fun addToFavorite(gif: GiphyModelGif)
    fun removeFromFavorite(gif: GiphyModelGif)
}