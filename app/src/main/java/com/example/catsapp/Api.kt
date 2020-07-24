package com.example.catsapp

import androidx.lifecycle.Transformations.map
import com.example.catsapp.data.ApiData
import com.example.catsapp.data.Cat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface CatsApi {

    @GET("/v1/images/search?8f314f3c-d0d1-4df6-ac2c-6e8602e12df0&limit=10")
    suspend fun getListOfCats(): Response<List<Cat>>
}

object CatsApiImpl {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://api.thecatapi.com")
        .build()

    private val CatsService = retrofit.create(CatsApi::class.java)

    suspend fun getListOfCats(): List<Cat>? {
        return withContext(Dispatchers.IO) {
            CatsService.getListOfCats().body()?.map { ApiData ->
                Cat(
                    ApiData.id, ApiData.url
                )

            }
        }
    }
}