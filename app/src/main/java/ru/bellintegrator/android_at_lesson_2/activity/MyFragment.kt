package ru.bellintegrator.android_at_lesson_2.activity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.bellintegrator.android_at_lesson_2.R

class MyFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        showMessage("Fragment: onAttach\nПрисоединение фрагмента к активности.")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showMessage("Fragment: onCreate\nСоздание фрагмента, инициализация данных.")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        showMessage("Fragment: onViewCreated\nНастройка элементов управления в представлении.")
    }

    override fun onStart() {
        super.onStart()
        showMessage("Fragment: onStart\nФрагмент становится видимым.")
    }

    override fun onResume() {
        super.onResume()
        showMessage("Fragment: onResume\nФрагмент готов к взаимодействию с пользователем.")
    }

    override fun onPause() {
        super.onPause()
        showMessage("Fragment: onPause\nФрагмент теряет фокус, возможно, появляется другое окно.")
    }

    override fun onStop() {
        super.onStop()
        showMessage("Fragment: onStop\nФрагмент скрыт от пользователя.")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        showMessage("Fragment: onDestroyView\nУдаление представления фрагмента.")
    }

    override fun onDestroy() {
        super.onDestroy()
        showMessage("Fragment: onDestroy\nУничтожение фрагмента, освобождение ресурсов.")
    }

    override fun onDetach() {
        super.onDetach()
        showMessage("Fragment: onDetach\nОтсоединение фрагмента от активности.")
    }

    private fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}
