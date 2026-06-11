package com.example.laboratorio_5_carlos_cruz.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio_5_carlos_cruz.ui.screens.ButtonScreen
import com.example.laboratorio_5_carlos_cruz.ui.screens.CreateTask
import com.example.laboratorio_5_carlos_cruz.ui.screens.HomeScreen
import com.example.laboratorio_5_carlos_cruz.viewmodel.TaskViewModel

@Composable
fun TaskApp(viewModel: TaskViewModel){
    val navController = rememberNavController()

    NavHost(navController=navController, startDestination="button_screen"){
        composable("button_screen") {
            ButtonScreen(
                onNavigateToHome = {navController.navigate("home_screen")}
            )
        }

        composable("home_screen") {
            HomeScreen(
                viewModel=viewModel,
                onBack = {navController.popBackStack()}
            )
        }
    }
}