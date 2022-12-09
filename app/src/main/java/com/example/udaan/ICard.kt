package com.example.udaan

import android.Manifest
import android.content.pm.PackageManager
import android.util.Size
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
//import androidx.navigation.compose.rememberNavController

@androidx.compose.ui.tooling.preview.Preview(showBackground = true, showSystemUi = true)
@Composable
fun ICard(){
    Card(

        modifier = Modifier
            .padding(20.dp)

    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp)
        ){
            Text(
                text = "Name: ",
                fontSize = 20.sp,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(
                text = "Class: ",
                fontSize = 20.sp,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(
                text = "Enrollment Number: ",
                fontSize = 20.sp,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(
                text = "Mobile Number: ",
                fontSize = 20.sp,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
            )


        }
    }
}

@Composable
fun ICardLayout() {
    var code by remember { mutableStateOf("") }
    val context = LocalContext.current
    val cameraProviderFuture = remember {
        ProcessCameraProvider.getInstance(context)
    }
    val lifecycleOwner = LocalLifecycleOwner.current
    var hasCameraPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            hasCameraPermission = granted
        }
    )
    LaunchedEffect(key1 = true) {
        launcher.launch(Manifest.permission.CAMERA)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (hasCameraPermission) {
            AndroidView(
                factory = { context ->
                    val previewView = PreviewView(context)
                    val preview = Preview.Builder().build()
                    val selector = CameraSelector.Builder()
                        .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                        .build()
                    preview.setSurfaceProvider(previewView.surfaceProvider)
                    val imageAnalysis = ImageAnalysis.Builder()
                        .setTargetResolution(
                            Size(
                                previewView.width,
                                previewView.height
                            )
                        )
                        .setBackpressureStrategy(STRATEGY_KEEP_ONLY_LATEST)
                        .build()
                    imageAnalysis.setAnalyzer(
                        ContextCompat.getMainExecutor(context),
                        QrCodeAnalyzer { result ->
                            code = result
                        }
                    )

                    try {
                        cameraProviderFuture.get().bindToLifecycle(
                            lifecycleOwner,
                            selector,
                            preview,
                            imageAnalysis
                        )
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    previewView
                },
                modifier = Modifier.weight(1f)
            )
            Text(
                    text = code,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
            )
        }
    }
}

//@androidx.compose.ui.tooling.preview.Preview(showBackground = true, showSystemUi = true)
@Composable
fun ICardPreview(){
   ICardLayout()
}