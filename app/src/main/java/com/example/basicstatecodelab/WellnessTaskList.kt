package com.example.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        /**
         * task.id を使って「このアイテムはどのタスクか」を正しく判断し、
         * 並び替えや削除があっても適切にUIを保つことができる。
         **/
        items(items = list, key = { task -> task.id }) { task ->
            WellnessTaskItem(taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedTask(task, checked)},
                onClose = { onCloseTask(task) })
        }
    }
}
