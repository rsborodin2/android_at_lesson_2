package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.pages.android_at_lesson

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.allOf
import ru.bellintegrator.android_at_lesson_2.R

class SettingsPage {
    fun verifyBrightnessLabel() {
        onView(withId(R.id.brightness_label)).check(matches(allOf(isDisplayed(), withText("Brightness:"))))
    }

    fun verifyBrightnessValue(expectedValue: String) {
        onView(withId(R.id.brightness_value)).check(matches(allOf(isDisplayed(), withText(expectedValue))))
    }
}
