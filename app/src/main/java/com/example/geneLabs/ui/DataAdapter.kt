package com.example.geneLabs.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.geneLabs.api.GeneLabsResponse
import com.example.geneLabs.databinding.ResponseItemBinding

class DataAdapter() : RecyclerView.Adapter<DataAdapter.ItemViewHolder>() {
    var dataList: List<GeneLabsResponse.Hits.Hit>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val responseItemBinding =
            ResponseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(responseItemBinding)
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        dataList?.let {
            holder.bind(dataList!![position].source)
        }
    }

    fun setData(dataList: List<GeneLabsResponse.Hits.Hit>?) {
        this.dataList = dataList
        notifyDataSetChanged()
    }

    fun getDataItemAtPosition(itemPosition: Int): GeneLabsResponse.Hits.Hit? {
        return dataList?.get(itemPosition)
    }

    inner class ItemViewHolder(binding: ResponseItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val itemBinding: ResponseItemBinding = binding

        fun bind(dataItem: GeneLabsResponse.Hits.Hit.Source) {
            itemBinding.baseImageUrl = "https://genelab-data.ndc.nasa.gov/"
            itemBinding.responseItem = dataItem
            itemBinding.executePendingBindings()
        }

    }
}