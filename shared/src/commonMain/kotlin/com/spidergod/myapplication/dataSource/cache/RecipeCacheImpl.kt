package com.spidergod.myapplication.dataSource.cache

import com.spidergod.myapplication.dataSource.network.RecipeServiceImpl.Companion.RECIPE_PAGINATION_PAGE_SIZE
import com.spidergod.myapplication.domain.model.Recipe
import com.spidergod.myapplication.domain.util.DatetimeUtil

class RecipeCacheImpl(
    private val recipeDatabase: RecipeDatabase,
    private val datetimeUtil: DatetimeUtil
) : RecipeCache {

    private val queries: RecipeDbQueries = recipeDatabase.recipeDbQueries

    override fun insert(recipe: Recipe) {
        queries.insertRecipe(
            id = recipe.id.toLong(),
            title = recipe.title,
            publisher = recipe.publisher,
            featured_image = recipe.featuredImage,
            rating = recipe.rating.toLong(),
            source_url = recipe.sourceUrl,
            ingredients = recipe.ingredients.convertIngredientListToString(),
            date_updated = datetimeUtil.toEpochMilliseconds(recipe.dateUpdated),
            date_added = datetimeUtil.toEpochMilliseconds(recipe.dateAdded)
        )
    }

    override fun insert(recipes: List<Recipe>) {
        recipes.forEach {
            insert(it)
        }
    }

    override fun search(query: String, page: Int): List<Recipe> {
        return queries.searchRecipes(
            query = query,
            pageSize = RECIPE_PAGINATION_PAGE_SIZE.toLong(),
            offset = ((page - 1) * RECIPE_PAGINATION_PAGE_SIZE).toLong()
        ).executeAsList().toRecipeList()
    }

    override fun getAll(page: Int): List<Recipe> {
        return queries.getAllRecipes(
            pageSize = RECIPE_PAGINATION_PAGE_SIZE.toLong(),
            offset = ((page - 1) * RECIPE_PAGINATION_PAGE_SIZE).toLong()
        ).executeAsList().toRecipeList()
    }

    override fun get(recipe: Int): Recipe? {
        return try {
            queries.getRecipeById(id = recipe.toLong()).executeAsOne().toRecipe()
        } catch (e: NullPointerException) {
            null
        }
    }
}