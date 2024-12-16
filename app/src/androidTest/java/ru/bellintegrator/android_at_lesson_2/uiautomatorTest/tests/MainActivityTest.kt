package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.tests

import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import org.junit.Test
import ru.bellintegrator.android_at_lesson_2.uiautomatorTest.pages.MainActivityPage

class MainActivityTest : BaseTestFromActivity() {
    @Test
    fun testOpenUiElementsActivity() {
        mainActivityPage.openUiElementsActivity()
        device.wait(
            Until.hasObject(By.pkg(MainActivityPage.PACKAGE_NAME).depth(0)),
            MainActivityPage.LAUNCH_TIMEOUT,
        )
        assert(device.currentPackageName == MainActivityPage.PACKAGE_NAME)
    }

    @Test
    fun testOpenTestingToolsActivity() {
        mainActivityPage.openTestingToolsActivity()
        device.wait(
            Until.hasObject(By.pkg(MainActivityPage.PACKAGE_NAME).depth(0)),
            MainActivityPage.LAUNCH_TIMEOUT,
        )
        assert(device.currentPackageName == MainActivityPage.PACKAGE_NAME)
    }

    @Test
    fun testOpenScreenSettingsActivity() {
        mainActivityPage.openScreenSettingsActivity()
        device.wait(
            Until.hasObject(By.pkg(MainActivityPage.PACKAGE_NAME).depth(0)),
            MainActivityPage.LAUNCH_TIMEOUT,
        )
        assert(device.currentPackageName == MainActivityPage.PACKAGE_NAME)
    }

    @Test
    fun testOpenCurrencyActivity() {
        mainActivityPage.openCurrencyActivity()
        device.wait(
            Until.hasObject(By.pkg(MainActivityPage.PACKAGE_NAME).depth(0)),
            MainActivityPage.LAUNCH_TIMEOUT,
        )
        assert(device.currentPackageName == MainActivityPage.PACKAGE_NAME)
    }

    @Test
    fun testOpenTaskActivity() {
        mainActivityPage.openTaskActivity()
        device.wait(
            Until.hasObject(By.pkg(MainActivityPage.PACKAGE_NAME).depth(0)),
            MainActivityPage.LAUNCH_TIMEOUT,
        )
        assert(device.currentPackageName == MainActivityPage.PACKAGE_NAME)
    }

    @Test
    fun testOpenComplexActivity() {
        mainActivityPage.openComplexActivity()
        device.wait(
            Until.hasObject(By.pkg(MainActivityPage.PACKAGE_NAME).depth(0)),
            MainActivityPage.LAUNCH_TIMEOUT,
        )
        assert(device.currentPackageName == MainActivityPage.PACKAGE_NAME)
    }

    @Test
    fun testOpenLifecycleActivity() {
        mainActivityPage.openLifecycleActivity()
        device.wait(
            Until.hasObject(By.pkg(MainActivityPage.PACKAGE_NAME).depth(0)),
            MainActivityPage.LAUNCH_TIMEOUT,
        )
        assert(device.currentPackageName == MainActivityPage.PACKAGE_NAME)
    }

    @Test
    fun testOpenDeeplinkActivity() {
        mainActivityPage.openDeeplinkActivity()
        device.wait(
            Until.hasObject(By.pkg(MainActivityPage.PACKAGE_NAME).depth(0)),
            MainActivityPage.LAUNCH_TIMEOUT,
        )
        assert(device.currentPackageName == MainActivityPage.PACKAGE_NAME)
    }

    @Test
    fun testStartMyBackgroundService() {
        mainActivityPage.startMyBackgroundService()
        // Проверяем, запущен ли сервис
        // Можно добавить проверку через логирование или другие механизмы
    }

    @Test
    fun testStartForegroundService() {
        mainActivityPage.startForegroundService()
        // Проверяем, запущен ли сервис
        // Можно добавить проверку через логирование или другие механизмы
    }
}
