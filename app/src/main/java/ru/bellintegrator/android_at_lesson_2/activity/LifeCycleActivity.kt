package ru.bellintegrator.android_at_lesson_2.activity

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.bellintegrator.android_at_lesson_2.R

class LifeCycleActivity : AppCompatActivity() {
    private lateinit var activityLifecycleTextView: TextView
    private lateinit var fragmentLifecycleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycles)

        activityLifecycleTextView = findViewById(R.id.activity_lifecycle_text_view)
        fragmentLifecycleTextView = findViewById(R.id.fragment_lifecycle_text_view)

        showMessage("Activity: onCreate\nИнициализация активности, восстановление состояния.")

        // Добавляем фрагмент
        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.container, MyFragment())
            transaction.commit()
        }
    }

    override fun onStart() {
        super.onStart()
        showMessage("Activity: onStart\nАктивность становится видимой.")
    }

    override fun onResume() {
        super.onResume()
        showMessage("Activity: onResume\nАктивность готова к взаимодействию с пользователем.")
    }

    override fun onPause() {
        super.onPause()
        showMessage("Activity: onPause\nАктивность теряет фокус, возможно, появляется другое окно.")
    }

    override fun onStop() {
        super.onStop()
        showMessage("Activity: onStop\nАктивность полностью скрыта с экрана.")
    }

    override fun onDestroy() {
        super.onDestroy()
        showMessage("Activity: onDestroy\nАктивность уничтожена, освобождаем все ресурсы.")
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
