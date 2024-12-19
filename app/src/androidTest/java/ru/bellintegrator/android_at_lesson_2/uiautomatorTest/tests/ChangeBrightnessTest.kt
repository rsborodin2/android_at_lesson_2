package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.tests

import android.provider.Settings
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.qameta.allure.kotlin.Allure.step
import io.qameta.allure.kotlin.Description
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.bellintegrator.android_at_lesson_2.activity.MainActivity
import ru.bellintegrator.android_at_lesson_2.uiautomatorTest.pages.MainActivityPage
import ru.bellintegrator.android_at_lesson_2.uiautomatorTest.pages.SettingsPage
import ru.bellintegrator.android_at_lesson_2.uiautomatorTest.pages.system.BrightnessPage

@RunWith(AndroidJUnit4::class)
class ChangeBrightnessTest : BaseTest() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @Description("Изменение уровня яркости экрана")
    fun changeBrightness() {
        step("Запустить активность настроек дисплея") {
            openActivity(context, Settings.ACTION_DISPLAY_SETTINGS)
        }
        val brightnessPosition =
            step("Найти и установить новую позицию ползунка яркости") {
                with(BrightnessPage()) {
                    openBrightnessLevel()
                    setNewPosition()
                }
            }
        step("Вернуться на главный экран") {
            device.pressHome()
        }
        step("Перейти в экран демо контент-провайдера") {
            openActivity(context, context.packageName, MainActivity::class.java)
            with(MainActivityPage()) {
                waitForLoaded()
                openScreenSettingsActivity()
                SettingsPage().verifyBrightnessLabel()
            }
            step("Сравнить новое значение яркости") {
                SettingsPage().verifyBrightnessValue(brightnessPosition)
            }
        }
    }
}
