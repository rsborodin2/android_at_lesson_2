package ru.bellintegrator.android_at_lesson_2.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.bellintegrator.android_at_lesson_2.R

class KotlinFeaturesAdapter(private val features: List<KotlinFeature>) :
    RecyclerView.Adapter<KotlinFeaturesAdapter.ViewHolder>() {
    // Класс ViewHolder теперь содержит ссылки на TextViews
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvFunctionName: TextView = itemView.findViewById(R.id.tv_function_name)
        private val tvShortDesc: TextView = itemView.findViewById(R.id.tv_short_desc)
        private val tvLongDesc: TextView = itemView.findViewById(R.id.tv_long_desc)

        fun bind(feature: KotlinFeature) {
            tvFunctionName.text = feature.name
            tvShortDesc.text = feature.shortDescription
            tvLongDesc.text = feature.longDescription
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        holder.bind(features[position])
    }

    override fun getItemCount(): Int = features.size
}
