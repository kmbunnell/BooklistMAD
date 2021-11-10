package com.bonehill.booklistmad.data.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.bonehill.booklistmad.data.entities.BookEntry
import com.bonehill.booklistmad.data.entities.BookTagCrossRef
import com.bonehill.booklistmad.data.entities.Tag

data class TagWithBooks (
    @Embedded val tag: Tag,
    @Relation(
        parentColumn = "tagId",
        entityColumn ="bookEntryId",
        associateBy = Junction(BookTagCrossRef::class)
    )
    val booksByTag:List<BookEntry>
)