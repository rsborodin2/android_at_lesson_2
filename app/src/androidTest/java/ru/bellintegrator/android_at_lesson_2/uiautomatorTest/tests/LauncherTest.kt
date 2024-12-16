package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

class LauncherTest : BaseTestFromActivity() {
    @RunWith(AndroidJUnit4::class)
    class LauncherTest {
        private lateinit var device: UiDevice

        @Before
        fun setUp() {
            // Получаем экземпляр устройства
            device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

            // Очищаем все недавние задачи
            device.pressRecentApps()
            clearRecentTasks()
            device.pressHome()
        }

        @Test
        fun launchAppFromLauncher() {
            // Находим иконку приложения в лаунчере
            openAppDrawer()
            Thread.sleep(10_000)
            val appIcon = device.findObject(UiSelector().descriptionContains("Bell AT"))

            if (appIcon.exists()) {
                // Нажимаем на иконку приложения
                appIcon.clickAndWaitForNewWindow()
                Thread.sleep(10_000)

                // Ожидаем, пока приложение загрузится
                device.waitForIdle()
            }
        }

        private fun clearRecentTasks() {
            // Определяем координаты для свайпа вверх-вниз
            val displaySize = device.displaySizeDp
            val centerX = displaySize.x / 2
            val fromY = (displaySize.y * 0.8).toInt()
            val toY = (displaySize.y * 0.2).toInt()

            // Выполняем свайп от нижней части экрана до верхней
            device.swipe(centerX, fromY, centerX, toY, 10)
        }

        private fun openAppDrawer() {
            // Открыть ящик приложений (полный свайп сверху вниз)
            val displaySize = device.displaySizeDp
            val centerX = displaySize.x / 2
            val fromY = (displaySize.y * 0.90).toInt()
            val toY = (displaySize.y * 0.15).toInt()

            device.swipe(centerX, fromY, centerX, toY, 10)
        }
    }
}
