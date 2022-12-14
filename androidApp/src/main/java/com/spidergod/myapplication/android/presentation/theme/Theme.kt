package com.spidergod.myapplication.android.presentation.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.spidergod.myapplication.android.presentation.composable.CircularIndeterminateProgressBar
import com.spidergod.myapplication.android.presentation.composable.ProcessDialogQueue
import com.spidergod.myapplication.domain.model.GenericMessageInfo
import com.spidergod.myapplication.domain.util.Queue

private val LightThemeColors = lightColors(
    primary = Blue600,
    primaryVariant = Blue400,
    onPrimary = Black2,
    secondary = Color.White,
    secondaryVariant = Teal300,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = Grey1,
    onBackground = Color.Black,
    surface = Color.White,
)

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun AppTheme(
    displayProgressBar: Boolean,
    dialogQueue: Queue<GenericMessageInfo> = Queue<GenericMessageInfo>(mutableListOf()),
    onRemoveHeadMessageFromQueue: () -> Unit,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = LightThemeColors,
        typography = QuickSandTypography,
        shapes = AppShapes
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Grey1)
        ) {
            ProcessDialogQueue(
                dialogQueue = dialogQueue,
                onRemoveHeadMessageFromQueue = onRemoveHeadMessageFromQueue
            )
            content()
            if (displayProgressBar) {
                CircularIndeterminateProgressBar(
                    isDisplayed = displayProgressBar,
                    verticalBias = 0.3f
                )
            }
        }
    }
}