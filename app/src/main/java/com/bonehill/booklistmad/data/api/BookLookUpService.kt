package com.bonehill.booklistmad.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookLookUpService {
    @GET("books/v1/volumes?printType=BOOKS&orderBy=newest&maxResults=20&projection=lite")
    suspend fun getBooksByTitle(
        @Query("q") title: String,
        @Query("startIndex")start:Int): BookResponse

}