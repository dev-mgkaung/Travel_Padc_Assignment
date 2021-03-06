package mk.kotlin.travel_padc_assignment.persistances

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mk.kotlin.travel_padc_assignment.datas.vos.CountryVO

@Database(entities = [CountryVO::class],version =1,exportSchema = false)
abstract class TourDB : RoomDatabase() {
    companion object{
        val DB_NAME ="TOUR_DB"
        var dbInstance: TourDB? = null

        fun getInstance(context: Context): TourDB{
            when(dbInstance){
                null ->{
                    dbInstance = Room.databaseBuilder(context,TourDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            val i = dbInstance
            return i!!
        }
    }
    abstract fun TourDao(): TourDao

}