package ru.bellintegrator.android_at_lesson_2.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.bellintegrator.android_at_lesson_2.R
import ru.bellintegrator.android_at_lesson_2.service.CurrencyApiService
import ru.bellintegrator.android_at_lesson_2.service.CurrencyResponse
import java.io.IOException

/**
 * Активность CurrencyActivity предназначена для отображения актуального курса валюты.
 *
 * Она получает курс рубля к доллару с помощью API Open Exchange Rates и выводит результат на экран.
 */
class CurrencyActivity : AppCompatActivity() {
    /**
     * Метод onCreate вызывается при создании активности.
     *
     * Он инициализирует интерфейс пользователя, устанавливает Retrofit для взаимодействия с API,
     * выполняет запрос к API и отображает результат на экране.
     *
     * @param savedInstanceState Сохранённое состояние активности, если оно существует.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)

        // Находим TextView для вывода результата
        val textViewResult = findViewById<TextView>(R.id.text_view_result)

        // Инициализация Retrofit
        val retrofit =
            Retrofit.Builder()
                .baseUrl("https://openexchangerates.org/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // Получение экземпляра сервиса
        val currencyApiService = retrofit.create(CurrencyApiService::class.java)

        // Выполнение асинхронного запроса в отдельном корутинном контексте
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Выполняем запрос к API
                val response: Response<CurrencyResponse> = currencyApiService.getLatestRates()

                // Переключаемся обратно в основной поток для обновления UI
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        // Извлекаем ответ и получаем курс рубля
                        val currencyResponse = response.body()
                        val rubRate = currencyResponse?.rates?.get("RUB") ?: 0.0
                        val result = "Курс рубля к доллару: %.2f".format(rubRate)
                        textViewResult.text = result
                    } else {
                        // Отображаем код ошибки, если запрос завершился неудачно
                        textViewResult.text = "Код ошибки: ${response.code()}"
                    }
                }
            } catch (e: IOException) {
                // Обрабатываем исключение, связанное с сетью
                withContext(Dispatchers.Main) {
                    textViewResult.text = e.message
                }
            }
        }
    }
}
