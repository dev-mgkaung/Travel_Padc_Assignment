package mk.kotlin.travel_padc_assignment.viewmodels.viewholders

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.country_recyclerview_item.view.*
import mk.kotlin.travel_padc_assignment.datas.vos.CountryVO
import mk.kotlin.travel_padc_assignment.delegates.ToursItemDelegate
import mk.kotlin.travel_padc_assignment.viewmodels.BaseViewHolder
import mk.padc.mgkaung_assignment.utils.VALUE_TWO

class CountryViewHolder(itemView: View,delegate: ToursItemDelegate) : BaseViewHolder<CountryVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                countriesdata->
                delegate.onTapTourItem(countriesdata.name,VALUE_TWO)
            }

        }
    }

    override fun bindData(data: CountryVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.photos[1])
            .centerCrop()
            .into(itemView.countryimage)
        itemView.country_rate_id.text = data.average_rating.toString()

    }

}