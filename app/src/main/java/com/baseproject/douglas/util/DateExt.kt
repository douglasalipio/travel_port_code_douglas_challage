package com.baseproject.douglas.util

import org.threeten.bp.DateTimeUtils
import org.threeten.bp.Instant

fun toLocalDate(timesStamp: Long) = Instant.ofEpochMilli(timesStamp)