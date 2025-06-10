package com.jash.core.database.entity

import androidx.room.TypeConverter
import java.time.ZonedDateTime

class ZonedDateTimeConverter {
    @TypeConverter
    fun fromZonedDateTime(date: ZonedDateTime?): String? {
        return date?.toString()
    }

    @TypeConverter
    fun toZonedDateTime(string: String?): ZonedDateTime? {
        return string?.let { ZonedDateTime.parse(it) }
    }
}