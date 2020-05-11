package com.geekybeans.homepractice.models

import com.squareup.moshi.Json

data class RemoteDataEntity(
    val id: String,
    //change entity variable name for preferred name instead of the name given in Json
    @Json(name = "img_src") val imgSrcUrl: String,
    val type: String,
    val price: Double)
{

}