package com.example.novci2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.novci2.navigation.AppScreen
import com.example.novci2.ui.screens.HomeScreen
import com.example.novci2.ui.screens.PaymentScreen
import com.example.novci2.ui.theme.Novci2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Novci2Theme {

                val userID = 0
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = AppScreen.Home.route
                ) {
                    composable(AppScreen.Home.route) {
                        val vm: HomeViewModel = viewModel()
                        HomeScreen(
                            balance = vm.balanceCents,
                            transactions = vm.transactions,
                            onNavigateToPayment = { navController.navigate(AppScreen.Payment.route) }
                        )
                    }
                    composable(AppScreen.Payment.route) {
                        val vm: PaymentViewModel = viewModel()
                        PaymentScreen(
                            balanceCents = vm.balanceCents,
                            onConfirm = { amount -> println( "I confirmed $amount payment") },
                            onBack = { navController.popBackStack() })
                    }
                }
            }
        }
    }
}