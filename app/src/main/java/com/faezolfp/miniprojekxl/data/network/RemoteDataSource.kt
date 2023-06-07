package com.faezolfp.miniprojekxl.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RemoteDataSource private constructor(private val apiService: ApiService) {

    fun getData(): LiveData<List<ResponseApiItem>> {
        val resultData = MutableLiveData<List<ResponseApiItem>>()

        //get data terbaru from API
        val client = apiService.getSchedule("2020-05-29", "US")
//        client.enqueue(object : Callback<ResponseApi> {
//            override fun onResponse(call: Call<ResponseApi>, response: Response<ResponseApi>) {
//                val responseBody = response.body()
//                if (response.isSuccessful && responseBody != null) {
//                    resultData.value = response.body()!!.responseApi as List<ResponseApiItem>?
//                } else {
//                    Log.d(TAG, "MESSAGE: ${response.message()}")
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseApi>, t: Throwable) {
//                Log.d(TAG, "MESSAGE1: ${t.message}")
//            }
//
//        })

        client.enqueue(object : Callback<List<ResponseApiItem>>{
            override fun onResponse(
                call: Call<List<ResponseApiItem>>,
                response: Response<List<ResponseApiItem>>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    resultData.value = response.body()
                } else {
                    Log.d(TAG, "MESSAGE: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<ResponseApiItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return resultData
    }


    companion object {
        const val TAG = "RemoteDataSource"

        @Volatile
        private var INSTANCE: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource = INSTANCE ?: synchronized(this) {
            INSTANCE ?: RemoteDataSource(service)
        }
    }

}