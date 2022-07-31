package com.spidergod.myapplication.presentation.recipe_deatils

import com.spidergod.myapplication.domain.model.GenericMessageInfo
import com.spidergod.myapplication.domain.model.Recipe
import com.spidergod.myapplication.domain.util.Queue


data class RecipeDetailState(
    val isLoading: Boolean = false,
    val recipe: Recipe? = null,
    val queue: Queue<GenericMessageInfo> = Queue(mutableListOf())
)


