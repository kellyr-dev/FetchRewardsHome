package com.example.fetchrewards.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavigationComponent(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "List screen") {
        composable("List screen"){
            ListScreen(navController = navController)
        }
        composable("Detail Screen/{id}",
            arguments = listOf(
                navArgument(
                    name = "id"
                ){
                    type = NavType.IntType
                }
            )
        ){ id ->
            id.arguments?.getInt("id")?.let { id1->
                DetailScreen(id = id1)
            }

        }

    }

}









