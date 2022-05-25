package com.danp.proyecto_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.danp.proyecto_01.ui.theme.Proyecto_01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_01Theme {
                MainScreen()
            }
        }
    }
}

