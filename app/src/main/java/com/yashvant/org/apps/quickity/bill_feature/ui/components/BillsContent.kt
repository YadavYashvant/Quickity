package ro.alexmamo.roomjetpackcompose.presentation.books.components

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.yashvant.org.apps.quickity.MainActivity
import com.yashvant.org.apps.quickity.animation.AnimatedPreloaderTransfer
import com.yashvant.org.apps.quickity.bill_feature.model.Bill
import com.yashvant.org.apps.quickity.bill_feature.model.Bills
import com.yashvant.org.apps.quickity.ui.theme.barlowext
import com.yashvant.org.apps.quickity.ui.theme.blueV
import com.yashvant.org.apps.quickity.ui.theme.greenColor
import com.yashvant.org.apps.quickity.ui.theme.redV
import com.yashvant.org.apps.quickity.ui.theme.whiteV
import dev.shreyaspatil.easyupipayment.EasyUpiPayment
import dev.shreyaspatil.easyupipayment.listener.PaymentStatusListener
import dev.shreyaspatil.easyupipayment.model.PaymentApp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
@ExperimentalMaterial3Api
fun BillsContent(
    padding: PaddingValues,
    bills: Bills,
    deleteBill: (bill: Bill) -> Unit,
    navigateToUpdateBillScreen: (billId: Int) -> Unit,
    mainActivity: MainActivity,
    payWithUpi: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding()
    ) {
        items(
            items = bills,
        ) { bill ->
            BillCard(
                bill = bill,
                deleteBill = {
                    deleteBill(bill)
                },
                navigateToUpdateBillScreen = navigateToUpdateBillScreen
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UPIPaymentScreen(mainActivity: MainActivity, navController: NavHostController) {
    val ctx = LocalContext.current
    val activity = (LocalContext.current as? Activity)
    val textRcolors = listOf<Color>(greenColor, redV, blueV)

    val amount = remember {
        mutableStateOf(TextFieldValue())
    }
    val upiId = remember {
        mutableStateOf(TextFieldValue())
    }
    val name = remember {
        mutableStateOf(TextFieldValue())
    }
    val description = remember {
        mutableStateOf(TextFieldValue())
    }

    val brush = remember {
        Brush.linearGradient(
            colors = textRcolors
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedPreloaderTransfer(
            modifier = Modifier.height(50.dp)
        )

        OutlinedCard(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {

            Text(
                text = "Pay with UPI",
                color = greenColor,
                fontFamily = barlowext,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
                style = TextStyle(brush = brush),
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally),
            )

            Spacer(modifier = Modifier.height(5.dp))

            TextField(
                value = amount.value,
                onValueChange = { amount.value = it },
                placeholder = { Text(text = "Enter amount to be paid") },

                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),

                textStyle = TextStyle(brush = brush, fontSize = 15.sp),
                singleLine = true,
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )

            )
            Spacer(modifier = Modifier.height(5.dp))
            TextField(
                value = upiId.value,
                onValueChange = { upiId.value = it },
                placeholder = { Text(text = "Enter UPI Id") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),

                textStyle = TextStyle(brush = brush, fontSize = 15.sp),
                singleLine = true,
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(5.dp))

            TextField(
                value = name.value,
                onValueChange = { name.value = it },
                placeholder = { Text(text = "Enter name") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(brush = brush, fontSize = 15.sp),
                singleLine = true,
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(5.dp))

            TextField(
                value = description.value,
                onValueChange = { description.value = it },

                placeholder = { Text(text = "Enter Description") },

                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(brush = brush, fontSize = 15.sp),
                singleLine = true,
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

        }

        Button(
            onClick = {
                val c: Date = Calendar.getInstance().getTime()
                val df = SimpleDateFormat("ddMMyyyyHHmmss", Locale.getDefault())
                val transcId: String = df.format(c)

                makePayment(
                    amount.value.text,
                    upiId.value.text,
                    name.value.text,
                    description.value.text,
                    transcId,
                    ctx,
                    activity!!,
                    mainActivity
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = greenColor
            )
        ) {
            Text(text = "Make Payment", modifier = Modifier.padding(8.dp))
        }
    }
}

private fun makePayment(
    amount: String,
    upi: String,
    name: String,
    desc: String,
    transcId: String, ctx: Context, activity: Activity, mainActivity: PaymentStatusListener
) {
    try {
        val easyUpiPayment = EasyUpiPayment(activity) {
            this.paymentApp = PaymentApp.ALL
            this.payeeVpa = upi
            this.payeeName = name
            this.transactionId = transcId
            this.transactionRefId = transcId
            this.payeeMerchantCode = transcId
            this.description = desc
            this.amount = amount
        }
        easyUpiPayment.setPaymentStatusListener(mainActivity)

        easyUpiPayment.startPayment()
    } catch (e: Exception) {
        e.printStackTrace()
        Toast.makeText(ctx, e.message, Toast.LENGTH_SHORT).show()
    }
}