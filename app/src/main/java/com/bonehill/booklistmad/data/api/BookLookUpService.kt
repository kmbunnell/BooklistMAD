package com.bonehill.booklistmad.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookLookUpService {
    @GET("books/v1/volumes?printType=BOOKS&orderBy=newest&projection=lite")
    suspend fun getBooksByTitle(
        @Query("q") title: String,
        @Query("startIndex")start:Int,
        @Query("maxResults") maxResults:Int): BookResponse

}