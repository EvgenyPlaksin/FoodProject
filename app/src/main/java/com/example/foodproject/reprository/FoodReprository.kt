package com.example.foodproject.reprository

import com.example.foodproject.api.ApiService
import com.example.foodproject.utils.ConstandVar
import javax.inject.Inject
// тут юзается хилт и создаётся корутинская функция, которая что-то там делает, забей кароче
class FoodReprository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getFood() = apiService.getRecipe(ConstandVar.food)
}
