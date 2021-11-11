package com.bonehill.booklistmad.ui.book_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.bonehill.booklistmad.data.entities.Tag
import androidx.compose.ui.Modifier
import com.bonehill.booklistmad.ui.common.DefaultRadioButton
import com.bonehill.booklistmad.ui.common.TagCheckBox


@Composable
fun TagSection(
    modifier: Modifier=Modifier,
    tags:List<Tag>,
    onCheckChange:(Boolean, Byte)->Unit

)
{
    Column(verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.Start)
    {
        for (tag in tags) {
            TagCheckBox(
                text = tag.tagName,
                tagId = tag.tagId,
                onChecked = onCheckChange
            )
        }
    }

}


