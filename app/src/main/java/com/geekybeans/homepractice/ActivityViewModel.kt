package com.geekybeans.homepractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ActivityViewModel : ViewModel()
{
    var stringResponse = MutableLiveData<DataEntity>()
    var listFromResponse = MutableLiveData<MutableList<DataEntity>>()

    /** call retrofit to fetch data and put it in a list **/
    fun getDataFromService()
    {
        var listResult: List<DataEntity> = listOf()

        /** use view model build-in scope to use coroutine **/
        viewModelScope.launch {
            withContext(Dispatchers.Main) { listResult = DataApi.retrofitService.getData() }
            withContext(Dispatchers.Main) {
                /** update live data object **/
                try {
                    stringResponse.value = listResult[0]
                    listFromResponse.value = listResult.toMutableList()
                } catch (e: Exception) { e.printStackTrace() }
            }
        }

//        DataApi.retrofitService.getData().enqueue(object: Callback<List<DataEntity>>
//        {
//                override fun onFailure(call: Call<List<DataEntity>>, t: Throwable) {
//                    Log.i("test", t.message.toString())
//                }
//
//                override fun onResponse(call: Call<List<DataEntity>>, response: Response<List<DataEntity>>) {
//                    Log.i("test", response.body().toString())
//                    stringResponse.value = response.body()?.size.toString()
//                }
//        })
    }
}