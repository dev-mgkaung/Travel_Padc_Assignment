
package mk.kotlin.travel_padc_assignment.persistances

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import mk.kotlin.travel_padc_assignment.datas.vos.ScoreandReviewVO

class ScoreReviewConverter {
    @TypeConverter
    fun toString(dataList:ArrayList<ScoreandReviewVO>):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toCountryList(countryListJsonStr:String):ArrayList<ScoreandReviewVO>{
        val countryListType = object : TypeToken<ArrayList<ScoreandReviewVO>>(){}.type
        return Gson().fromJson(countryListJsonStr,countryListType)
    }
}