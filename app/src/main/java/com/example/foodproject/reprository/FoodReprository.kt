package com.example.foodproject.reprository

import com.example.foodproject.api.ApiService
import com.example.foodproject.utils.ConstandVar
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FoodReprository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getFood() = apiService.getRecipe(ConstandVar.food)
}
