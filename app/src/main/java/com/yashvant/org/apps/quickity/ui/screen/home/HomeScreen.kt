package com.yashvant.org.apps.quickity.ui.screen.home

import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

fun HomeScreen(navController: NavHostController, /*viewModel: ScannedItemViewModel*/) {
    val context = LocalContext.current
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
            context,
            android.Manifest.permission.CAMERA
        ) -> {
            Log.d("TAG", "PERMISSION GRANTED")
        }
        else -> {
            launcher.launch(android.Manifest.permission.CAMERA)
        }
    }

    val scanner = BarcodeScanner(context)
    val scannerView = remember { BarcodeScannerView(context, scanner) }
    val scannerViewModifier = Modifier.fillMaxSize()
    val scannerViewContentDescription = "Scanner view"
    val scannerViewContentDescriptionModifier = Modifier.focusable(true)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        scannerView(
            modifier = scannerViewModifier,
            contentDescription = scannerViewContentDescription,
            contentDescriptionModifier = scannerViewContentDescriptionModifier
        )
    }
}