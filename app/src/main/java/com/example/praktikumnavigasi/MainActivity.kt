package com.example.praktikumnavigasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.praktikumnavigasi.ui.theme.PraktikumNavigasiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PraktikumNavigasiTheme {
                DataApp()
            }
        }
    }
}