package com.spidergod.myapplication.dataSource.network

import com.spidergod.myapplication.domain.model.Recipe

interface RecipeService {

    suspend fun search(
        page: Int,
        query: String,
    ): List<Recipe>

    suspend fun get(
        id: Int
    ): Recipe

}