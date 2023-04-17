package com.example.less2_6.data.remote

import com.example.less2_6.BuildConfig
import com.example.less2_6.model.Playlist
import com.example.less2_6.`object`.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    fun getPlaylist(
        @Query("key") key : String = BuildConfig.API_KEY,
        @Query("part") part : String = Constant.PART,
        @Query("channelId") channelId : String = Constant.CHANNEL_ID
    ): Call<Playlist>

    @GET("playlistItems")
    fun getPlaylistItems(
        @Query("key") key : String = BuildConfig.API_KEY,
        @Query("part") part : String = Constant.PART,
        @Query("playlistId") playlistId : String
    ): Call<Playlist>
}