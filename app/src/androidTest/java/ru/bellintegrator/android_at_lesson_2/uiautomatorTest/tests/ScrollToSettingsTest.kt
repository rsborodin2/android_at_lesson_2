package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.tests

import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import org.junit.Test

class ScrollToSettingsTest {
    val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    companion object {
        const val SETTINGS_PACKAGE = "com.android.settings"
        const val LAUNCH_TIMEOUT = 5000L
        const val ABOUT_DEVICE_TEXT = "About emulated device"
    }

    @Test
    fun scrollToAboutDevice() {
        // Открываем настройки
        device.pressHome()
        val intent =
            Intent(Intent.ACTION_MAIN).apply {
                addCategory(Intent.CATEGORY_LAUNCHER)
                setPackage(SETTINGS_PACKAGE)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) // Добавляем этот флаг
            }
        InstrumentationRegistry.getInstrumentation().context.startActivity(intent)

        val settingsList = UiScrollable(UiSelector().scrollable(true))
        settingsList.setAsVerticalList()

        // Прокручиваем список вниз до элемента "Об устройстве"
        val aboutDeviceItem =
            settingsList.getChildByText(
                UiSelector().className(android.widget.TextView::class.java.name),
                ABOUT_DEVICE_TEXT,
            )

        if (!aboutDeviceItem.exists()) {
            throw RuntimeException("Не удалось найти элемент 'Об устройстве'")
        }

        aboutDeviceItem.clickAndWaitForNewWindow(LAUNCH_TIMEOUT)
        device.pressBack()
        device.pressBack()
    }
}
