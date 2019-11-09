package com.example.geneLabs.network

import com.example.geneLabs.api.GeneLabsResponse
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://genelab-data.ndc.nasa.gov/genelab/data/search/"

interface ApiService {

    @GET(BASE_URL)
    fun getGeneLabResponse(): Single<GeneLabsResponse>

    companion object {

        fun create(): ApiService {

            val okHttpClient = OkHttpClient.Builder().build()

            //retrofit is created here as we only need it with this service so need to move it in a
            //separate class
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create()
                )
                .addConverterFactory(
                    GsonConverterFactory.create()
                )
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}