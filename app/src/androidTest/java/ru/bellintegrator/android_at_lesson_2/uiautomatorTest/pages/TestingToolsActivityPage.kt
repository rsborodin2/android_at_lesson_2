package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.pages

import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Assert

class TestingToolsActivityPage(private val device: UiDevice) {
    fun verifyBlocksExist() {
        device.wait(Until.hasObject(By.text("Espresso")), TIMEOUT)
        Assert.assertNotNull(device.findObject(By.text("Espresso")))

        device.wait(Until.hasObject(By.text("UI Automator")), TIMEOUT)
        Assert.assertNotNull(device.findObject(By.text("UI Automator")))

        device.wait(Until.hasObject(By.text("Robotium")), TIMEOUT)
        Assert.assertNotNull(device.findObject(By.text("Robotium")))
    }

    fun clickEspressoDetailsButton() {
        device.clickAndWaitForNewWindow("com.example:id/buttonEspressoDetails", TIMEOUT)
    }

    fun clickUiAutomatorDetailsButton() {
        device.clickAndWaitForNewWindow("com.example:id/buttonUiAutomatorDetails", TIMEOUT)
    }

    fun verifyDetailsOpened(text: String) {
        device.wait(Until.hasObject(By.text(text)), TIMEOUT)
        Assert.assertNotNull(device.findObject(By.text(text)))
    }

    private fun UiDevice.clickAndWaitForNewWindow(
        resId: String,
        timeout: Long,
    ) {
        val currentPackage = currentPackageName
        findObject(By.res(resId)).click()
        wait(Until.hasObject(By.pkg(currentPackage).depth(0)), timeout)
    }

    companion object {
        const val TIMEOUT = 3000L
    }
}
