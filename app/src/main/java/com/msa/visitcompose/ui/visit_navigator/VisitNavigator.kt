package com.msa.visitcompose.ui.visit_navigator

import android.view.animation.OvershootInterpolator
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.msa.visitcompose.ui.navgraph.Route
import com.msa.visitcompose.ui.screen.home.HomeScreen
import com.msa.visitcompose.ui.screen.report.ReportScreen
import com.msa.visitcompose.ui.screen.setting.SettingScreen
import com.msa.visitcompose.ui.theme.*
import com.msa.visitcompose.ui.theme.VisitComposeTheme
import com.msa.visitcompose.ui.visit_navigator.bottomNav.AnimatedNavigationBar
import com.msa.visitcompose.ui.visit_navigator.bottomNav.animation.balltrajectory.Parabolic
import com.msa.visitcompose.ui.visit_navigator.bottomNav.animation.indendshape.Height
import com.msa.visitcompose.ui.visit_navigator.bottomNav.animation.indendshape.shapeCornerRadius
import com.msa.visitcompose.ui.visit_navigator.bottomNav.items.dropletbutton.DropletButton
import com.msa.visitcompose.ui.visit_navigator.bottomNav.utils.noRippleClickable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisitNavigator() {

    val navigationBarItem = remember {
        NavigationBarItems.values()
    }

    var selectedIndex by remember {
        mutableStateOf(1)
    }
    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value

    Scaffold(
        bottomBar = {
            AnimatedNavigationBar(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 40.dp)
                    .height(85.dp),
                selectedIndex = selectedIndex,
                cornerRadius = shapeCornerRadius(cornerRadius = 34.dp),
                ballAnimation = Parabolic(tween(300)),
                indentAnimation = Height(tween(300)),
                barColor = Pink40,
                ballColor = Pink40
            ) {
                navigationBarItem.forEachIndexed() { index ,it->
//                    DropletButton(
//                        modifier = Modifier.fillMaxSize(),
//                        isSelected = selectedIndex == index,
//                        onClick = { selectedIndex = index },
//                        icon = it.icon,
//                        dropletColor = Purple40,
//                        animationSpec = tween(durationMillis = Duration, easing = LinearEasing)
//                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .noRippleClickable {
                                selectedIndex=index
                                when (index) {
                                    1 -> navigateToTab(
                                        navController = navController,
                                        route = Route.HomeScreen.route
                                    )

                                    2 -> navigateToTab(
                                        navController = navController,
                                        route = Route.ReportScreen.route
                                    )

                                    3 -> navigateToTab(
                                        navController = navController,
                                        route = Route.SettingScreen.route
                                    )

                                    else -> {}
                                }

                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(26.dp),
                            imageVector = it.icon,
                            contentDescription = "Bottom Bar",
                            tint = Color.White
                        )
                    }
                }

            }
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Route.HomeScreen.route) {
                HomeScreen()
            }

            composable(route = Route.ReportScreen.route) {
                ReportScreen()
            }

            composable(route = Route.SettingScreen.route) {
                SettingScreen()
            }
        }
    }
}



@Composable
@Preview(showBackground = true)
fun VisitNavigatorPreview() {
    VisitComposeTheme {
        VisitNavigator()
    }

}
@Composable
fun OnBackClickStateSaver(navController: NavController) {
    BackHandler(true) {
        navigateToTab(
            navController = navController,
            route = Route.HomeScreen.route
        )
    }
}
private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { screen_route ->
            popUpTo(screen_route) {
                saveState = true
            }
        }
        launchSingleTop = true
        restoreState = true
    }
}


enum class NavigationBarItems(val icon: ImageVector) {
    Person(icon = Icons.Default.Person),
    Home(icon = Icons.Default.Home),
    Report(icon = Icons.Default.Analytics),
    Setteng(icon = Icons.Default.Settings)

}