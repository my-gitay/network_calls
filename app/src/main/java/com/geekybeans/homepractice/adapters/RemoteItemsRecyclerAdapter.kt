package com.geekybeans.homepractice.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geekybeans.homepractice.R
import com.geekybeans.homepractice.models.RemoteDataEntity
import kotlinx.android.synthetic.main.item_remote_second_view_holder.view.*
import kotlinx.android.synthetic.main.item_remote_view_holder.view.*

class RemoteItemsRecyclerAdapter(private val items: MutableList<RemoteDataEntity>): RecyclerView.Adapter<RemoteItemsRecyclerAdapter.ItemBaseViewHolder>()
{
    override fun getItemViewType(position: Int): Int
    {
        /** condition for the view type according to the position **/
        /** alternatively you can send the view type in the entity object **/
        when (position%2)
        {
            0 -> return R.layout.item_remote_view_holder
            else -> return R.layout.item_remote_second_view_holder
        }
    }

    /** inflate the view according to the type **/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBaseViewHolder
    {
        when (viewType)
        {
            R.layout.item_remote_view_holder -> return FirstViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.item_remote_view_holder, parent, false))
            else -> return SecondViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.item_remote_second_view_holder, parent, false))
        }
    }

    override fun getItemCount(): Int { return items.size }

    override fun onBindViewHolder(holder: ItemBaseViewHolder, position: Int)
    {
        holder.bind(items[position])
    }

    /** base class for view holder which have similar functions **/
    abstract inner class ItemBaseViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        abstract fun bind(entity: RemoteDataEntity)
    }

    inner class FirstViewHolder(val view: View): ItemBaseViewHolder(view)
    {
        override fun bind(entity: RemoteDataEntity)
        {
            /** load image using Glide. load as an https url **/
            Glide.with(view.context).load(entity.imgSrcUrl.toUri().buildUpon().scheme("https").build()).into(view.item_imageView)
            view.item_id.text = entity.id
        }
    }

    inner class SecondViewHolder(val view: View): ItemBaseViewHolder(view)
    {
        override fun bind(entity: RemoteDataEntity)
        {
            view.second_item_id.text = entity.id
        }
    }
}