package com.geekybeans.homepractice

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/** create static URL const **/
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
/** create Retrofit object **/
/** Using Retrofit library to make network calls **/
/** Retrofit needs the URL go get the data from, and a Converter factory **/
/** The Converter tells Retrofit what to do with the data it gets. it can be Gson, Moshi and others **/
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/** interface for fetching data from a web server **/
/** use GET (retrofit) annotation to specify the path you want to get **/
/** suspend is for using coroutines **/
interface ApiService {
    /** the value in GET is the name of the json array **/
    @GET("realestate")
    suspend fun getData(): List<DataEntity>
}

/** SINGLETON **/
/** retrofit.create creates the retrofit service with the interface provided **/
/** this call is expensive and an app usually needs only one retrofit service instance **/
/** that's why we expose it to the rest of the app using a public object "DataApi" **/
/** Now, every time we call DataApi.retrofitService, it will get a singleton Retrofit object that implements "ApiService" **/
object DataApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
