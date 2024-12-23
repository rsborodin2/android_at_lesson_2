package kaspressoTest.pages

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import ru.bellintegrator.android_at_lesson_2.R
import ru.bellintegrator.android_at_lesson_2.activity.KotlinFeaturesActivity

object KotlinFeaturesScreen : KScreen<KotlinFeaturesScreen>() {
     override val layoutId: Int =  R.layout.activity_kotlin_features
     override val viewClass: Class<*> = KotlinFeaturesActivity::class.java

    val kotlinFeaturesRecyclerView = KRecyclerView (    builder = { withId(R.id.kotlin_recycler_view) },
        itemTypeBuilder = { itemType(::KotlinFeatureItemScreen) }
    )

    class KotlinFeatureItemScreen (matcher: Matcher<View>) : KRecyclerItem<KotlinFeatureItemScreen>(matcher) {
        val noteContainer = KView(matcher) { withId(R.id.linear_feature) }
        val tv_function_name = KTextView(matcher) { withId(R.id.tv_function_name) }
        val tv_long_desc = KTextView(matcher) { withId(R.id.tv_long_desc) }

    }

 }