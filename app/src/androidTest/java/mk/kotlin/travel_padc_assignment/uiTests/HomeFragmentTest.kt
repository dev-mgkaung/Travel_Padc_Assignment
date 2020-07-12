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
class HomeFragmentTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun checkHomeFragmentVisible_navigateHomeFragment() {

        onView(withId(R.id.action_home)).perform(click())
        onView(withId(R.id.home_fragment)).check(matches(isDisplayed()))
    }

}