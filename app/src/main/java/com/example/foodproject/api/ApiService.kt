package com.example.foodproject.api

import com.example.foodproject.model.requestdata
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
// запрос ретрофита с параметром, который указан через @Query
interface ApiService {

    @GET("search?")
    suspend fun getRecipe(
        @Query("q") q: String?
    ): Response<requestdata>
}