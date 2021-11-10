package com.bonehill.booklistmad.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bonehill.booklistmad.data.entities.BookEntry
import com.bonehill.booklistmad.data.entities.BookTagCrossRef
import com.bonehill.booklistmad.data.entities.Tag

@Database( entities = [
    BookEntry::class,
    Tag::class,
    BookTagCrossRef::class],
    version = 1)

abstract class BooksTaggedDatabase:RoomDatabase() {
    abstract fun getBookDao():BookDao
}