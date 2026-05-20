package com.example.laboratorio_4_carlos_cruz.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio_4_carlos_cruz.ui.screens.ButtonScreen
import com.example.laboratorio_4_carlos_cruz.ui.screens.CreateTask
import com.example.laboratorio_4_carlos_cruz.ui.screens.HomeScreen
import com.example.laboratorio_4_carlos_cruz.viewmodel.TaskViewModel

@Composable
fun TaskApp(){
    val navController = rememberNavController()
    val taskViewModel: TaskViewModel= viewModel()

    NavHost(navController=navController, startDestination="button_screen"){
        composable("button_screen") {
            ButtonScreen(
                onNavigateToHome = {navController.navigate("home_screen")}
            )
        }

        composable("home_screen") {
            HomeScreen(
                viewModel=taskViewModel,
                onBack = {navController.popBackStack()}
//                onNavigateToCreate = {navController.navigate("create_task")}
            )
        }

//        composable("create_task"){
//            CreateTask(
//                viewModel=taskViewModel,
//                onDismiss = {navController.popBackStack()}
//            )
//        }
    }
}