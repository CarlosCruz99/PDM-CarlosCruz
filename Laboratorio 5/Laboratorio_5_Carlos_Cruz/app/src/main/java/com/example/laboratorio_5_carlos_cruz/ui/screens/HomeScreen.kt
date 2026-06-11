package com.example.laboratorio_5_carlos_cruz.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.laboratorio_5_carlos_cruz.data.local.entities.TaskEntity
import com.example.laboratorio_5_carlos_cruz.data.model.Task
import com.example.laboratorio_5_carlos_cruz.ui.view.TaskCard
import com.example.laboratorio_5_carlos_cruz.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: TaskViewModel,
    onBack: () -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    val tasks = viewModel.tasks.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = {Text("Tasks list")},
                navigationIcon = {
                    IconButton(
                        onClick = {onBack()}
                    ){
                        Icon(Icons.Default.ArrowBack, contentDescription = "Flecha de retorno")
                    }
                })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {showDialog = true}) {
                Icon(Icons.Default.Add, contentDescription = "Añadir")
            }
        }
    ) { paddingValues ->

        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(tasks.value){
                    task ->
                //Componente que es una card
                TaskCard(task)
                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        if (showDialog){
            CreateTask(
                onDismiss = { showDialog = false },
                onTaskCreated = { newTitle, newDescription, newDate, newIsCompleted ->
                    val newTask = TaskEntity(
                        title = newTitle,
                        description = newDescription,
                        endDate = newDate,
                        isCompleted = newIsCompleted
                    )
                    viewModel.addTask(newTask)
                    showDialog = false
                }
            )
        }

    }
}