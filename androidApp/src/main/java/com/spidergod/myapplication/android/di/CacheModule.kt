package com.spidergod.myapplication.android.di

import com.spidergod.myapplication.android.BaseApplication
import com.spidergod.myapplication.dataSource.cache.*
import com.spidergod.myapplication.domain.util.DatetimeUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun providesRecipeDatabase(context: BaseApplication): RecipeDatabase {
        return RecipeDatabaseFactory(driverFactory = DriverFactory(context = context)).createDataBase()
    }

    @Singleton
    @Provides
    fun provideCache(
        recipeDatabase: RecipeDatabase
    ): RecipeCache {
        return RecipeCacheImpl(
            recipeDatabase = recipeDatabase,
            datetimeUtil = DatetimeUtil()
        )
    }

}