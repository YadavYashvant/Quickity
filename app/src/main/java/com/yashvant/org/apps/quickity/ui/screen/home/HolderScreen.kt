
package com.yashvant.org.apps.quickity.ui.screen.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yashvant.org.apps.qrscanner.R
import com.yashvant.org.apps.quickity.animation.AnimatedPreloaderJet
import com.yashvant.org.apps.quickity.api_feature.ApiClient
import com.yashvant.org.apps.quickity.api_feature.User
import com.yashvant.org.apps.quickity.bill_feature.ui.BillsScreen
import com.yashvant.org.apps.quickity.ui.navbars.BottomNavigation
import com.yashvant.org.apps.quickity.ui.navhost.NavigationItem
import com.yashvant.org.apps.quickity.ui.theme.barlowext
import com.yashvant.org.apps.quickity.ui.theme.redV
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HolderScreen(navController: NavController) {
    val navbarController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navbarController)
        }
    ) {
        NavHost(navController = navbarController, startDestination = "home"){
            composable("Home"){
                HomeScreen()
            }


            composable("Scan") {
                Column {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                    ) {
                        Column(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(top = 16.dp, bottom = 56.dp),
                        ) {
                            Button(
                                onClick = {
                                    navController.navigate(NavigationItem.Scan.route)
                                },
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .padding(vertical = 16.dp)
                                    .height(100.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = redV
                                )
                            ) {
                                Text(
                                    stringResource(R.string.scan_code),
                                    fontFamily = barlowext,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Divider(
                                color = redV, thickness = 8.dp, modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 48.dp)
                                    .clip(RoundedCornerShape(20.dp))
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Button(
                                onClick = {
                                    navController.navigate(NavigationItem.Generate.route)
                                },
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .fillMaxWidth()
                                    .padding(vertical = 16.dp, horizontal = 32.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = redV
                                )
                            ) {
                                Text(stringResource(R.string.generate_qr_code))
                            }
                        }
                    }

                    Divider(modifier = Modifier.padding(horizontal = 16.dp))

                    Card(
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                    ) {
                        AnimatedPreloaderJet(modifier = Modifier.height(400.dp))
                    }
                }
            }

            composable("Bills"){
                BillsScreen(navigateToUpdateBillScreen = { bookId ->
                    navController.navigate(
                        route = "${NavigationItem.UpdateBill.route}/${bookId}"
                    )
                })
            }
        }
    }
}