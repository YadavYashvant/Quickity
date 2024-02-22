package com.yashvant.org.apps.quickity.ui.screen.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yashvant.org.apps.qrscanner.R
import com.yashvant.org.apps.quickity.api_feature.ApiClient
import com.yashvant.org.apps.quickity.api_feature.Post
import com.yashvant.org.apps.quickity.bill_feature.Dao.MyAppDatabase
import com.yashvant.org.apps.quickity.bill_feature.model.User
import com.yashvant.org.apps.quickity.ui.navbars.BottomNavigation
import com.yashvant.org.apps.quickity.ui.navhost.NavigationItem
import com.yashvant.org.apps.quickity.ui.theme.redV
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
        val navbarController = rememberNavController()
        var resui by remember { mutableStateOf("") }
        val userDao = MyAppDatabase.getInstance(context = LocalContext.current).userDao()



    Scaffold(
            bottomBar = {
                BottomNavigation(navController = navbarController)
            }
        ) {
            NavHost(navController = navbarController, startDestination = "home"){
                composable("Home"){
                    LazyColumn(
                        modifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                            .padding(bottom = 75.dp)
                            .fillMaxSize()
                    ) {
                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    "Quickity", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally)
                                )
                                Button(
                                    onClick = {

                                        val call = ApiClient.apiService.getHello()

                                        call.enqueue(object : Callback<String> {
                                            override fun onResponse(
                                                call: Call<String>,
                                                response: Response<String>
                                            ) {
                                                if (response.isSuccessful) {
                                                    val post = response.body()
                                                    Log.d("api", "$post")
                                                    resui = post.toString()
                                                    // Handle the retrieved post data
                                                } else {
                                                    // Handle error
                                                    Log.e("api", "Error getting post")
                                                }
                                            }

                                            override fun onFailure(call: Call<String>, t: Throwable) {
                                                // Handle failure
                                                Log.e("api", "$t")
                                            }
                                        })
                                    },
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally)
                                        .padding(vertical = 16.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = redV
                                    )
                                ) {
                                    Text(text = "Generate random post")
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                            }
                        }
                        items(4){
                            val image = pickrandomImage()
                                Card(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .padding(vertical = 8.dp)
                                        .fillMaxWidth()
                                        .height(200.dp)
                                ) {
                                    Text(text = resui, modifier = Modifier.fillMaxWidth(), fontSize = 32.sp)
                                    /*Text(text = responseforui.body, modifier = Modifier.fillMaxWidth(), fontSize = 16.sp)
                                    Text(text = responseforui.userId.toString(), modifier = Modifier.fillMaxWidth(), fontSize = 16.sp)*/
                                    /*Image(
                                        painter = painterResource(id = image),
                                         contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale = androidx.compose.ui.layout.ContentScale.FillBounds
                                    )*/
                                }
                            }
                        }
                    }


                composable("Scan") {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 16.dp, bottom = 56.dp),
                    ) {
                        Button(
                            onClick = {
                                navController.navigate(NavigationItem.Scan.route)
                            },
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(vertical = 16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = redV
                            )
                        ) {
                            Text(stringResource(R.string.scan_code))
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = {
                            navController.navigate(NavigationItem.Generate.route)
                        },
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(vertical = 16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = redV
                            )
                        ) {
                            Text(stringResource(R.string.generate_qr_code))
                        }
                    }
                }


                composable("Bills"){
                    //BillScreen(viewModel = viewModel)
                    Text(text = "Bill screen", modifier = Modifier.fillMaxWidth(), fontSize = 32.sp)
                }
            }
        }
}

val imagelist = listOf(
    R.drawable.lakeside_sunset,
    R.drawable.lowpoly_street,
    R.drawable.lucy_rebecca,
    R.drawable.messi,
    R.drawable.moments_before_desk,
    R.drawable.night_city,
)

fun pickrandomImage(): Int {
    return imagelist.random()
}
