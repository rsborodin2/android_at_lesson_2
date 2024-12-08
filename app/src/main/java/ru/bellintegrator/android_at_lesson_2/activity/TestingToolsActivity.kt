package ru.bellintegrator.android_at_lesson_2.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ru.bellintegrator.android_at_lesson_2.R

class TestingToolsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing_tools)

        val buttonEspressoDetails = findViewById<Button>(R.id.buttonEspressoDetails)
        val buttonUiAutomatorDetails = findViewById<Button>(R.id.buttonUiAutomatorDetails)
        val buttonRobotiumDetails = findViewById<Button>(R.id.buttonRobotiumDetails)
        val buttonKaspressoDetails = findViewById<Button>(R.id.buttonKaspressoDetails)
        val buttonAppiumDetails = findViewById<Button>(R.id.buttonAppiumDetails)

        // Обработчик для кнопки "Подробнее" для Espresso
        buttonEspressoDetails.setOnClickListener {
            openUrl("https://developer.android.com/training/testing/espresso")
        }

        // Обработчик для кнопки "Подробнее" для UI Automator
        buttonUiAutomatorDetails.setOnClickListener {
            openUrl("https://developer.android.com/training/testing/ui-automator")
        }

        // Обработчик для кнопки "Подробнее" для Robotium
        buttonRobotiumDetails.setOnClickListener {
            openUrl("https://github.com/robotiumtech/robotium/wiki/Getting-Started")
        }

        // Обработчик для кнопки "Подробнее" для Kaspresso
        buttonKaspressoDetails.setOnClickListener {
            openUrl("https://github.com/Kaspresso")
        }

        // Обработчик для кнопки "Подробнее" для Appium
        buttonAppiumDetails.setOnClickListener {
            openUrl("https://appium.io/")
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
