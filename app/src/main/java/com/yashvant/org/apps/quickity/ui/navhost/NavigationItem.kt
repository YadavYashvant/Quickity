package com.yashvant.org.apps.quickity.ui.navhost

import com.yashvant.org.apps.quickity.utils.Constants.Companion.BOOKS_SCREEN
import com.yashvant.org.apps.quickity.utils.Constants.Companion.UPDATE_BOOK_SCREEN

enum class Screen {
    HOME,
    SCAN,
    GENERATE,
    RESULT,
    IMAGE_PICKER,
}

sealed class NavigationItem(val route: String) {
    object Home : NavigationItem(Screen.HOME.name)
    object Scan : NavigationItem(Screen.SCAN.name)
    object Generate : NavigationItem(Screen.GENERATE.name)
    object Result : NavigationItem(Screen.RESULT.name)
    object ImagePicker : NavigationItem(Screen.IMAGE_PICKER.name)
    object Books : NavigationItem(BOOKS_SCREEN)
    object UpdateBook : NavigationItem(UPDATE_BOOK_SCREEN)
}