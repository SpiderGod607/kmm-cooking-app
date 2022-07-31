package com.spidergod.myapplication.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.spidergod.myapplication.android.presentation.recipe_detail.RecipeDetailScreen
import com.spidergod.myapplication.android.presentation.recipe_detail.RecipeDetailViewModel
import com.spidergod.myapplication.android.presentation.recipe_list.RecipeListScreen
import com.spidergod.myapplication.android.presentation.recipe_list.RecipeListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RecipeList.route) {
        composable(route = Screen.RecipeList.route) { navBackStackEntry ->
            val viewModel: RecipeListViewModel = hiltViewModel()
            RecipeListScreen(
                state = viewModel.state.value,
                onSelectRecipe = { recipeId ->
                    navController.navigate(Screen.RecipeDetail.route + "/$recipeId")
                },
                onTriggerEvent = viewModel::onTriggerEvent
            )
        }
        composable(
            route = Screen.RecipeDetail.route + "/{recipeId}",
            arguments = listOf(navArgument("recipeId") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            val viewModel: RecipeDetailViewModel = hiltViewModel()
            RecipeDetailScreen(
                state = viewModel.state.value,
                onTriggerEvent = viewModel::onTriggerEvent
            )
        }
    }
}
