package com.example.less2_6.model

data class Playlist(
    var etag: String? = null,
    var items: List<Item>? = null,
    var kind: String? = null,
    var nextPageToken: String? = null,
    var pageInfo: PageInfo? = null
)