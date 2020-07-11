package mk.kotlin.travel_padc_assignment.mvp.presenters

import android.view.LayoutInflater
import android.view.ViewGroup
import mk.kotlin.travel_padc_assignment.R
import mk.kotlin.travel_padc_assignment.adapters.BaseRecyclerAdapter
import mk.kotlin.travel_padc_assignment.datas.vos.ScoreandReviewVO
import mk.kotlin.travel_padc_assignment.viewmodels.BaseViewHolder
import mk.kotlin.travel_padc_assignment.viewmodels.viewholders.ScoreandReviewViewHolder

class ScoreandReviewAdapter: BaseRecyclerAdapter<BaseViewHolder<ScoreandReviewVO>, ScoreandReviewVO>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ScoreandReviewVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.score_recyclerview_item_layout,parent,false)
        return ScoreandReviewViewHolder(view)

    }

}