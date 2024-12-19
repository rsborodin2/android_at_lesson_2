@file:Suppress("unused")

package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.utils

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import io.qameta.allure.kotlin.Allure
import ru.bellintegrator.android_at_lesson_2.uiautomatorTest.utils.DeviceUtil.device
import java.io.ByteArrayOutputStream
import java.util.regex.Pattern

object DeviceUtil {
    val device: UiDevice
        get() = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    fun dumpWindowHierarchyToAllure() {
        repeat(5) {
            try {
                dump()
                return
            } catch (exception: Exception) {
                Thread.sleep(500)
            }
        }
    }

    fun changeAnimationValue(value: Float) {
        device.executeShellCommand("settings put global animator_duration_scale $value")
    }

    fun getDumpString(): String {
        val stream = ByteArrayOutputStream()
        device.dumpWindowHierarchy(stream)

        return stream.toString()
    }

    private fun dump() {
        Allure.attachment("Текущий Window dump", getDumpString())
    }

    fun getDeviceProperty(propertyName: String): String {
        val result =
            getDeviceProperties().filterKeys {
                it.equals(
                    propertyName,
                    ignoreCase = true,
                )
            }
        if (result.isEmpty()) {
            throw Exception("Проперть не найдена: $propertyName")
        }
        if (result.size != 1) {
            throw Exception("По запросу '$propertyName' найдено больше 1 проперти")
        }
        return result[propertyName]!!
    }

    fun getDeviceProperty(propertyName: Pattern): String {
        val result =
            getDeviceProperties().filterKeys { it.matches(propertyName.toRegex()) }
        if (result.isEmpty()) {
            throw Exception("Проперть не найдена: $propertyName")
        }
        if (result.size != 1) {
            throw Exception("По запросу '$propertyName' найдено больше 1 проперти")
        }
        return result.values.first()
    }

    private fun getDeviceProperties(): Map<String, String> {
        return DeviceShellManager
            .executeShellCommand("getprop")
            .joinToString("\n")
            .split("]\n")
            .filter { it.isNotEmpty() }.associate { row ->
                val splitted =
                    row.split("]:").map {
                        it.replace("[", "").replace("]", "").trim()
                    }
                if (splitted.size != 2) {
                    throw Exception("Не удалось правильно раcпарсить данные для '$row'")
                }
                splitted[0] to splitted[1]
            }
    }
}

fun pressHome(
    timeout: Long = 500,
    times: Int = 1,
) {
    repeat(times) {
        device.pressHome()
        Thread.sleep(timeout)
    }
}

fun pressHomeLong(timeout: Long = 500) {
    device.executeShellCommand("input keyevent --longpress 3")
    Thread.sleep(timeout)
}

fun pressBACK(
    timeout: Long = 500,
    times: Int = 1,
) {
    repeat(times) {
        device.pressBack()
        Thread.sleep(timeout)
    }
}
