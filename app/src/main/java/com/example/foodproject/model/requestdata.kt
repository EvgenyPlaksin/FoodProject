package com.example.foodproject.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// класс, в который помещается джейсон объект
@Parcelize
data class requestdata(
    var count: Int,
    var recipes: List<Recipe>?
): Parcelable {
    constructor() : this(0, mutableListOf())
}