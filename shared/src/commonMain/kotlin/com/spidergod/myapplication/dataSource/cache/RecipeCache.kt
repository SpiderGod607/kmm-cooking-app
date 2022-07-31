package com.spidergod.myapplication.dataSource.cache

import com.spidergod.myapplication.domain.model.Recipe

interface RecipeCache {

    fun insert(recipe: Recipe)

    fun insert(recipes: List<Recipe>)

    fun search(query: String, page: Int): List<Recipe>

    fun getAll(page: Int): List<Recipe>

    fun get(recipe: Int): Recipe?
}