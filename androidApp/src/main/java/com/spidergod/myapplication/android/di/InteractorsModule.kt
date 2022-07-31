package com.spidergod.myapplication.android.di


import com.spidergod.myapplication.dataSource.cache.RecipeCache
import com.spidergod.myapplication.dataSource.network.RecipeService
import com.spidergod.myapplication.interactors.recipe_detail.GetRecipe
import com.spidergod.myapplication.interactors.recipe_list.SearchRecipes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun provideSearchRecipes(
        recipeService: RecipeService,
        recipeCache: RecipeCache
    ): SearchRecipes {
        return SearchRecipes(
            recipeService = recipeService,
            recipeCache = recipeCache
        )
    }

    @Singleton
    @Provides
    fun provideGetRecipe(
        recipeCache: RecipeCache
    ): GetRecipe {
        return GetRecipe(recipeCache = recipeCache)
    }

}




