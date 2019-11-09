package com.example.geneLabs.models

import com.example.geneLabs.api.GeneLabsResponse
import com.example.geneLabs.network.ApiService
import io.reactivex.Single

class DataRepository {

    fun getData(): Single<GeneLabsResponse> {
        //seperated in two function to simulate as if the repository decided to get data
        //from API
        return getApiResponse()
    }

    private fun getApiResponse(): Single<GeneLabsResponse> {
        return ApiService.create().getGeneLabResponse()
    }
}