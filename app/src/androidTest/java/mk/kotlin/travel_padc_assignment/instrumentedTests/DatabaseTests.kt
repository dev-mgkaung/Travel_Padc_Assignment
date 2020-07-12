package mk.kotlin.travel_padc_assignment.instrumentedTests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import mk.kotlin.travel_padc_assignment.datas.vos.CountryVO
import mk.kotlin.travel_padc_assignment.datas.vos.DataVO
import mk.kotlin.travel_padc_assignment.persistances.TourDB
import mk.kotlin.travel_padc_assignment.persistances.TourDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {

    private lateinit var mDao: TourDao
    private lateinit var db: TourDB

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, TourDB::class.java
        ).build()
        mDao = db.TourDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertIntoDatabaseTest() {

        val countryone = CountryVO()
        countryone.name = "Myanmar"
        countryone.average_rating = 4.0
        countryone.description = "Hi desc"
        countryone.location = "Yangon"

        val countrytwo = CountryVO()
        countrytwo.name = "United state"
        countrytwo.average_rating = 5.0
        countrytwo.description = "Hi desc"
        countrytwo.location = "American"

        mDao.insertAllData(Arrays.asList(countryone, countrytwo))

        assert(mDao.getTourById(countryone.name).value?.name == countryone.name)

    }


}

