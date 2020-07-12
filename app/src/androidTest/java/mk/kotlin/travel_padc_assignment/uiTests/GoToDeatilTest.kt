package mk.kotlin.travel_padc_assignment.uiTests

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import mk.kotlin.travel_padc_assignment.R
import mk.kotlin.travel_padc_assignment.activities.MainActivity
import mk.kotlin.travel_padc_assignment.viewmodels.viewholders.CountryViewHolder
import mk.kotlin.travel_padc_assignment.viewmodels.viewholders.PopularTourViewHolder
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class GoToDetailTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnPopularListRecyclerview_navigateToDetails() {
        Espresso.onView(withId(R.id.mainRecyler))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<PopularTourViewHolder>(0,
                    ViewActions.click()
                ))

        Espresso.onView(withId(R.id.tvLocation))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun tapOnCountryListRecyclerview_navigateToDetails() {
        Espresso.onView(withId(R.id.mainRecyler))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<CountryViewHolder>(0,
                    ViewActions.click()
                ))

        Espresso.onView(withId(R.id.tvLocation))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}