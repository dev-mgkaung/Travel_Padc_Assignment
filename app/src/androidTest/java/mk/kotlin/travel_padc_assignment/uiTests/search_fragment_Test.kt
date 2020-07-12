package mk.kotlin.travel_padc_assignment.uiTests

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import mk.kotlin.travel_padc_assignment.R
import mk.kotlin.travel_padc_assignment.activities.MainActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class SearchFragmentTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun checkSearchFragmentVisible_navigateSearchFragment() {

            onView(withId(R.id.action_search)).perform(click())
            onView(withId(R.id.search_fragment)).check(matches(isDisplayed()))
            onView(withId(R.id.search_text)).check(matches(withText("Search Fragment")))

    }

}