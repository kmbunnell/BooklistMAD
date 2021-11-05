package com.bonehill.booklistmad.data.entities.relations

import androidx.room.Entity

@Entity(primaryKeys = ["bookEntryId", "tagId"])
data class BookTagCrossRef(
    val bookEntryId:Short,
    val tadIg:Byte,
)
