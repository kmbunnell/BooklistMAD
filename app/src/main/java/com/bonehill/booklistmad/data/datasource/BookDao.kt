package com.bonehill.booklistmad.data.datasource

import androidx.room.*
import com.bonehill.booklistmad.data.entities.BookEntry
import com.bonehill.booklistmad.data.entities.BookTagCrossRef
import com.bonehill.booklistmad.data.entities.relations.BookWithTags
import com.bonehill.booklistmad.data.entities.relations.TagWithBooks
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insertBook(book:BookEntry)

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insertBookTagCrossRef(crossRef: BookTagCrossRef)

    @Transaction
    @Query ("SELECT * FROM BookEntry")
    fun getAllBooksWithTags(): Flow<List<BookWithTags>>

    @Transaction
    @Query ("SELECT * FROM Tag where tagId= :tagId")
    fun getBooksByTag(tagId: Byte): Flow<List<TagWithBooks>>
}