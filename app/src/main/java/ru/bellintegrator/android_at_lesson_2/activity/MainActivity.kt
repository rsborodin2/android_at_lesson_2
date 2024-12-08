package ru.bellintegrator.android_at_lesson_2.activity

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import ru.bellintegrator.android_at_lesson_2.CustomEventReceiver
import ru.bellintegrator.android_at_lesson_2.R
import ru.bellintegrator.android_at_lesson_2.service.MyBackgroundService

class MainActivity : AppCompatActivity() {
    private lateinit var customEventReceiver: CustomEventReceiver

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Регистрация BroadcastReceiver
        customEventReceiver = CustomEventReceiver()
        registerReceiver(
            customEventReceiver,
            IntentFilter("ru.bellintegrator.android_at_lesson_2.CUSTOM_EVENT"),
            RECEIVER_EXPORTED,
        )

        val cardUiElements = findViewById<CardView>(R.id.cardUiElements)
        val cardTestingTools = findViewById<CardView>(R.id.cardTestingTools)
        val cardContentProviderExample = findViewById<CardView>(R.id.cardContentProviderExample)
        val cardRetrofitCurrency = findViewById<CardView>(R.id.cardCurrency)
        val cardRoomTask = findViewById<CardView>(R.id.cardTask)
        val cardStartService = findViewById<CardView>(R.id.cardService)

        cardUiElements.setOnClickListener {
            startActivity(Intent(this, UiElementsActivity::class.java))
        }

        cardTestingTools.setOnClickListener {
            startActivity(Intent(this, TestingToolsActivity::class.java))
        }

        cardContentProviderExample.setOnClickListener {
            startActivity(Intent(this, ScreenSettingsActivity::class.java))
        }

        cardRetrofitCurrency.setOnClickListener {
            startActivity(Intent(this, CurrencyActivity::class.java))
        }

        cardRoomTask.setOnClickListener {
            startActivity(Intent(this, TaskActivity::class.java))
        }

        // Установить слушатель нажатий
        cardStartService.setOnClickListener {
            // Запуск сервиса
            val serviceIntent = Intent(this, MyBackgroundService::class.java)
            startService(serviceIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(customEventReceiver)
    }
}
