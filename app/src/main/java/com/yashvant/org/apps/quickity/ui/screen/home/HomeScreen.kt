package com.yashvant.org.apps.quickity.ui.screen.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yashvant.org.apps.quickity.api_feature.ApiClient
import com.yashvant.org.apps.quickity.api_feature.User
import com.yashvant.org.apps.quickity.ui.screen.home.components.CategoryCard
import com.yashvant.org.apps.quickity.ui.theme.barlowfont
import com.yashvant.org.apps.quickity.ui.theme.klandstinfont
import com.yashvant.org.apps.quickity.ui.theme.redV
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun HomeScreen(){

    val user = "Yashvant"

    Column(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .padding(bottom = 75.dp)
            .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                /*Text(
                    "Quickity", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(32.dp))
*/
                Text(
                    "Hi There, ", fontSize = 62.sp, fontWeight = FontWeight.Bold, fontFamily = barlowfont,
                    modifier = Modifier
                        .align(Alignment.Start)
                )
                Text(
                    user, fontSize = 48.sp, fontWeight = FontWeight.Bold, color = redV, fontFamily = barlowfont,
                    modifier = Modifier
                        .align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(48.dp))

                Text(
                    "Explore . . . ", fontSize = 36.sp, fontWeight = FontWeight.Bold, fontFamily = barlowfont,
                    modifier = Modifier
                        .align(Alignment.Start)
                )

                LazyRow(
                    modifier = Modifier
                        .height(500.dp)
                        .padding(vertical = 32.dp)
                ){
                    items(10) {
                        CategoryCard()
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }

                /*Button(
                    onClick = {
                        Log.d("api", "Button clicked")
//                      val call = ApiClient.apiService.getHello()
                        val user_call = ApiClient.apiService.getUser()
                        user_call.enqueue(object : Callback<User> {
                            override fun onResponse(
                                call: Call<User>,
                                response: Response<User>
                            ) {
                                if (response.isSuccessful) {
                                    val user = response.body()
                                    Log.d("api", "$user")
                                    // Handle the retrieved post data
                                } else {
                                    // Handle error
                                    Log.e("api", "Error getting post")
                                }
                            }

                            override fun onFailure(call: Call<User>, t: Throwable) {
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
                }*/

            }
    }

}