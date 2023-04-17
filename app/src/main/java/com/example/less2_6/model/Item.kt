package com.example.less2_6.model

data class Item(
    var contentDetails: ContentDetails? = null,
    var etag: String? = null,
    var id: String? = null,
    var kind: String? = null,
    var snippet: Snippet? = null
)