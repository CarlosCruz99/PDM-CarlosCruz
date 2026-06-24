package com.example.laboratorio_6_carlos_cruz.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio_6_carlos_cruz.data.model.Meal
import com.example.laboratorio_6_carlos_cruz.data.remote.RetrofitInstance
import kotlinx.coroutines.launch

class MealViewModel : ViewModel() {

    var meals by mutableStateOf<List<Meal>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun loadMeals() {

        viewModelScope.launch {

            isLoading = true

            try {

                meals = RetrofitInstance
                    .api
                    .getMeals("")

            } catch (e: Exception) {
                e.printStackTrace()

            } finally {
                isLoading = false
            }

        }
    }
}