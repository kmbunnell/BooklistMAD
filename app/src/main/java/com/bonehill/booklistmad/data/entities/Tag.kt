package com.bonehill.booklistmad.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tag(

    @PrimaryKey(autoGenerate = true)
    val tagId: Byte,

    @ColumnInfo(name = "tagName")
    val tagName:String

    )

