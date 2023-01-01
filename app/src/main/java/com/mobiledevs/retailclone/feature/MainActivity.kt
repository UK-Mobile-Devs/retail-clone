package com.mobiledevs.retailclone.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.mobiledevs.retailclone.ui.theme.RetailcloneTheme
import com.mobiledevs.retailclone.utils.Screen
import com.mobiledevs.retailclone.utils.SetupNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetailcloneTheme {
                //val screen by splashViewModel.startDestination
                val screen = Screen.Home.route
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    SetupNavigation(
                        startDestination = screen
                    )
                }
            }
        }
    }
}
