package com.spidergod.myapplication.presentation.recipe_deatils

sealed class RecipeDetailEvents {

    data class GetRecipe(val recipeId: Int): RecipeDetailEvents()
   object OnRemoveHeadMessageFromQueue: RecipeDetailEvents()

}