package com.baseproject.douglas

import com.baseproject.douglas.util.DateHelper
import org.junit.Assert.assertEquals
import org.junit.Test

class DateHelperTest {

    @Test
    fun `should return a valid date`() {
        val stringDate = "2020-02-15 03:00:00"
        val expectedDate = "Sat, 15 Feb"
        val date = DateHelper.toDateFormat(stringDate)
        assertEquals(expectedDate, date)
    }
}