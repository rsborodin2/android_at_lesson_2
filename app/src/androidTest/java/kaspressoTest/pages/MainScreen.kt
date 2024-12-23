package kaspressoTest.pages

import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import ru.bellintegrator.android_at_lesson_2.R
import ru.bellintegrator.android_at_lesson_2.activity.MainActivity

object MainScreen : KScreen<MainScreen>() {
    override val layoutId: Int =  R.layout.activity_main
    override val viewClass: Class<*> = MainActivity::class.java

    val cardKotlinFeaturesButton = KButton { withId(R.id.cardKotlinFeatures) }
    val cardTask = KButton{withId(R.id.cardTask)}
}