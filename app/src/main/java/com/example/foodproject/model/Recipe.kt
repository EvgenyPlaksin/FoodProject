package com.example.foodproject.model
// тут думаю понятно всё, значения все ради теста всял
data class Recipe(
    var image_url: String? = "http://forkify-api.herokuapp.com/images/best_pizza_dough_recipe1b20.jpg", // нужно указать -
    var publisher: String? = "101 Cookbooks", // можно указать -
    var publisher_url: String? = null, // не сдалось
    var recipe_id: String? = null, // не сдалось
    var social_rank: Double? = null, // не сдалось
    var source_url: String? = "http://www.101cookbooks.com/archives/001199.html", // нужно указать -
    var title: String? = "Best Pizza Dough Ever" // нужно указать -
)