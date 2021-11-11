package com.bonehill.booklistmad.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.selects.whileSelect

@Composable
fun TagCheckBox(
    text:String,
    tagId:Byte,
    onChecked:(Boolean, Byte)->Unit,
    modifier: Modifier = Modifier
){
    val checkedState = remember { mutableStateOf(true) }

    Row(modifier=modifier,
        verticalAlignment= Alignment.CenterVertically)
    {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange ={
                checkedState.value = it
                onChecked( checkedState.value , tagId)
            }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(text=text )

    }

}