package com.spidergod.myapplication.android.presentation.composable

import androidx.compose.runtime.Composable
import com.spidergod.myapplication.domain.model.GenericMessageInfo
import com.spidergod.myapplication.domain.util.Queue

@Composable
fun ProcessDialogQueue(
    dialogQueue: Queue<GenericMessageInfo>?,
    onRemoveHeadMessageFromQueue: () -> Unit
) {
    dialogQueue?.peek()?.let { dialogInfo ->
        GenericDialog(
            title = dialogInfo.title,
            description = dialogInfo.description,
            onRemoveHeadFromQueue = onRemoveHeadMessageFromQueue,
            onDismiss = dialogInfo.onDismiss,
            positiveAction = dialogInfo.positiveAction,
            negativeAction = dialogInfo.negativeAction
        )
    }
}