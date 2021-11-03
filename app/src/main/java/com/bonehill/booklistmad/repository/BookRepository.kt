package com.bonehill.booklistmad.repository

import com.bonehill.booklistmad.data.api.BookLookUpService
import com.bonehill.booklistmad.data.api.BookResponse
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject


@ActivityScoped
class BookRepository @Inject constructor(
    private val api:BookLookUpService
)
{
    suspend fun getBookListByTitle(title: String, startIdx:Int, max:Int): Resource<BookResponse>
    {
        val response= try{
            api.getBooksByTitle(title, startIdx, max)
        }
        catch(e:Exception)
        {
            var exceptionMessage=e.message
            return Resource.Failed("Exception: $exceptionMessage")
        }

        return Resource.Success(response)
    }

}