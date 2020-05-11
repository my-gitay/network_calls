package com.geekybeans.homepractice

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val URL = "https://android-kotlin-fun-mars-server.appspot.com"
private const val PATH = "realestate"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).build()

interface ServiceApi
{
    @GET(PATH)
    suspend fun getData()


}