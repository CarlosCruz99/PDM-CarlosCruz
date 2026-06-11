package com.example.laboratorio_5_carlos_cruz.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.laboratorio_5_carlos_cruz.data.local.entities.TaskEntity

@Composable
fun TaskCard(
    task: TaskEntity,
    onDeleteTask: (TaskEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Título: " + task.title,
                    style = MaterialTheme.typography.titleMedium
                )

                if (task.description.isNotBlank()) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Descripción: " + task.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Text(
                    text = "Fecha: " + task.endDate.toString()
                )
            }
            IconButton(onClick = {onDeleteTask(task)}) {
                Icon(Icons.Default.Delete, contentDescription = "Eliminar Task")
            }
        }

    }
}