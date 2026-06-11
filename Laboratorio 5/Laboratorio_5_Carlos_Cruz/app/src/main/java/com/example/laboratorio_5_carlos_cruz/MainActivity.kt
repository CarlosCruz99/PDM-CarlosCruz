package com.example.laboratorio_5_carlos_cruz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.laboratorio_5_carlos_cruz.ui.navigation.TaskApp
import com.example.laboratorio_5_carlos_cruz.ui.theme.Laboratorio_5_Carlos_CruzTheme
import com.example.laboratorio_5_carlos_cruz.viewmodel.MenuViewModelFactory
import com.example.laboratorio_5_carlos_cruz.viewmodel.TaskViewModel
import kotlin.getValue

class MainActivity : ComponentActivity() {
    private val viewModel: TaskViewModel by viewModels {
        MenuViewModelFactory((application as TaskApp).database.taskDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio_5_Carlos_CruzTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TaskApp(viewModel= viewModel)
                }
            }
        }
    }
}