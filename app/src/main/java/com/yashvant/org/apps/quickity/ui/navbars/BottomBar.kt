package com.yashvant.org.apps.quickity.ui.navbars

import com.yashvant.org.apps.quickity.ui.theme.redV
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.yashvant.org.apps.qrscanner.R
import com.yashvant.org.apps.quickity.ui.theme.whiteV


data class BottomNavigationItem(
    val title: String,
    val selectedIcon: Painter,
    val unselectedIcon: Painter,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation(
    navController: NavController
){
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = painterResource(id = R.drawable.home_filled),
            unselectedIcon = painterResource(id = R.drawable.outline_home_24),
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "Scan",
            selectedIcon = painterResource(id = R.drawable.baseline_qr_code_scanner_24),
            unselectedIcon = painterResource(id = R.drawable.outline_qr_code_scanner_24),
            hasNews = true,

            ),
        BottomNavigationItem(
            title = "Bills",
            selectedIcon = painterResource(id = R.drawable.baseline_menu_book_24),
            unselectedIcon = painterResource(id = R.drawable.outline_menu_book_24),
            hasNews = false,
            /*badgeCount = 0*/
        ),

        /*BottomNavigationItem(
            title = "Settings",
            selectedIcon = painterResource(id = R.drawable.baseline_settings_24),
            unselectedIcon = painterResource(id = R.drawable.outline_settings_24),
            hasNews = false,
        )*/
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.title)
                    // navController.navigate(item.title)
                },
                colors = androidx.compose.material3.NavigationBarItemDefaults
                    .colors(
                        selectedIconColor = redV,
                        //indicatorColor = Color.Transparent,
                    ),
                label = {
                    Text(text = item.title, color = redV)
                },
                alwaysShowLabel = false,
                icon = {
                    Icon(
                        painter = if (index == selectedItemIndex) {
                            item.selectedIcon
                        } else item.unselectedIcon,
                        contentDescription = item.title,
                        tint = redV
                    )

                })
        }
    }
}