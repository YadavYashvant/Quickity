package ro.alexmamo.roomjetpackcompose.presentation.books.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yashvant.org.apps.qrscanner.R
import com.yashvant.org.apps.quickity.bill_feature.model.Bill
import com.yashvant.org.apps.quickity.ui.theme.greenColor
import com.yashvant.org.apps.quickity.ui.theme.redV

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BillCard(
    bill: Bill,
    deleteBill: () -> Unit,
    navigateToUpdateBillScreen: (billId: Int) -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .wrapContentHeight()
            .padding(10.dp),
//        shadowElevation = 6.dp

        onClick = {
            navigateToUpdateBillScreen(bill.id)
        }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.wrapContentSize(),
                    color = MaterialTheme.colorScheme.onPrimary
                ) {
                    Text(
                        text = "Bill",
                        fontSize =  12.sp,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = bill.Item,
                    fontSize =  24.sp,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(text = bill.price.toString(), fontSize =  16.sp, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold, fontStyle = FontStyle.Italic)

                Spacer(modifier = Modifier.height(6.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "4.0",
                        fontSize =  14.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_brightness_low_24),
                        tint = greenColor,
                        contentDescription = null
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_brightness_low_24),
//                        tint = Color(0xFFF6B266),
                        tint = greenColor,
                        contentDescription = null
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_brightness_low_24),
                        tint = greenColor,
                        contentDescription = null
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_brightness_low_24),
                        tint = greenColor,
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                OutlinedButton(
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Read More",
                        fontSize =  11.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge,
                    )


                }
/*
                DeleteIcon(
                    deleteBill = deleteBill
                )*/
            }



            Surface(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(height = 200.dp, width = 100.dp),
                color = MaterialTheme.colorScheme.onPrimary,
            ) {
                Image(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null,
                    colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(redV)
                )
            }
        }
    }
}