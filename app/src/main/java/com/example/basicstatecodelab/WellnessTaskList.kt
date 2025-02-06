package com.example.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = remember { getWellnessTasks() },
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { task ->
            var checkedState by rememberSaveable { mutableStateOf(false) }
            WellnessTaskItem(
                taskName = task.label,
                checked = checkedState,
                onCheckedChange = { newValue -> checkedState = newValue },
                onClose = {} // 今は空のラムダ
            )
        }
    }
}

fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
