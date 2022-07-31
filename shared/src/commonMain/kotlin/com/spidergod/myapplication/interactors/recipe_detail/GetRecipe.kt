package com.spidergod.myapplication.interactors.recipe_detail


import com.spidergod.myapplication.dataSource.cache.RecipeCache
import com.spidergod.myapplication.domain.model.GenericMessageInfo
import com.spidergod.myapplication.domain.model.Recipe
import com.spidergod.myapplication.domain.model.UIComponentType
import com.spidergod.myapplication.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Retrieve a recipe from the cache given it's unique id.
 */
class GetRecipe(
    private val recipeCache: RecipeCache
) {
    fun execute(
        recipeId: Int,
    ): Flow<DataState<Recipe>> = flow {
        try {
            emit(DataState.loading())

            val recipe = recipeCache.get(recipeId)
            println("yoyoy" + recipe.toString())
            emit(DataState.data(message = null, data = recipe))

        } catch (e: Exception) {
            emit(
                DataState.error<Recipe>(
                    message = GenericMessageInfo.Builder()
                        .id("SearchRecipes.Error")
                        .title("Error")
                        .uiComponentType(UIComponentType.Dialog)
                        .description(e.message ?: "")
                )
            )
        }
    }

}