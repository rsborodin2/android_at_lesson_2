package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.pages.android_at_lesson

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import ru.bellintegrator.android_at_lesson_2.R

class MainActivityPage {
    fun waitForLoaded() {
        onView(withId(R.id.cardContentProviderExample))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun openScreenSettingsActivity() {
        onView(withId(R.id.cardContentProviderExample))
            .perform(click())
    }
}
