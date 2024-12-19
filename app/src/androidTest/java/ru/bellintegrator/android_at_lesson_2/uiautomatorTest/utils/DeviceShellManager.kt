package ru.bellintegrator.android_at_lesson_2.uiautomatorTest.utils

import android.os.ParcelFileDescriptor
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import ru.bellintegrator.android_at_lesson_2.uiautomatorTest.enums.Packages
import java.io.BufferedReader
import java.io.InputStreamReader

object DeviceShellManager {
    private const val LOG_TAG = "DeviceShellManager"

    fun clearDataByPackage(packageName: String) {
        executeShellCommand("pm clear $packageName")

        // Надо ждать создания новых данных и перезапуск приложения, иначе может сломать следующий тест
        Thread.sleep(2000)

        executeShellCommand("pm grant $packageName ru.sberdevices.permission.NOTIFICATION_SERVICE")
        executeShellCommand("pm grant $packageName android.permission.ACCESS_COARSE_LOCATION")
        executeShellCommand("pm grant $packageName android.permission.ACCESS_FINE_LOCATION")
    }

    fun stopAllApp() {
        forceStopAppByPackage(Packages.ANDROID_SETTINGS.name)
        forceStopAppByPackage(Packages.ANDROID_AT_LESSON_2.name)
    }

    fun forceStopAppByPackage(packageName: String) {
        executeShellCommand("am force-stop $packageName")
    }

    fun isPackageInstalled(nameContains: String): Boolean {
        return executeShellCommand("pm list packages").find { it.contains(nameContains) } != null
    }

    fun executeShellCommand(cmd: String): List<String> {
        Log.i(LOG_TAG, "Выполнение команды: \"$cmd\"")
        try {
            val cmdDescriptor: ParcelFileDescriptor =
                InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand(cmd)
            return awaitTermination(cmdDescriptor)
        } catch (e: Exception) {
            Log.e(LOG_TAG, "Ошибка при выполнении команды \"$cmd\"")
            throw e
        }
    }

    private fun awaitTermination(parcelFileDescriptor: ParcelFileDescriptor): List<String> {
        val result: MutableList<String> = ArrayList()
        BufferedReader(
            InputStreamReader(
                ParcelFileDescriptor.AutoCloseInputStream(
                    parcelFileDescriptor,
                ),
            ),
        ).use { reader ->
            for (line in reader.readLines()) {
                result.add(line)
                Log.i(LOG_TAG, line)
            }
        }
        return result
    }
}
