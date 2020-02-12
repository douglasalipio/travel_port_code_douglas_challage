package com.baseproject.douglas.util

import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

object DateHelper {
    private const val OUTPUT_FORMAT = "EEE, d MMM"
    private const val UTC_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"

    fun toDateFormat(utcStringDate: String): String {
        val localDate = LocalDate.parse(utcStringDate, DateTimeFormatter.ofPattern(UTC_DATE_FORMAT))
        return localDate.format(DateTimeFormatter.ofPattern(OUTPUT_FORMAT))
    }
}