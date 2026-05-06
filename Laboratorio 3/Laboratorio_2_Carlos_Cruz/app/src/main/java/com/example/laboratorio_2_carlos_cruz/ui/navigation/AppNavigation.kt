package com.example.laboratorio_2_carlos_cruz.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio_2_carlos_cruz.ui.screens.home.HomeScreen
import com.example.laboratorio_2_carlos_cruz.ui.screens.list.NameListScreen
import com.example.laboratorio_2_carlos_cruz.ui.screens.sensor.SensorScreen
import java.util.jar.Attributes

@Composable
fun Labo3App(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_screen"){
        composable("home_screen"){
            HomeScreen(
                onNavigateToList = {navController.navigate("name_list_screen")},
                onNavigateToSensor = {navController.navigate("sensor_screen")}
            )
        }

        composable("name_list_screen"){
            NameListScreen(
                onBack = {navController.popBackStack()}
            )
        }

        composable("sensor_screen"){
            SensorScreen(
                onBack = {navController.popBackStack()}
            )
        }
    }
}