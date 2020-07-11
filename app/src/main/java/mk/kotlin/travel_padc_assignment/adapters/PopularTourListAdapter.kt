package mk.kotlin.travel_padc_assignment.viewmodels.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import mk.kotlin.travel_padc_assignment.R
import mk.kotlin.travel_padc_assignment.adapters.BaseRecyclerAdapter
import mk.kotlin.travel_padc_assignment.datas.vos.CountryVO
import mk.kotlin.travel_padc_assignment.delegates.ToursItemDelegate
import mk.kotlin.travel_padc_assignment.viewmodels.BaseViewHolder

class PopularTourListAdapter(delegate: ToursItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<CountryVO>, CountryVO>() {
    val mDelegate = delegate
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<CountryVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tour_recyclerview_itemlayout, parent,false)
        return PopularTourViewHolder(view,mDelegate)
    }
}