package com.example.hotelsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.example.hotelsapp.presentation.navigation.NavGraph
import com.example.hotelsapp.presentation.theme.HotelsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HotelsAppTheme {
                Scaffold { padding ->
                    NavGraph(
                        navController = rememberNavController(),
                        padding = padding
                    )
                }
            }
        }
    }
}
