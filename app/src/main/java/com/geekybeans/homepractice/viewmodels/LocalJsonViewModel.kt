package com.geekybeans.homepractice.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geekybeans.homepractice.models.BookEntity
import com.geekybeans.homepractice.models.LocalDataEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LocalJsonViewModel: ViewModel()
{
    private val gson = Gson()
    private val listType = object : TypeToken<LocalDataEntity>() {}.type

    var booksFromJson = MutableLiveData<MutableList<BookEntity>>()

    fun fetchFromJson(json: String)
    {
        val data: LocalDataEntity = gson.fromJson(json, listType)

        viewModelScope.launch {
            withContext(Dispatchers.Main){
                booksFromJson.value = data.data
            }
        }
    }
}