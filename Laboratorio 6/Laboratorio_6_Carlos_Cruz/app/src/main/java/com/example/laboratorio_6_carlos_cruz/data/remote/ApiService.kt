package com.example.laboratorio_6_carlos_cruz.data.remote

import com.example.laboratorio_6_carlos_cruz.data.model.Meal
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/json/v1/1/search.php")
    suspend fun getMeals(@Query("s") query: String): List<Meal>
}