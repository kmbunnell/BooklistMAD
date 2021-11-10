package com.bonehill.booklistmad.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookEntry(

    @PrimaryKey(autoGenerate = true)
    val bookEntryId: Short,

    @ColumnInfo(name = "title")
    val title:String,

    @ColumnInfo(name = "cover_url")
    val coverUrl:String?


)
