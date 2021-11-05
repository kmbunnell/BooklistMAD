package com.bonehill.booklistmad.data

import androidx.room.*
import com.bonehill.booklistmad.data.entities.BookEntry
import com.bonehill.booklistmad.data.entities.relations.BookTagCrossRef
import com.bonehill.booklistmad.data.entities.relations.BookWithTags
import com.bonehill.booklistmad.data.entities.relations.TagWithBooks

@Dao
interface BookDao {

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insertBook(book:BookEntry)

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insertBookTagCrossRef(crossRef: BookTagCrossRef)

    @Transaction
    @Query ("SELECT * FROM BookEntry")
    suspend fun getAllBooksWithTags(): List<BookWithTags>

    @Transaction
    @Query ("SELECT * FROM Tag where tagId= :tagId")
    suspend fun getBooksByTag(tagId: Byte): List<TagWithBooks>
}