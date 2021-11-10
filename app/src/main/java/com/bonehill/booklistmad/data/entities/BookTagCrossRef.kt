package com.bonehill.booklistmad.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["bookEntryId", "tagId"])
data class BookTagCrossRef(

    @ColumnInfo(name = "bookEntryId")
    val bookEntryId:Short,

    @ColumnInfo(name = "tagId")
    val tagId:Byte
)
