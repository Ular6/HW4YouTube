package com.example.less2_6.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.less2_6.base.BaseViewModel
import com.example.less2_6.data.remote.ApiService
import com.example.less2_6.data.remote.RetrofitClient
import com.example.less2_6.model.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : BaseViewModel() {

    private val apiService : ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlaylistItems(playlistId : String) : LiveData<Playlist> {
        val data = MutableLiveData<Playlist>()

        apiService.getPlaylistItems(playlistId = playlistId).enqueue(object : Callback<Playlist> {
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                Log.e("TAG", "onFailure: " + t.message)
            }

        })
        return data
    }
}