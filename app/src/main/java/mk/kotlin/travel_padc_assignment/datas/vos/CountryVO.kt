package mk.kotlin.travel_padc_assignment.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import mk.kotlin.travel_padc_assignment.persistances.PhotoTypeConverter
import mk.kotlin.travel_padc_assignment.persistances.ScoreReviewConverter

@Entity(tableName = "country")
@TypeConverters(ScoreReviewConverter::class, PhotoTypeConverter::class)
data class CountryVO(
    @PrimaryKey
    @SerializedName("name") var name: String = "",
    @SerializedName("description") var description: String = "",
    @SerializedName("location") var location: String = "",
    @SerializedName("average_rating") var average_rating: Double = 0.0,

    @SerializedName("scores_and_reviews") var scores_and_reviews: ArrayList<ScoreandReviewVO> = arrayListOf(),
    @SerializedName("photos") var photos: ArrayList<String> = arrayListOf()
)