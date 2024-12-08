package ru.bellintegrator.android_at_lesson_2.activity

import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.bellintegrator.android_at_lesson_2.R

class EventDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)

        // Получаем Intent, который вызвал данную активность
        val intent = intent
        intent.action = "ru.bellintegrator.android_at_lesson_2.CUSTOM_EVENT"
        // Создаем линейный макет
        val linearLayout =
            LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            }

        // Добавляем заголовок
        addTextView(linearLayout, "Информация о событии:")

        // Информация о действии
        addTextView(linearLayout, "Действие: ${intent.action}")

        // Информация о дополнительных данных
        intent.extras?.let { extras ->
            for (key in extras.keySet()) {
                val value = extras.get(key)?.toString() ?: "null"
                addTextView(linearLayout, "$key: $value")
            }
        }

        // Устанавливаем макет как содержимое активности
        setContentView(linearLayout)
    }

    private fun addTextView(
        parent: LinearLayout,
        text: String,
    ) {
        parent.addView(
            TextView(this).apply {
                this.text = text
                layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            },
        )
    }
}
