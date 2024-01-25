package com.yashvant.org.apps.qrscanner.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yashvant.org.apps.qrscanner.R
import com.yashvant.org.apps.qrscanner.ui.navbars.BottomNavigation
import com.yashvant.org.apps.qrscanner.ui.navhost.NavigationItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val navbarController = rememberNavController()

        Scaffold(
            bottomBar = {
                BottomNavigation(navController = navbarController)
            }
        ) {
            NavHost(navController = navbarController, startDestination = "home"){
                composable("Home"){
                    Text("This is home page")
                }
                composable("Scan"){
                    Text("This is scan page")
                }
                composable("Bills"){
                    Text("This is bills page")
                }
            }
        }
    }
}

/*
Button(onClick = {
            navController.navigate(NavigationItem.Scan.route)
        }) {
            Text(stringResource(R.string.scan_code))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navController.navigate(NavigationItem.Generate.route)
        }) {
            Text(stringResource(R.string.generate_qr_code))
        }
 */