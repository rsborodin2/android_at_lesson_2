package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.tests

import android.content.Context
import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import ru.bellintegrator.android_at_lesson_2.uiautomatorTest.pages.MainActivityPage

@RunWith(AndroidJUnit4::class)
open class BaseTest {
    protected lateinit var device: UiDevice
    protected lateinit var mainActivityPage: MainActivityPage
    protected lateinit var context: Context

    @Before
    open fun setup() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        mainActivityPage = MainActivityPage()

        // Получаем контекст приложения
        context = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @After
    fun tearDown() {
        device.pressBack()
        device.pressHome()
    }

    fun openActivity(
        context: Context,
        action: String,
    ) {
        val intent = Intent(action)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    fun openActivity(
        context: Context,
        action: String,
        clazz: Class<*>,
    ) {
        val intent = Intent(action)
        intent.setClassName(context, clazz.canonicalName) // Установите класс активности
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}
