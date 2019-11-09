package com.example.geneLabs

import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.geneLabs.api.GeneLabsResponse
import com.example.geneLabs.ui.DataAdapter
import com.example.geneLabs.utils.SearchInputFilter
import kotlin.random.Random

object BindingAdapter {

    @BindingAdapter("recyclerViewData")
    @JvmStatic
    fun setRecyclerViewData(
        recyclerView: RecyclerView,
        response: List<GeneLabsResponse.Hits.Hit>?
    ) {
        val adapter = recyclerView.adapter as DataAdapter
        adapter.setData(response)
    }


    @BindingAdapter("thumbnailSrc")
    @JvmStatic
    fun setThumbnail(thumbnailView: ImageView, url: String) {
        Glide.with(thumbnailView).load(url).into(thumbnailView)
    }


    @BindingAdapter("firstNameToBeMasked")
    @JvmStatic
    fun setFirstName(textView: TextView, firstName: String) {
        val randomGenerator = Random.Default
        val numberOfHashTimes = (firstName.length * 0.7).toInt()//arbitrary number
        var generatedIndex: Int
        var newUserName = firstName
        for (index in 1..numberOfHashTimes) {
            generatedIndex = randomGenerator.nextInt(firstName.length)
            newUserName =
                newUserName.replaceFirst(firstName.get(generatedIndex).toString(), "*", false)
        }
        textView.setText(newUserName)
    }

    @BindingAdapter("inputFilterAllowed")
    @JvmStatic
    fun setSearchText(searchEditText: EditText, enabled: Boolean) {
        if (enabled) {
            val inputFilter = SearchInputFilter()
            searchEditText.filters = arrayOf(inputFilter)
        } else {
            searchEditText.filters = arrayOf()
        }
    }

}