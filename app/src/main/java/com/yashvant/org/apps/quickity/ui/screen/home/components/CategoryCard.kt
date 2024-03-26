package com.yashvant.org.apps.quickity.ui.screen.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.yashvant.org.apps.qrscanner.R

@Composable
fun CategoryCard() {
    Card(
        modifier = Modifier
            .width(250.dp)
            .height(350.dp)
//            .padding(horizontal = 16.dp)
        ,
        shape = RoundedCornerShape(20.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.grocery), contentDescription = "grocery",
            contentScale = ContentScale.Fit
            )
    }
}