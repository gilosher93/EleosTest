package com.gilosher.eleostest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gilosher.eleostest.home.HomeScreen
import com.gilosher.eleostest.home.HomeViewModel
import com.gilosher.eleostest.ui.theme.EleosTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EleosTestTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screens.Home.name
                ) {
                    composable(route = Screens.Home.name) {
                        val viewModel = viewModel<HomeViewModel>()
                        val pageState by viewModel.pageState.collectAsStateWithLifecycle()
                        HomeScreen(
                            pageState = pageState,
                            onEvent = viewModel::onEvent
                        )
                    }
                }
            }
        }
    }
}

enum class Screens {
    Home
}