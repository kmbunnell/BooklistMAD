package com.bonehill.booklistmad.data.repository

import com.bonehill.booklistmad.data.api.BookLookUpService
import com.bonehill.booklistmad.data.api.BookResponse
import com.bonehill.booklistmad.data.datasource.BookDao
import com.bonehill.booklistmad.data.entities.BookEntry
import com.bonehill.booklistmad.data.entities.BookTagCrossRef
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject


@ActivityScoped
class BookRepository @Inject constructor(
    private val api:BookLookUpService,
    private val dao:BookDao
)
{
    suspend fun getBookListByTitle(title: String, startIdx:Int, max:Int): Resource<BookResponse>
    {
        val response= try{
            api.getBooksByTitle(title, startIdx, max)
        }
        catch(e:Exception)
        {
            val exceptionMessage=e.message
            return Resource.Failed("Exception: $exceptionMessage")
        }

        return Resource.Success(response)
    }

    suspend fun InsertBook(book :BookEntry, crossRef: BookTagCrossRef){

        dao.insertBook(book)
        dao.insertBookTagCrossRef(crossRef)
    }

    fun getAllBooksWithTags() = dao.getAllBooksWithTags()
    fun getBooksByTag(tagId: Byte) =  dao.getBooksByTag(tagId)

}