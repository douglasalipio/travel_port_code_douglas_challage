package com.baseproject.douglas.util

import org.threeten.bp.Instant
import org.threeten.bp.LocalDate
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter

object DateHelper {
    private const val INPUT_FORMAT = "yyyy-MM-dd"
    private const val OUTPUT_FORMAT = "EEE, d MMM"

    fun toDateFormatted(timestamp: Long): String {
        val localDate = Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate()
        return formatDate(localDate.toString())
    }

    private fun formatDate(stringDate: String): String {
        val date = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern(INPUT_FORMAT))
        val outputFormat = DateTimeFormatter.ofPattern(OUTPUT_FORMAT)
        return date.format(outputFormat)
    }
}