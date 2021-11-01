package com.bonehill.booklistmad.data.api

data class BookResponse(
    val kind: String,
    val totalItems: Int,
    val items: List<Book>
)

data class Book (
    val id:String,
    val volumeInfo: VolumeInfo
)

data class VolumeInfo (
    val title:String,
    val authors: List<String>?,
    val imageLinks:ImageLinks?
)

data class ImageLinks(
    val smallThumbnail:String,
    val thumbnail:String
)
