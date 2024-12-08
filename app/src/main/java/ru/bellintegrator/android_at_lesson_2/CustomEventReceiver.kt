package ru.bellintegrator.android_at_lesson_2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import ru.bellintegrator.android_at_lesson_2.activity.EventDetailsActivity

class CustomEventReceiver : BroadcastReceiver() {
    companion object {
        const val TAG = "CustomEventReceiver"
        const val CUSTOM_EVENT_ACTION = "ru.bellintegrator.android_at_lesson_2.CUSTOM_EVENT"
    }

    override fun onReceive(
        context: Context?,
        intent: Intent?,
    ) {
        if (context == null || intent == null) {
            Log.e(TAG, "Context or intent is null!")
            return
        }

        if (intent.action == CUSTOM_EVENT_ACTION) {
            val eventData = intent.getStringExtra("event_data")
            Log.d(TAG, "Received custom event with data: $eventData")

            when (eventData) {
                "SHOW_TOAST" -> showToast(context!!)
                "OPEN_ACTIVITY" -> openActivity(context!!)
                else -> Log.w(TAG, "Unknown event data received: $eventData")
            }
        } else {
            Log.w(TAG, "Action does not match: ${intent.action}")
        }
    }

    private fun showToast(context: Context) {
        Toast.makeText(context, "Custom Event Received!", Toast.LENGTH_SHORT).show()
    }

    private fun openActivity(context: Context) {
        val activityIntent = Intent(context, EventDetailsActivity::class.java)
        activityIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(activityIntent)
    }
}
