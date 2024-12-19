package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.pages.base

import androidx.test.espresso.action.ViewActions.click
import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Assert.assertTrue
import ru.bellintegrator.android_at_lesson_2.uiautomatorTest.utils.DeviceUtil

open class BaseUIAutomatorPage {
    protected val device: UiDevice = DeviceUtil.device

    protected fun waitForElementByText(
        text: String,
        timeout: Long = 10000L,
    ) {
        assertTrue(device.wait(Until.hasObject(By.text(text)), timeout))
    }

    protected fun findAndClickElementByText(text: String) {
        val element = device.findObject(By.text(text))
        element.click()
    }

    protected fun waitForElementByResId(
        resId: String,
        timeout: Long = 10000L,
    ) {
        assertTrue(device.wait(Until.hasObject(By.res(resId)), timeout))
    }

    protected fun waitForElement(
        selector: BySelector,
        timeout: Long = 10000L,
    ) {
        assertTrue(device.wait(Until.hasObject(selector), timeout))
    }
}
