package com.spidergod.myapplication.android.presentation.recipe_list

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import com.spidergod.myapplication.android.presentation.recipe_list.components.RecipeList
import com.spidergod.myapplication.android.presentation.recipe_list.components.SearchAppBar
import com.spidergod.myapplication.android.presentation.theme.AppTheme
import com.spidergod.myapplication.presentation.recipe_list.FoodCategoryUtil
import com.spidergod.myapplication.presentation.recipe_list.RecipeListEvents
import com.spidergod.myapplication.presentation.recipe_list.RecipeListState

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun RecipeListScreen(
    state: RecipeListState,
    onSelectRecipe: (Int) -> Unit,
    onTriggerEvent: (RecipeListEvents) -> Unit,
) {
    AppTheme(
        displayProgressBar = state.isLoading,
        dialogQueue = state.queue,
        onRemoveHeadMessageFromQueue = {
            onTriggerEvent(RecipeListEvents.OnRemoveHeadMessageFromQueue)
        }
    ) {
        val foodCategories = remember { FoodCategoryUtil().getAllFoodCategories() }
        Scaffold(
            topBar = {
                SearchAppBar(
                    query = state.query,
                    categories = foodCategories,
                    onQueryChanged = {
                        onTriggerEvent(RecipeListEvents.OnUpdateQuery(it))
                    },
                    onExecuteSearch = {
                        onTriggerEvent(RecipeListEvents.NewSearch)
                    },
                    onSelectedCategoryChanged = {
                        onTriggerEvent(RecipeListEvents.OnSelectCategory(it))
                    },
                    selectedCategory = state.selectedCategory
                )
            }
        ) {
            RecipeList(
                loading = state.isLoading,
                recipes = state.recipes,
                onClickRecipeListItem = onSelectRecipe,
                onTriggerNextPage = {
                    onTriggerEvent(RecipeListEvents.NextPage)
                },
                page = state.page,
            )

        }
    }
}