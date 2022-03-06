package com.example.foodproject.model
// класс, в который помещается джейсон объект
data class requestdata(
    var count: Int = 1,
    var recipes: List<Recipe>? = null
)