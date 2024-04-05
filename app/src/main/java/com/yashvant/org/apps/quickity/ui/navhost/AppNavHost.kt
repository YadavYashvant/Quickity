package com.yashvant.org.apps.quickity.ui.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.yashvant.org.apps.quickity.MainActivity
import com.yashvant.org.apps.quickity.bill_feature.ui.BillsScreen
import com.yashvant.org.apps.quickity.ui.screen.imagepicker.ImagePicker
import com.yashvant.org.apps.quickity.ui.screen.result.ResultScreen
import com.yashvant.org.apps.quickity.ui.screen.generatecode.GenerateCodeScreen
import com.yashvant.org.apps.quickity.ui.screen.home.HolderScreen
import com.yashvant.org.apps.quickity.ui.screen.scan.ScanScreen
import com.yashvant.org.apps.quickity.utils.Constants.Companion.BILL_ID
import ro.alexmamo.roomjetpackcompose.presentation.books.components.UPIPaymentScreen
import ro.alexmamo.roomjetpackcompose.presentation.update_book.UpdateBillScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route,
    mainActivity: MainActivity
    //viewModel: ScannedItemViewModel,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Home.route) {
            HolderScreen(navController = navController,mainActivity = mainActivity /*viewModel = viewModel*/)
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
        composable(NavigationItem.PayWithUPI.route) {
            UPIPaymentScreen(mainActivity = mainActivity, navController = navController)
        }

        composable(
            route = NavigationItem.Bills.route
        ) {
            BillsScreen(
                navigateToUpdateBillScreen = { billId ->
                    navController.navigate(
                        route = "${NavigationItem.UpdateBill.route}/${billId}"
                    )
                },
                mainActivity = mainActivity,
                payWithUpi = {
                    navController.navigate(NavigationItem.PayWithUPI.route)
                }
            )
        }
        composable(
            route = "${NavigationItem.UpdateBill.route}/{$BILL_ID}",
            arguments = listOf(
                navArgument(BILL_ID) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val billId = backStackEntry.arguments?.getInt(BILL_ID) ?: 0
            UpdateBillScreen(
                billId = billId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}