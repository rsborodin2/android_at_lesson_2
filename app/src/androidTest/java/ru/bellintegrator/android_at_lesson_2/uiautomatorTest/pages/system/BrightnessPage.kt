package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.pages.system

import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.Direction
import ru.bellintegrator.android_at_lesson_2.uiautomatorTest.pages.base.BaseUIAutomatorPage
import kotlin.random.Random

class BrightnessPage : BaseUIAutomatorPage() {
    private val brightnessSlider: BySelector = By.res("com.android.systemui:id/slider")
    private val brightnessLevel: BySelector = By.text("Brightness level")
    private val brightnessLevelValue: BySelector = By.res("android:id/summary").textContains("%")

    fun openBrightnessLevel() {
        waitForElementByText("Brightness level")
        findAndClickElementByText("Brightness level")
        waitForElement(brightnessSlider)
    }

    fun setNewPosition(swipePercentage: Float = getRandomSwipePercentage()): String {
        val slider = device.findObject(brightnessSlider)
        slider.swipe(Direction.LEFT, swipePercentage)
        device.pressBack()
        return device.findObject(brightnessLevelValue).text
    }

    private fun getRandomSwipePercentage(): Float {
        val randomPercent = Random.nextFloat() * 100
        return randomPercent / 100f
    }
}
