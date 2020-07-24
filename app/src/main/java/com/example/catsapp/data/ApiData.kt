package com.example.catsapp.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiData(

    @Json(name = "url") val url: String?,
    @Json(name = "id") val id: String?,
    @Json(name = "width") val width: Int?,
    @Json(name = "height") val height: Int?
)