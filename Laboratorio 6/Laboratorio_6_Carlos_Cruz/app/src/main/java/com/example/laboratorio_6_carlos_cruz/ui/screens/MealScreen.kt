package com.example.laboratorio_6_carlos_cruz.ui.screens

import android.app.ProgressDialog.show
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.laboratorio_6_carlos_cruz.viewmodel.MealViewModel
import coil.compose.AsyncImage

@Composable
fun MealScreen(
    viewModel: MealViewModel = viewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.loadMeals()
    }

    when {

        viewModel.isLoading -> {
            CircularProgressIndicator()
        }

        else -> {

            LazyColumn() {

                items(viewModel.meals) { meal ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = meal.strMeal
                            )

                            Text(
                                text = meal.strCategory
                            )

                            Text(
                                text = meal.strArea
                            )

                            AsyncImage(
                                model = meal.strMealThumb,
                                contentDescription = meal.strMeal,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize(),
                                placeholder = ColorPainter(Color.DarkGray)
                            )

                        }
                    }
                }
            }
        }
    }
}