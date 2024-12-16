package ru.bellintegrator.android_at_lesson_2.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import android.widget.Toast

class MyBackgroundService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        showToast("Сервис связан")
        return Binder()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        showToast("Сервис отсоединен")
        return super.onUnbind(intent)
    }

    private var isRunning = false
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private var startTime: Long = 0L

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int,
    ): Int {
        showToast("Сервис запущен")
        Log.d("MyBackgroundService", "Сервис запущен")

        // Возвращаем START_STICKY, чтобы сервис перезапускался после завершения
        return START_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        isRunning = true
        handler = Handler(Looper.getMainLooper())
        runnable =
            object : Runnable {
                override fun run() {
                    if (isRunning) {
                        val elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000
                        val minutes = elapsedSeconds / 60
                        val seconds = elapsedSeconds % 60
                        logMessage(minutes, seconds) // Функция для записи сообщения в лог
                        handler.postDelayed(this, 5000) // Повторяем задачу каждые 5 секунд
                    }
                }
            }
        startTime = System.currentTimeMillis() // Фиксируем начальное время
        handler.post(runnable) // Начинаем выполнение задачи

        showToast("Сервис создан")
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
        handler.removeCallbacks(runnable) // Останавливаем задачу

        showToast("Сервис остановлен")
    }

    private fun logMessage(
        minutes: Long,
        seconds: Long,
    ) {
        showToast("Сервис работает")
        Log.d("MyBackgroundService", "Сервис работает: $minutes минут $seconds секунд.")
    }

    private fun showToast(message: String) {
        handler.post {
            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
        }
    }
}
