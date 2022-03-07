package com.example.foodproject.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// тут думаю понятно всё, значения все ради теста всял
@Parcelize
data class Recipe(
    var image_url: String?, // нужно указать -
    var publisher: String? , // можно указать -
    var publisher_url: String?, // не сдалось
    var recipe_id: String?, // не сдалось
    var social_rank: Double?, // не сдалось
    var source_url: String?, // нужно указать -
    var title: String? // нужно указать -

) : Parcelable {
    constructor() : this("", "", "", "", 0.0, "", "")
}