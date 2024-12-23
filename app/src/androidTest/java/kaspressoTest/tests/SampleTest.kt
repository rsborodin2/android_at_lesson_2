package kaspressoTest.tests

import androidx.test.core.app.takeScreenshot
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.components.kautomator.system.UiSystem.click
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.android.allureScreenshot
import io.qameta.allure.kotlin.Allure.step
import io.qameta.allure.kotlin.junit4.DisplayName
import kaspressoTest.pages.KotlinFeaturesScreen
import kaspressoTest.pages.MainScreen
import org.junit.Rule
import org.junit.Test
import ru.bellintegrator.android_at_lesson_2.activity.MainActivity



class SampleTest: TestCase( ) {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    @DisplayName("проверка добавляния задачи в Room")
    fun checkScroollTest(): Unit =
        step("Open Simple Screen") {
            MainScreen {
                cardKotlinFeaturesButton {
                    isVisible()
                    click()
                }
            }
            KotlinFeaturesScreen {
                kotlinFeaturesRecyclerView {
                    isVisible()
                    childWith<KotlinFeaturesScreen.KotlinFeatureItemScreen> {
                        withDescendant {
                            withText("Multiplatform Support")
                        }
                    }.scrollTo()

                }
            }

        }
}