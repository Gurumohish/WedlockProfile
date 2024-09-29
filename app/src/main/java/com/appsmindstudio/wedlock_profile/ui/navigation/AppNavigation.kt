package com.appsmindstudio.wedlock_profile.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.appsmindstudio.wedlock_profile.ui.screens.nav_screens.GestureScreen
import com.appsmindstudio.wedlock_profile.ui.screens.nav_screens.HomeScreen
import com.appsmindstudio.wedlock_profile.ui.screens.nav_screens.ProfileDetailsScreen

enum class Destinations {
    HOME_SCREEN, GESTURE_SCREEN, PROFILE_DETAILS_SCREEN, HOME_GRAPH
}

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(navController, startDestination = Destinations.HOME_GRAPH.name) {

        home(navController)

    }
}

fun NavGraphBuilder.home(navController: NavHostController) {

    navigation(
        startDestination = Destinations.HOME_SCREEN.name,
        route = Destinations.HOME_GRAPH.name
    ) {

        composable(Destinations.HOME_SCREEN.name) {

            HomeScreen(navigateToGestureScreen = {

                navController.navigate(Destinations.GESTURE_SCREEN.name)

            }, navigateToProfileDetailsScreen = { name: String, description: String ->

                navController.navigate(Destinations.PROFILE_DETAILS_SCREEN.name + "/$name/$description")

            })
        }

        composable(Destinations.GESTURE_SCREEN.name) {

            GestureScreen(onBackPressed = {

                navController.popBackStack()

            }, navigateToProfileDetailsScreen = { name: String, description: String ->

                navController.navigate(Destinations.PROFILE_DETAILS_SCREEN.name + "/$name/$description")

            })
        }

        composable(Destinations.PROFILE_DETAILS_SCREEN.name + "/{name}/{description}",

            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType }
            )) {

            val name = it.arguments?.getString("name")
            val description = it.arguments?.getString("description")

            ProfileDetailsScreen(
                name ?: "", description ?: "", onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}