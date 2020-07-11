package mk.kotlin.travel_padc_assignment

import android.app.Application
import mk.kotlin.travel_padc_assignment.datas.model.impls.TourModelImpl

class MyApp : Application()
{
    override fun onCreate() {

        super.onCreate()

        //Database initialization
         TourModelImpl.initDatabase(applicationContext)

    }

}