package com.example.foodproject.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodproject.api.ApiService
import com.example.foodproject.di.AppModule
import com.example.foodproject.model.Recipe
import com.example.foodproject.model.requestdata
import com.example.foodproject.reprository.FoodReprository
import com.example.foodproject.utils.ConstandVar
import com.example.foodproject.utils.ConstandVar.BASE_URL
import com.example.foodproject.utils.ConstandVar.food
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
// вьюмодель в которой юзается хилт, лайвдата и корутины
@HiltViewModel
class FoodViewModel
@Inject
constructor(private val repository: FoodReprository) : ViewModel() {
// забей на это, тут всё ок
    private val _response = MutableLiveData<requestdata>()
    val foodResponse: LiveData<requestdata>
        get() = _response

// я сломал MVVM паттерн, но иного выхода не было
    // тут запрос делается

 fun getRecipe(callback: (List<Recipe>) -> Unit) {

        val apiService = AppModule.provideRetrofitInstance(ConstandVar.BASE_URL)
        apiService.getRecipe(food).enqueue(object : Callback<requestdata> {
            override fun onFailure(call: Call<requestdata>, t: Throwable) {

            }

            override fun onResponse(call: Call<requestdata>, response: Response<requestdata>) {
                return response.body()!!.recipes?.let { callback(it) }!!
            }

        })
    }
}

