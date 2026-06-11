package com.example.laboratorio_5_carlos_cruz.data.local

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun dateToString(date: Date?): String{
        return date.toString()
    }

    @TypeConverter
    fun fromDate(value: String?): Date?{
        return value?.let {Date(it)}
    }
}