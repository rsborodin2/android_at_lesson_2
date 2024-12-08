package ru.bellintegrator.android_at_lesson_2.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.bellintegrator.android_at_lesson_2.R

/**
 * Класс AppiumDetailsActivity представляет собой активность, которая наследуется от AppCompatActivity.
 *
 * Эта активность предназначена для отображения подробностей о тестировании с использованием инструмента Appium.
 */
class AppiumDetailsActivity : AppCompatActivity() {
    /**
     * Метод onCreate вызывается при создании активности.
     *
     * @param savedInstanceState Сохранённое состояние активности, если оно существует.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appium_details)
    }
}
