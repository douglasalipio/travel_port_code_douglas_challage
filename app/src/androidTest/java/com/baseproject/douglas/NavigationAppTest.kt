package com.baseproject.douglas

import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.NoActivityResumedException
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.baseproject.douglas.feature.weather.view.WeatherActivity
import org.junit.Assert.assertTrue

import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class NavigationAppTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(WeatherActivity::class.java)

    @Test
    fun pressBackExitApp() {
        try {
            pressBack()
            fail("Should kill the app and throw an exception")
        } catch (e: NoActivityResumedException) {
            assertTrue(true)
        }
    }
}