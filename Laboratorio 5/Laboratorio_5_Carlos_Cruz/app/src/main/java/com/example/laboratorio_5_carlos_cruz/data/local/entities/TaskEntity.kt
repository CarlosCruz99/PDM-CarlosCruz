package com.example.laboratorio_5_carlos_cruz.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.laboratorio_5_carlos_cruz.data.local.DateConverter
import java.util.Date

@Entity(tableName = "tasks")
@TypeConverters(DateConverter::class)
data class TaskEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val endDate: Date,
    val isCompleted: Boolean
)