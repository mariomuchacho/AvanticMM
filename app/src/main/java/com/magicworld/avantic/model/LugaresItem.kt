package com.magicworld.avantic.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LugaresItem(
    @SerializedName("descriptioncard")
    val descriptioncard: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rate")
    val rate: Float,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double,
    @SerializedName("zoom")
    val zoom: Float
):Serializable