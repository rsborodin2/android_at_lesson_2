package ru.bellintegrator.android_at_lesson_2.activity

import android.content.ContentResolver
import android.os.Bundle
import android.provider.Settings
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.bellintegrator.android_at_lesson_2.R

class ScreenSettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_settings)

        // Найти элементы интерфейса
        val brightnessLabel: TextView = findViewById(R.id.brightness_label)
        val brightnessValue: TextView = findViewById(R.id.brightness_value)
        val timeoutLabel: TextView = findViewById(R.id.timeout_label)
        val timeoutValue: TextView = findViewById(R.id.timeout_value)

        // Получить ContentResolver
        val resolver: ContentResolver = contentResolver

        // Чтение настроек яркости экрана
        try {
            val brightness = Settings.System.getInt(resolver, Settings.System.SCREEN_BRIGHTNESS)
            brightnessValue.text = "$brightness%"
        } catch (e: Settings.SettingNotFoundException) {
            brightnessValue.text = "Ошибка чтения настройки яркости."
        }

        // Чтение настроек времени автоматической блокировки экрана
        try {
            // val timeout = Settings.System.getInt(resolver, Settings.System.SCREEN_OFF_TIMEOUT) / 60_000
            val timeout = Settings.System.getInt(resolver, Settings.System.SCREEN_OFF_TIMEOUT)
            "${timeout / 60_000} минут".also { timeoutValue.text = it }
        } catch (e: Settings.SettingNotFoundException) {
            timeoutValue.text = "Ошибка чтения настройки времени блокировки экрана."
        }
    }
}
