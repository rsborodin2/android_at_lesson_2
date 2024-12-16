package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.tests

import android.content.Intent
import android.provider.Settings
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.Until
import io.qameta.allure.Description
import io.qameta.allure.kotlin.Allure.step
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.bellintegrator.android_at_lesson_2.R
import ru.bellintegrator.android_at_lesson_2.activity.MainActivity

@RunWith(AndroidJUnit4::class)
class ChangeBrightnessTest : BaseTest() {
    companion object {
        private const val PACKAGE_NAME_SETTINGS = "com.android.settings"
        private const val BRIGHTNESS_SLIDER_ID = "com.android.systemui:id/slider"
    }

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @Description("Изменение уровня яркости экрана")
    fun changeBrightness() {
        step("Открыть карточку Content Provider Example") {
            onView(withId(R.id.cardContentProviderExample)).perform(click())
        }

        step("Открыть настройки") {
            device.pressHome()
            device.wait(Until.hasObject(By.pkg(PACKAGE_NAME_SETTINGS)), 5000)
        }

        step("Запустить активность настроек дисплея") {
            val intent = Intent(Settings.ACTION_DISPLAY_SETTINGS)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }

        Thread.sleep(10_000)

        step("Найти ползунок яркости") {
            device.findObject(By.text("Brightness level")).click()
            device.wait(Until.hasObject(By.res(BRIGHTNESS_SLIDER_ID)), 10_000) // Увеличили время ожидания до 10 секунд
        }

        step("Установить новую позицию ползунка") {
            val brightnessSlider = device.findObject(By.res(BRIGHTNESS_SLIDER_ID))
            brightnessSlider?.swipe(Direction.LEFT, 0.8F)
        }

        step("Вернуться на главный экран") {
            device.pressHome()
        }

        step("Запустить главную активность") {
            val intent = context.packageManager.getLaunchIntentForPackage(context.packageName)
            intent?.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}
