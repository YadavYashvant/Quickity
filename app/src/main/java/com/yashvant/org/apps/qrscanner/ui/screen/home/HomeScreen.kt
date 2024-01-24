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
        Scaffold(
            topBar = {
                Text(stringResource(R.string.app_name))
            },
            bottomBar = {
                BottomNavigation(navController = navController)
            }
        ) {
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