package ru.bellintegrator.android_at_lesson_2.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.bellintegrator.android_at_lesson_2.R

class DeepLinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deeplink)

        // Получаем intent, который вызвал эту активность
        val intent = intent
        if (Intent.ACTION_VIEW == intent.action) {
            // Проверяем, является ли этот intent deep link
            val uri = intent.data
            if (uri != null && uri.toString().startsWith("deeplinkexample://")) {
                Toast.makeText(this, "Вы перешли по deeplink!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
