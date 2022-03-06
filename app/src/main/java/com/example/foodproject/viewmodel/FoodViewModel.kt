package com.example.foodproject.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodproject.model.requestdata
import com.example.foodproject.reprository.FoodReprository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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


    init {
        getRecipe()
    }
// я сломал MVVM паттерн, но иного выхода не было
    // тут запрос делается, в корутине
    fun getRecipe() = viewModelScope.launch {
        repository.getFood().let { response ->

            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("tag", "getWeather Error: ${response.code()}")
            }
        }
    }


}
