package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name") val name: String,
    @SerializedName("capital") val capital: String
) {}