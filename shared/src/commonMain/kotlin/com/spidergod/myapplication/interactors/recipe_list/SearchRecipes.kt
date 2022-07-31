package com.spidergod.myapplication.interactors.recipe_list

import com.spidergod.myapplication.dataSource.cache.RecipeCache
import com.spidergod.myapplication.dataSource.network.RecipeService
import com.spidergod.myapplication.domain.model.GenericMessageInfo
import com.spidergod.myapplication.domain.model.Recipe
import com.spidergod.myapplication.domain.model.UIComponentType
import com.spidergod.myapplication.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipes(
    private val recipeService: RecipeService,
    private val recipeCache: RecipeCache
) {
    fun execute(
        page: Int,
        query: String,
    ): Flow<DataState<List<Recipe>>> = flow {
        emit(DataState.loading())

        try {
            if (query == "error") {
                throw Exception("Forcing an error... Search FAILED!")
            }
            val recipes = recipeService.search(
                page = page,
                query = query,
            )
            recipeCache.insert(recipes)
            val cacheResult = if (query.isBlank()) {
                recipeCache.getAll(page = page)
            } else {
                recipeCache.search(query = query, page = page)
            }
            emit(DataState.data(data = cacheResult))
        } catch (e: Exception) {
            emit(
                DataState.error<List<Recipe>>(
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









