package ru.bellintegrator.android_at_lesson_2.activity

import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import ru.bellintegrator.android_at_lesson_2.R
import ru.bellintegrator.android_at_lesson_2.broadcastReceiver.CustomEventReceiver
import ru.bellintegrator.android_at_lesson_2.service.ForegroundService
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
        val cardComplexLayout = findViewById<CardView>(R.id.cardComplexLayout)
        val cardForegroundService = findViewById<CardView>(R.id.cardForegroundService)
        val cardOpenDeepLink = findViewById<CardView>(R.id.cardOpenDeeplink)
        val cardLifeCycle = findViewById<CardView>(R.id.cardLifeCycle)
        val cardKotlinFeature = findViewById<CardView>(R.id.cardKotlinFeatures)
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

        cardComplexLayout.setOnClickListener {
            startActivity(Intent(this, ComplexActivity::class.java))
        }

        cardLifeCycle.setOnClickListener {
            startActivity(Intent(this, LifeCycleActivity::class.java))
        }

        cardKotlinFeature.setOnClickListener {
            startActivity(Intent(this, KotlinFeaturesActivity::class.java))
        }

        cardOpenDeepLink.setOnClickListener {
            val uri = Uri.parse("deeplinkexample://deeplinkactivity/open")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        // Установить слушатель нажатий
        cardStartService.setOnClickListener {
            // Запуск сервиса
            val serviceIntent = Intent(this, MyBackgroundService::class.java)
            startService(serviceIntent)
        }

        // Установить слушатель нажатий
        cardForegroundService.setOnClickListener {
            // Запуск сервиса
            val input = "This is a test message."
            val serviceIntent = Intent(this, ForegroundService::class.java)
            serviceIntent.putExtra("inputExtra", input)
            ContextCompat.startForegroundService(this, serviceIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(customEventReceiver)
    }
}
