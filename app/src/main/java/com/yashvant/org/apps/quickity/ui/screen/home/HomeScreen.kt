package com.yashvant.org.apps.quickity.ui.screen.home

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yashvant.org.apps.quickity.api_feature.ApiClient
import com.yashvant.org.apps.quickity.api_feature.User
import com.yashvant.org.apps.quickity.notification_feature.sendNotification
import com.yashvant.org.apps.quickity.ui.screen.home.components.CategoryCard
import com.yashvant.org.apps.quickity.ui.theme.barlowext
import com.yashvant.org.apps.quickity.ui.theme.barlowfont
import com.yashvant.org.apps.quickity.ui.theme.greenColor
import com.yashvant.org.apps.quickity.ui.theme.klandstinfont
import com.yashvant.org.apps.quickity.ui.theme.redV
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.CardColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yashvant.org.apps.quickity.animation.AnimatedPreloaderGradient
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    val items = listOf( Icons.Default.Home, Icons.Filled.Settings, Icons.Filled.Search, Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email,)
    val items_name = listOf("Home", "Settings", "Search","Favorite", "Profile", "Contact", )
    val selectedItem = remember{
        mutableStateOf(items[0])
    }
    BackHandler(enabled = drawerState.isOpen) {
        scope.launch {
            drawerState.close()
        }
    }
    ModalNavigationDrawer(
        drawerState = drawerState,
        modifier = Modifier.background(MaterialTheme.colorScheme.onPrimary),

        drawerContent = {
            DismissibleDrawerSheet{
                Spacer(Modifier.height(12.dp))
                items.forEachIndexed {index,item->
                    NavigationDrawerItem(
                        icon = { Icon(item, contentDescription = null)},
                        label = { Text(items_name[index]) },
                        selected = item == selectedItem.value ,
                        onClick = { /*TODO*/
                            scope.launch { drawerState.close() }
                            selectedItem.value = item
                        },
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                        shape = RoundedCornerShape(20.dp)
                    )
                }
            }
        }
    ){
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "QUICKITY",
                            fontFamily = klandstinfont,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    },
                )
            },
            content = {
                val user = "Yashvant"
                var scrollstate = rememberScrollState()
                val scrollState = rememberScrollState()
                val gradientColors = listOf(
                    Color(0xFF4CAF50),
                    Color(0xFF2196F3),
                    Color(0xFF9C27B0),
                    Color(0xFFFF5722),
                    Color(0xFFFFC107),
                    Color(0xFF009688)
                )
                val animatedProgress = remember { Animatable(0f) }

                val mContext = LocalContext.current

                LaunchedEffect(Unit) {
                    animatedProgress.animateTo(
                        targetValue = 1f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(durationMillis = 3000),
                            repeatMode = RepeatMode.Reverse
                        )
                    )
                }

                val backgroundBrush = Brush.linearGradient(
                    colors = gradientColors,
                    start = Offset(x = 0f, 0f),
                    end = Offset(x = animatedProgress.value, y = 0f)
                )

                Column(
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                        .padding(top = 56.dp)
                        .verticalScroll(scrollstate)
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 32.dp),
                        ) {
                            Column(
                                modifier = Modifier.wrapContentSize()
                            ) {
                                Text(
                                    "Hi There, ", fontSize = 48.sp, fontWeight = FontWeight.Bold, fontFamily = barlowfont,
                                    modifier = Modifier
                                        .align(Alignment.Start)
                                )
                                Text(
                                    user, fontSize = 48.sp, fontWeight = FontWeight.Bold, color = redV, fontFamily = barlowext,
                                    modifier = Modifier
                                        .align(Alignment.Start)
                                )
                            }

                            AnimatedPreloaderGradient(modifier = Modifier.height(145.dp))
                        }

                        Spacer(modifier = Modifier.height(36.dp))

                        Text(
                            "Explore . . . ", fontSize = 24.sp, fontWeight = FontWeight.Bold, fontFamily = barlowfont,
                            modifier = Modifier
                                .align(Alignment.Start)
                        )

                        LazyRow(
                            modifier = Modifier
                                .wrapContentHeight()
                                .padding(vertical = 32.dp)
                        ){
                            items(7) {
                                CategoryCard()
                                Spacer(modifier = Modifier.width(16.dp))
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = greenColor
                            ),
                            onClick = {
                                sendNotification(mContext, "YOUR BILL IS READY !!", "Hey Yashvant, your shopping bill has arrived, now pay the bill kindly for further procedure :>)")
                                Log.d("notification", "Notification sent")
                            }
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
                            ) {
                                Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "notify", Modifier.scale(1.5f))
                                Text(text = "Notify Me", fontSize = 20.sp, modifier = Modifier.padding(start = 16.dp), fontFamily = barlowfont, fontWeight = FontWeight.Bold)
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        CupertinoAccordionDemo()

                        Spacer(modifier = Modifier.height(60.dp))

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
        )
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
                fontFamily = barlowfont,
                fontWeight = FontWeight.Bold
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
            title = "Section 1 ",
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

@Composable
fun GradientWithDots() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .drawWithContent {
                drawContent()
                drawGradientWithDots(size = size, drawScope = this)
            }
    )
}


fun drawGradientWithDots(size: androidx.compose.ui.geometry.Size, drawScope: DrawScope) {
    val numDots = 100
    val dotSize = 10f
    val random = Random(42)

    val colors = listOf(
        Color(0xFF4CAF50),
        Color(0xFF2196F3),
        Color(0xFF9C27B0),
        Color(0xFFFF5722),
        Color(0xFFFFC107),
        Color(0xFF009688)
    )

    val brush = Brush.linearGradient(
        colors = colors,
        start = Offset(0f, 0f),
        end = Offset(size.width, size.height)
    )

    repeat(numDots) {
        val x = random.nextFloat() * size.width
        val y = random.nextFloat() * size.height
        val color = colors[random.nextInt(colors.size)]
        drawScope.drawCircle(color, radius = dotSize, center = Offset(x, y))
    }

    val linearGradient = Brush.verticalGradient(
        colors = listOf(Color.Black, Color.Transparent),
        startY = 0f,
        endY = size.height
    )

    drawScope.drawCircle(
        brush = linearGradient,
        radius = size.height * 0.7f,
        center = Offset(size.width * 0.5f, size.height * 0.5f)
    )
}