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

class CurrencyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)

        val textViewResult = findViewById<TextView>(R.id.text_view_result)

        // Инициализация Retrofit
        val retrofit =
            Retrofit.Builder()
                .baseUrl("https://openexchangerates.org/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // Получение экземпляра сервиса
        val currencyApiService = retrofit.create(CurrencyApiService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response: Response<CurrencyResponse> = currencyApiService.getLatestRates()

                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        val currencyResponse = response.body()
                        val rubRate = currencyResponse?.rates?.get("RUB") ?: 0.0
                        val result = "Курс рубля к доллару: %.2f".format(rubRate)
                        textViewResult.text = result
                    } else {
                        textViewResult.text = "Код ошибки: ${response.code()}"
                    }
                }
            } catch (e: IOException) {
                withContext(Dispatchers.Main) {
                    textViewResult.text = e.message
                }
            }
        }
    }
}
