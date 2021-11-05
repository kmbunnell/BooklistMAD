package com.bonehill.booklistmad.data.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.bonehill.booklistmad.data.entities.BookEntry
import com.bonehill.booklistmad.data.entities.Tag

data class BookWithTags(
    @Embedded val bookEntry:BookEntry,
    @Relation(
        parentColumn = "bookEntryId",
        entityColumn ="tagId",
        associateBy = Junction(BookTagCrossRef::class)
    )
    val tags:List<Tag>
)
