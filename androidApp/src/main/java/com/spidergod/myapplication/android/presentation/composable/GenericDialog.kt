package com.spidergod.myapplication.android.presentation.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.spidergod.myapplication.domain.model.NegativeAction
import com.spidergod.myapplication.domain.model.PositiveAction

@Composable
fun GenericDialog(
    modifier: Modifier = Modifier,
    onDismiss: (() -> Unit)? = null,
    title: String,
    description: String? = null,
    positiveAction: PositiveAction?,
    negativeAction: NegativeAction?,
    onRemoveHeadFromQueue: () -> Unit,
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onDismiss?.invoke()
            onRemoveHeadFromQueue()
        },
        title = {
            Text(text = title)
        },
        text = {
            if (description != null) {
                Text(text = description)
            }
        },
        buttons = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                if (negativeAction != null) {
                    Button(
                        onClick = {
                            onRemoveHeadFromQueue()
                            negativeAction.onNegativeAction()
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onError)
                    ) {
                        Text(
                            text = negativeAction.negativeBtnTxt,
                            style = MaterialTheme.typography.button
                        )
                    }
                }
                if (positiveAction != null) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = {
                        onRemoveHeadFromQueue()
                        positiveAction.onPositiveAction()
                    }
                    ) {
                        Text(
                            text = positiveAction.positiveBtnTxt,
                            style = MaterialTheme.typography.button
                        )
                    }
                }

            }
        }
    )
}