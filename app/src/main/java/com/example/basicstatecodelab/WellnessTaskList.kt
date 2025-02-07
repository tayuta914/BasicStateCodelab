package com.example.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier,
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
                onClose = {onCloseTask(task)}
            )
        }
    }
}
