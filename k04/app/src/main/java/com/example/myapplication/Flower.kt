package com.example.myapplication

import androidx.annotation.DrawableRes


data class Flower(
    val userName: String,
    val description: String,
    @DrawableRes
    val image: Int?,
)
