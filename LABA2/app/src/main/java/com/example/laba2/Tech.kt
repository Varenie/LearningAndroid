package com.example.laba2

import com.google.gson.annotations.SerializedName

data class Tech(
    @SerializedName("flags") val flags: String,
    @SerializedName("graphic") val graphic: String,
    @SerializedName("graphic_alt") val graphic_alt: String,
    @SerializedName("helptext") val helptext: String,
    @SerializedName("name") val name: String,
    @SerializedName("req1") val req1: String,
    @SerializedName("req2") val req2: String
    )