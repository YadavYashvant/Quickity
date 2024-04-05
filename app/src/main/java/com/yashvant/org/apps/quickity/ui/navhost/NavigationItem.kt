package com.yashvant.org.apps.quickity.ui.navhost

import com.yashvant.org.apps.quickity.utils.Constants.Companion.BILLS_SCREEN
import com.yashvant.org.apps.quickity.utils.Constants.Companion.PAY_WITH_UPI_SCREEN
import com.yashvant.org.apps.quickity.utils.Constants.Companion.UPDATE_BILL_SCREEN

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
    object Bills : NavigationItem(BILLS_SCREEN)
    object UpdateBill : NavigationItem(UPDATE_BILL_SCREEN)

    object PayWithUPI : NavigationItem(PAY_WITH_UPI_SCREEN)
}