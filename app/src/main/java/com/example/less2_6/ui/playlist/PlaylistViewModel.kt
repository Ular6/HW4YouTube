package com.example.less2_6.ui.playlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.less2_6.base.BaseViewModel
import com.example.less2_6.data.remote.RetrofitClient
import com.example.less2_6.model.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel : BaseViewModel() {

    private val apiService = RetrofitClient.create()
    private val playlistLiveData = MutableLiveData<Playlist>()

    val playlist : LiveData<Playlist> = playlistLiveData

    fun getPlaylist() {
        apiService.getPlaylist().enqueue(object : Callback<Playlist> {
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                if (response.isSuccessful) {
                    playlistLiveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                Log.e("ololo", "onFailure: " + t.message)
            }

        })
    }

}