package com.yashvant.org.apps.quickity.ui.screen.home

import android.util.Log
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yashvant.org.apps.quickity.api_feature.ApiClient
import com.yashvant.org.apps.quickity.api_feature.User
import com.yashvant.org.apps.quickity.ui.screen.home.components.CategoryCard
import com.yashvant.org.apps.quickity.ui.theme.barlowext
import com.yashvant.org.apps.quickity.ui.theme.barlowfont
import com.yashvant.org.apps.quickity.ui.theme.klandstinfont
import com.yashvant.org.apps.quickity.ui.theme.redV
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun HomeScreen(){

    val user = "Yashvant"
    var scrollstate = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .padding(bottom = 75.dp)
            .verticalScroll(scrollstate)
            .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()

//                    .padding(horizontal = 16.dp)
            ) {
                /*Text(
                    "Quickity", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(32.dp))
*/
                Text(
                    "Hi There, ", fontSize = 48.sp, fontWeight = FontWeight.Bold, fontFamily = barlowfont,
                    modifier = Modifier
                        .align(Alignment.Start)
                )
                Text(
                    user, fontSize = 36.sp, fontWeight = FontWeight.Bold, color = redV, fontFamily = klandstinfont,
                    modifier = Modifier
                        .align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(36.dp))

                Text(
                    "Explore . . . ", fontSize = 24.sp, fontWeight = FontWeight.Bold, fontFamily = barlowfont,
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
                
                Spacer(modifier = Modifier.height(8.dp))

                CupertinoAccordionDemo()

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

@Composable
fun CupertinoAccordionItem(
    title: String,
    content: @Composable () -> Unit,
    expanded: Boolean,
    onToggle: () -> Unit
) {
    val backgroundColor = if (expanded) Color(0xFFF0F0F0) else Color.Transparent
    val borderColor = if (expanded) Color(0xFFD1D1D1) else Color(0xFFCCCCCC)
    val elevation = if (expanded) 2.dp else 0.dp
    val contentHeight by animateDpAsState(
        targetValue = if (expanded) 100.dp else 0.dp,
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing), label = ""
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
//            .background(backgroundColor)
            .clip(RoundedCornerShape(10.dp))
            .clickable(onClick = onToggle)
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface,
                fontFamily = barlowfont
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = "Toggle",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        Box(
            Modifier
                .height(contentHeight)
                .padding(vertical = 8.dp)
        ) {
            content()
        }
        Divider(color = borderColor, thickness = 1.dp)
    }
}

@Composable
fun CupertinoAccordionDemo() {
    var expandedIndex by remember { mutableStateOf(0) }

   Card(
       modifier = Modifier.padding(bottom = 20.dp)
   ) {
    Column {
        CupertinoAccordionItem(
            title = "Section 1",
            expanded = expandedIndex == 0,
            onToggle = { expandedIndex = if (expandedIndex == 0) -1 else 0 },
            content = { Text("Content of section 3") }
        )
        CupertinoAccordionItem(
            title = "Section 2",
            expanded = expandedIndex == 1,
            onToggle = { expandedIndex = if (expandedIndex == 1) -1 else 1 },
            content = { Text("Content of section 3") }
        )
        CupertinoAccordionItem(
            title = "Section 3",
            expanded = expandedIndex == 2,
            onToggle = { expandedIndex = if (expandedIndex == 2) -1 else 2 },
            content = { Text("Content of section 3") }
        )
        CupertinoAccordionItem(
            title = "Section 4",
            expanded = expandedIndex == 3,
            onToggle = { expandedIndex = if (expandedIndex == 3) -1 else 3 },
            content = { Text("Content of section 3") }
        )
        CupertinoAccordionItem(
            title = "Section 5",
            expanded = expandedIndex == 4,
            onToggle = { expandedIndex = if (expandedIndex == 4) -1 else 4 },
            content = { Text("Content of section 3") }
        )
    }
   }
}