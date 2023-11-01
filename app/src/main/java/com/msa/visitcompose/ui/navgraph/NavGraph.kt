package com.msa.visitcompose.ui.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.msa.visitcompose.ui.screen.login.LoginScreen
import com.msa.visitcompose.ui.screen.login.LoginViewModel
import com.msa.visitcompose.ui.visit_navigator.VisitNavigator

@Composable
fun NavGraph(
    startDestination: String
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.LoginScreen.route
        ) {
            composable(route = Route.LoginScreen.route) {
                val viewModel: LoginViewModel = hiltViewModel()
                LoginScreen(onEvent = viewModel::onEvent)
            }
        }


        navigation(
            route = Route.VisitNavigation.route,
            startDestination = Route.VisitNavigatorScreen.route
        ) {
            composable(route = Route.VisitNavigatorScreen.route){
                VisitNavigator()
            }
        }


    }
}