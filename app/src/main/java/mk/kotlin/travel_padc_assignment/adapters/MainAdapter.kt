package mk.kotlin.travel_padc_assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import mk.kotlin.travel_padc_assignment.R
import mk.kotlin.travel_padc_assignment.datas.vos.DataVO
import mk.kotlin.travel_padc_assignment.delegates.ToursItemDelegate
import mk.kotlin.travel_padc_assignment.viewmodels.BaseViewHolder
import mk.kotlin.travel_padc_assignment.viewmodels.viewholders.MainViewHolder

class MainAdapter(delegate: ToursItemDelegate): BaseRecyclerAdapter<BaseViewHolder<DataVO>, DataVO>(){

    val mDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<DataVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.two_reyclerview,parent,false)
        return MainViewHolder(view,mDelegate)
    }

}