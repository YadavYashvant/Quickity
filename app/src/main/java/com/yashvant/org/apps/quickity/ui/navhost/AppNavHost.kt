package com.yashvant.org.apps.quickity.ui.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.yashvant.org.apps.quickity.ui.screen.imagepicker.ImagePicker
import com.yashvant.org.apps.quickity.ui.screen.result.ResultScreen
import com.yashvant.org.apps.quickity.ui.screen.generatecode.GenerateCodeScreen
import com.yashvant.org.apps.quickity.ui.screen.home.HomeScreen
import com.yashvant.org.apps.quickity.ui.screen.scan.ScanScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route,
    //viewModel: ScannedItemViewModel,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController = navController, /*viewModel = viewModel*/)
        }
        composable(
            "${NavigationItem.Result.route}/{result}",
            arguments = listOf(navArgument("result") { type = NavType.StringType })
        ) {
            ResultScreen(
                navController, it.arguments?.getString("result").toString()
            )
        }
        composable(NavigationItem.Generate.route) {
            GenerateCodeScreen(navController)
        }
        composable(NavigationItem.ImagePicker.route) {
            ImagePicker(navController)
        }
        composable(NavigationItem.Scan.route) {
            ScanScreen(navController)
        }
    }
}