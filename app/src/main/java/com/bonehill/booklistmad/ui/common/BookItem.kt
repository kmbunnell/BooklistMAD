package com.bonehill.booklistmad.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.bonehill.booklistmad.R
import com.bonehill.booklistmad.data.api.Book
import com.bonehill.booklistmad.data.entities.Tag
import com.bonehill.booklistmad.ui.book_list.BookListScreenViewModel


@Composable
fun BookItem(
    item: Book,
    modifier:Modifier=Modifier
    )
{
    Column()
    {
        Image(
            painter = rememberImagePainter(
                data=item.volumeInfo.imageLinks?.thumbnail?.replace("http:", "https:"),
                builder = {
                    crossfade(true)
                    placeholder(R.drawable.ic_baseline_image_24)
                    error(R.drawable.ic_baseline_error_outline_24)

                }
            ),
            contentDescription = item.volumeInfo.title,
            modifier = Modifier.size(128.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

    }
}