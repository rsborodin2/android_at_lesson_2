package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.pages.android_at_lesson

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.core.AllOf.allOf
import ru.bellintegrator.android_at_lesson_2.R

class KotlinFeaturesPageObject {
    fun scrollToAndCheckMultiplatformSupportIsDisplayed() {
        // Прокрутим до элемента с нужным текстом
        scrollToElementContainingText(R.id.kotlin_recycler_view, "Multiplatform Support")
        // Убедимся, что элемент отображается
        onView(allOf(withId(R.id.tv_function_name), withText("Multiplatform Support")))
            .check(matches(isDisplayed()))
    }

    // Метод для прокрутки до элемента с определенным текстом
    private fun scrollToElementContainingText(
        recyclerViewId: Int,
        text: String,
    ) {
        onView(withId(recyclerViewId))
            .perform(
                RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                    hasDescendant(withText(text)),
                ),
            )
    }
}
