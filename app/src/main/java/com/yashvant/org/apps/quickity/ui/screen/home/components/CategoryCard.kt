package com.yashvant.org.apps.quickity.ui.screen.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yashvant.org.apps.qrscanner.R
import com.yashvant.org.apps.quickity.ui.theme.barlowext
import com.yashvant.org.apps.quickity.ui.theme.barlowfont
import com.yashvant.org.apps.quickity.ui.theme.blackV
import com.yashvant.org.apps.quickity.ui.theme.blueV

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard() {
    Card(
        modifier = Modifier
            .width(250.dp)
            .height(350.dp)
        ,
        shape = RoundedCornerShape(20.dp),
        onClick = {}
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.grocery1), contentDescription = "grocery",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Text(text = "GROCERY", fontFamily = barlowext, fontSize = 48.sp, color = blueV, fontWeight = FontWeight.ExtraBold, modifier = Modifier.align(
                Alignment.Center))
        }
    }
}