package mk.kotlin.travel_padc_assignment.viewmodels.viewholders

import android.annotation.SuppressLint
import android.view.View
import kotlinx.android.synthetic.main.score_recyclerview_item_layout.view.*
import mk.kotlin.travel_padc_assignment.R
import mk.kotlin.travel_padc_assignment.datas.vos.ScoreandReviewVO
import mk.kotlin.travel_padc_assignment.viewmodels.BaseViewHolder


class ScoreandReviewViewHolder(itemView: View) : BaseViewHolder<ScoreandReviewVO>(itemView) {
    @SuppressLint("SetTextI18n")
    override fun bindData(data: ScoreandReviewVO) {
        mData = data
        val score = data.score.toString()
        val max_score = data.max_score.toString()
        val review = data.total_reviews.toString()
        itemView.bookingid_textview.text = data.name
        itemView.bookking_rate_id.text =score+"/"+max_score
        itemView.booking_review.text = "Base on $review reviews"
        if(layoutPosition==1)
        {
            itemView.imageView.setImageResource(R.drawable.hotelout)
        }
    }
}