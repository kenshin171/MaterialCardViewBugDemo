package com.kenshin.materialcardviewbug

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MaterialCardViewListAdapter(val useMaterialCard: Boolean)  :
    ListAdapter<MaterialCardObject, MaterialCardViewListAdapter.MaterialCardViewHolder>(PostThreatAppsAdapterDiffUtil())
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialCardViewHolder {

        val v = if(useMaterialCard)
            LayoutInflater.from(parent.context).inflate(R.layout.layout_material_card_item, parent, false)
        else
            LayoutInflater.from(parent.context).inflate(R.layout.layout_card_item, parent, false)

        return MaterialCardViewHolder(v)

    }

    override fun onBindViewHolder(holder: MaterialCardViewHolder, position: Int) {

        val item = getItem(position)
        holder.textView.text = item.text
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return item.hashCode()
    }

    init {
        hasStableIds()
    }

    inner class MaterialCardViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val textView: TextView = v.findViewById(R.id.tvCardText)

    }

}

class PostThreatAppsAdapterDiffUtil: DiffUtil.ItemCallback<MaterialCardObject>() {

    override fun areItemsTheSame(oldItem: MaterialCardObject, newItem: MaterialCardObject): Boolean
            = oldItem == newItem

    override fun areContentsTheSame(oldItem: MaterialCardObject, newItem: MaterialCardObject): Boolean {
        return oldItem.text == newItem.text
    }
}

data class MaterialCardObject(val text: String)