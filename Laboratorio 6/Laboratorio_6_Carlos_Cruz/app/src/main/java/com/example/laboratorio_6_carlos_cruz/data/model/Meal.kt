package com.example.laboratorio_6_carlos_cruz.data.model

data class TheMealDBResponse(
    val meal: Meal
)

data class Meal(
    val idMeal: Int,
    val strMeal: String,
    val strCategory: String,
    val strArea: String,
    val strMealThumb: String
)