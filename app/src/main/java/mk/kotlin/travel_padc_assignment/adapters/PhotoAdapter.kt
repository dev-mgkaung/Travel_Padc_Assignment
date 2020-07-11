package mk.kotlin.travel_padc_assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import mk.kotlin.travel_padc_assignment.R
import mk.kotlin.travel_padc_assignment.viewmodels.BaseViewHolder
import mk.kotlin.travel_padc_assignment.viewmodels.viewholders.PhotoViewHolder

class PhotoAdapter: BaseRecyclerAdapter<BaseViewHolder<String>, String>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item_layout_recyclerview,parent,false)
        return PhotoViewHolder(view)
    }
}