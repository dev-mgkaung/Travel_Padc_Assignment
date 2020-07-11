package mk.kotlin.travel_padc_assignment.datas.vos

import com.google.gson.annotations.SerializedName

data class PopularTourVO(
    @SerializedName("name")val name:String ="",
    @SerializedName("description") val description:String ="",
    @SerializedName("location")val location:String ="",
    @SerializedName("average_rating")val average_rating:Int = 0,
    @SerializedName("scores_and_reviews")val scores_and_reviews:ArrayList<ScoreandReviewVO> = arrayListOf(),
    @SerializedName("photos")val photos:ArrayList<String> = arrayListOf()
)