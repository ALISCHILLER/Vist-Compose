package com.msa.visitcompose.ui.navgraph

import androidx.navigation.NamedNavArgument

sealed class Route(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    object LoginScreen : Route(route = "loginScreen")
    object HomeScreen : Route(route = "homeScreen")
    object ReportScreen : Route(route = "reportScreen")
    object SettingScreen : Route(route = "settingScreen")
    object AppStartNavigation : Route(route = "appStartNavigation")
    object VisitNavigation : Route(route = "visitNavigation")
    object VisitNavigatorScreen : Route(route = "visitNavigator")


}