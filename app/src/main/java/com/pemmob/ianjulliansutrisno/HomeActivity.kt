package com.pemmob.ianjulliansutrisno

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pemmob.ianjulliansutrisno.ui.screen.DaftarProductScreen // Sesuaikan jika nama fungsinya DaftarProdukScreen
import com.pemmob.ianjulliansutrisno.ui.theme.JualanTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JualanTheme {
                DaftarProductScreen()
            }
        }
    }
}