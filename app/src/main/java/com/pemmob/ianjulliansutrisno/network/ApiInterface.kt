package com.pemmob.ianjulliansutrisno.network

import com.pemmob.ianjulliansutrisno.data.model.Category
import com.pemmob.ianjulliansutrisno.data.model.Product
import com.pemmob.ianjulliansutrisno.util.JualanConstants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface ApiInterface {
    @GET(value = "data/categories.json")
    suspend fun getCategories(): List<Category>

    @GET(value = "data/products.json")
    suspend fun getProducts(): List<Product>
}

object ApiClient {
    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    val instance: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}
