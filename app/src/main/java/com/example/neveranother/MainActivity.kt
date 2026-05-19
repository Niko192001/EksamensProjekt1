package com.example.neveranother

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.neveranother.navigation.AppNavGraph
import com.example.neveranother.screens.KurvScreen
import com.example.neveranother.ui.theme.NeverAnotherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // viewmodel
        setContent {
            NeverAnotherTheme {
                Surface {
                    AppNavGraph()
                }
            }


        }
    }
}