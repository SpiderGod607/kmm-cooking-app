package com.spidergod.myapplication.android.presentation.recipe_detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.spidergod.myapplication.android.presentation.recipe_detail.components.RecipeView
import com.spidergod.myapplication.android.presentation.theme.AppTheme
import com.spidergod.myapplication.presentation.recipe_deatils.RecipeDetailEvents
import com.spidergod.myapplication.presentation.recipe_deatils.RecipeDetailState

@OptIn(
    ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class,
    ExperimentalStdlibApi::class
)
@Composable
fun RecipeDetailScreen(
    state: RecipeDetailState,
    onTriggerEvent: (RecipeDetailEvents) -> Unit,
) {
    AppTheme(
        displayProgressBar = state.isLoading,
        dialogQueue = state.queue,
        onRemoveHeadMessageFromQueue = {
            onTriggerEvent(RecipeDetailEvents.OnRemoveHeadMessageFromQueue)
        }
    ) {
        if (state.recipe == null && state.isLoading) {
            // Loading
        } else if (state.recipe == null) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "We were unable to retrieve the details for this recipe.\nTry resetting the app.",
                style = MaterialTheme.typography.body1
            )
        } else {
            RecipeView(recipe = state.recipe!!)
        }
    }
}