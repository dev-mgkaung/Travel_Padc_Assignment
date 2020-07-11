package mk.kotlin.travel_padc_assignment.persistances

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mk.kotlin.travel_padc_assignment.datas.vos.CountryVO

@Dao
interface TourDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllData(infos:List<CountryVO>)

    @Query("select * from country where name= :name")
    fun getTourById(name: String) : LiveData<CountryVO>


}