package com.geekybeans.homepractice

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val URL = "https://android-kotlin-fun-mars-server.appspot.com"
private const val PATH = "realestate"

