package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.pages

import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until

class MainActivityPage(private val device: UiDevice) {
    fun openUiElementsActivity() {
        device.findObject(By.res("$PACKAGE_NAME:id/cardUiElements"))
            .clickAndWaitForNewWindow(LAUNCH_TIMEOUT)
    }

    fun openTestingToolsActivity() {
        device.findObject(By.res("$PACKAGE_NAME:id/cardTestingTools"))
            .clickAndWaitForNewWindow(LAUNCH_TIMEOUT)
    }

    fun openScreenSettingsActivity() {
        device.findObject(By.res("$PACKAGE_NAME:id/cardContentProviderExample"))
            .clickAndWaitForNewWindow(LAUNCH_TIMEOUT)
    }

    fun openCurrencyActivity() {
        device.findObject(By.res("$PACKAGE_NAME:id/cardCurrency"))
            .clickAndWaitForNewWindow(LAUNCH_TIMEOUT)
    }

    fun openTaskActivity() {
        device.findObject(By.res("$PACKAGE_NAME:id/cardTask"))
            .clickAndWaitForNewWindow(LAUNCH_TIMEOUT)
    }

    fun openComplexActivity() {
        device.findObject(By.res("$PACKAGE_NAME:id/cardComplexLayout"))
            .clickAndWaitForNewWindow(LAUNCH_TIMEOUT)
    }

    fun openLifecycleActivity() {
        device.findObject(By.res("$PACKAGE_NAME:id/cardLifeCycle"))
            .clickAndWaitForNewWindow(LAUNCH_TIMEOUT)
    }

    fun openDeeplinkActivity() {
        device.findObject(By.res("$PACKAGE_NAME:id/cardOpenDeeplink"))
            .clickAndWaitForNewWindow(LAUNCH_TIMEOUT)
    }

    fun startMyBackgroundService() {
        device.findObject(By.res("$PACKAGE_NAME:id/cardService"))
            .click()
    }

    fun startForegroundService() {
        device.findObject(By.res("$PACKAGE_NAME:id/cardForegroundService"))
            .click()
    }

    private fun UiObject2.clickAndWaitForNewWindow(timeout: Long) {
        this.click()
        device.wait(Until.hasObject(By.pkg(device.currentPackageName).depth(0)), timeout)
    }

    companion object {
        const val LAUNCH_TIMEOUT = 5000L
        const val PACKAGE_NAME = "ru.bellintegrator.android_at_lesson_2"
    }
}
