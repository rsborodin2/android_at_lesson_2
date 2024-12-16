package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.tests

import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Before
import ru.bellintegrator.android_at_lesson_2.uiautomatorTest.pages.MainActivityPage

open class BaseTestFromActivity : BaseTest() {
    @Before
    override fun setup() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        mainActivityPage = MainActivityPage(device)

        // Получаем контекст приложения
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Запускаем главную активность
        val intent = context.packageManager.getLaunchIntentForPackage(context.packageName)
        intent?.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)

        // Ожидаем загрузки главной активности
        device.wait(
            Until.hasObject(By.pkg(context.packageName).depth(0)),
            MainActivityPage.LAUNCH_TIMEOUT,
        )
    }
}
