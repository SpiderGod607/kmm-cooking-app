package com.spidergod.myapplication.presentation.recipe_list

import com.spidergod.myapplication.domain.model.GenericMessageInfo
import com.spidergod.myapplication.domain.model.Recipe
import com.spidergod.myapplication.domain.util.Queue

data class RecipeListState(
    val isLoading: Boolean = false,
    val page: Int = 1,
    val query: String = "",
    val selectedCategory: FoodCategory? = null,
    val recipes: List<Recipe> = listOf(),
    val queue:Queue<GenericMessageInfo> = Queue(mutableListOf())
)
