package ru.bellintegrator.android_at_lesson_2.service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log

class MyBackgroundService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
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
        // Здесь вы можете запустить вашу логику работы в фоне
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
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
        handler.removeCallbacks(runnable) // Останавливаем задачу
    }

    private fun logMessage(
        minutes: Long,
        seconds: Long,
    ) {
        Log.d("MyBackgroundService", "Сервис работает: $minutes минут $seconds секунд.")
    }
}
