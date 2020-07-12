package mk.kotlin.travel_padc_assignment.uiTests

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import mk.kotlin.travel_padc_assignment.R
import mk.kotlin.travel_padc_assignment.activities.DetailActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class DetailActivityTest{
    private val activityTestRule = ActivityTestRule<DetailActivity>(DetailActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun checkDetailActivityVisible_navigateDetailActivity() {

        Espresso.onView(ViewMatchers.withId(R.id.scorce_recyclerview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}