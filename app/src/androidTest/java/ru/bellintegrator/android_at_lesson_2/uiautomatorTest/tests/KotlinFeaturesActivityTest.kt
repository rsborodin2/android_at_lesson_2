package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.bellintegrator.android_at_lesson_2.activity.KotlinFeaturesActivity
import ru.bellintegrator.android_at_lesson_2.uiautomatorTest.pages.android_at_lesson.KotlinFeaturesPageObject
import java.io.IOException

@RunWith(AndroidJUnit4ClassRunner::class)
class KotlinFeaturesActivityTest {
    @Before
    fun setUp() {
        disableAnimations()
    }

    @After
    fun tearDown() {
        enableAnimations()
    }

    @get:Rule
    val activityRule = ActivityScenarioRule(KotlinFeaturesActivity::class.java)

    private val pageObject = KotlinFeaturesPageObject()

    @Test
    fun testScrollToAndCheckMultiplatformSupportInDescription() {
        pageObject.scrollToAndCheckMultiplatformSupportIsDisplayed()
    }

    private fun disableAnimations() {
        try {
            val uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
            uiDevice.executeShellCommand("settings put global window_animation_scale 0")
            uiDevice.executeShellCommand("settings put global transition_animation_scale 0")
            uiDevice.executeShellCommand("settings put global animator_duration_scale 0")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun enableAnimations() {
        try {
            val uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
            uiDevice.executeShellCommand("settings put global window_animation_scale 1")
            uiDevice.executeShellCommand("settings put global transition_animation_scale 1")
            uiDevice.executeShellCommand("settings put global animator_duration_scale 1")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
