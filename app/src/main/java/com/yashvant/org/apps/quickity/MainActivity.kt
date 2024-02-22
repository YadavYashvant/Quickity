package com.yashvant.org.apps.quickity

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
//import com.yashvant.org.apps.quickity.bill_feature.entity.ScannedItemViewModel
import com.yashvant.org.apps.quickity.ui.navhost.AppNavHost
import com.yashvant.org.apps.quickity.ui.theme.QRScannerTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //private val viewModel: ScannedItemViewModel by viewModels()

//    companion object {
//        @SuppressLint("StaticFieldLeak")
//        lateinit var beepManager: BeepManager
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        beepManager = BeepManager(this)
        setContent {
            RequestPermission()

            QRScannerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

//                    ScanScreen()
                    AppNavHost(navController = rememberNavController(),/* viewModel = viewModel*/)
                    // TabLayoutScreen()
                }
            }
        }
    }
}

@Composable
fun RequestPermission() {
    val launcher: ManagedActivityResultLauncher<String, Boolean> =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Log.d("TAG", "PERMISSION GRANTED")
            }
        }

    when (PackageManager.PERMISSION_GRANTED) {
        ContextCompat.checkSelfPermission(
            LocalContext.current,
            android.Manifest.permission.CAMERA
        ) -> {
            // Some works that require permission
            Log.d("TAG", "Code requires permission")
        }

        else -> {
            // Asking for permission
            SideEffect {
                launcher.launch(android.Manifest.permission.CAMERA)
            }
        }
    }

}