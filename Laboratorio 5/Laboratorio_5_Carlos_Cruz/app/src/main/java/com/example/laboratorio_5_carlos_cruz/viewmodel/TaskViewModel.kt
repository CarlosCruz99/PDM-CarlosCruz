package com.example.laboratorio_5_carlos_cruz.viewmodel

import android.R.attr.description
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.laboratorio_5_carlos_cruz.data.local.TaskDao
import com.example.laboratorio_5_carlos_cruz.data.local.entities.TaskEntity
import kotlinx.coroutines.NonCancellable.isCompleted
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Date
import kotlin.jvm.java

class TaskViewModel(private val dao: TaskDao): ViewModel() {
    val tasks: StateFlow<List<TaskEntity>> = dao.getAllTasks()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addTask(task: TaskEntity){
        viewModelScope.launch {
            dao.insertTask(task)
        }
    }

    fun deleteTask(task: TaskEntity){
        viewModelScope.launch {
            dao.deleteTask(task)
        }
    }
}

class MenuViewModelFactory(private val dao: TaskDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TaskViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
