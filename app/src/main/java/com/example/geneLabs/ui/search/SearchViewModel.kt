package com.example.geneLabs.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geneLabs.api.GeneLabsResponse

class SearchViewModel : ViewModel() {
    val searchKey = MutableLiveData<String>()
    val searchResults = MutableLiveData<List<GeneLabsResponse.Hits.Hit>>()
}