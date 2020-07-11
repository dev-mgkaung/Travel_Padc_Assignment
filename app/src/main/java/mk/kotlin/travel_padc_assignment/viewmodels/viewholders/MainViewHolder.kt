package mk.kotlin.travel_padc_assignment.viewmodels.viewholders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.two_reyclerview.view.*
import mk.kotlin.travel_padc_assignment.adapters.CountryListAdapter
import mk.kotlin.travel_padc_assignment.datas.vos.CountryVO
import mk.kotlin.travel_padc_assignment.datas.vos.DataVO
import mk.kotlin.travel_padc_assignment.delegates.ToursItemDelegate
import mk.kotlin.travel_padc_assignment.viewmodels.BaseViewHolder


class MainViewHolder(itemView: View, delegate: ToursItemDelegate) : BaseViewHolder<DataVO>(itemView) {

    val mDelegate = delegate
    private val countryList = mutableListOf<CountryVO>()
    private lateinit var mCountryListAdapter: CountryListAdapter
    private lateinit var mPopularTourListAdapter: PopularTourListAdapter
    override fun bindData(data: DataVO) {
        mData = data
        setUpRecycler()
        if(data.countryList.isNotEmpty())
        {
            mCountryListAdapter.setNewData(data.countryList.toMutableList())
            mPopularTourListAdapter.setNewData(data.popourTourList.toMutableList())
        }

    }

    private fun setUpRecycler(){
        mCountryListAdapter = CountryListAdapter(mDelegate)
        mPopularTourListAdapter = PopularTourListAdapter(mDelegate)
        val mManagerOne = LinearLayoutManager(itemView.country_recyclerview.context,LinearLayoutManager.HORIZONTAL,false)
        val mManagerTwo = LinearLayoutManager(itemView.popular_recyclerview.context,LinearLayoutManager.VERTICAL,false)
        itemView.country_recyclerview.layoutManager = mManagerOne
        itemView.popular_recyclerview.layoutManager = mManagerTwo
        itemView.country_recyclerview.adapter = mCountryListAdapter
        itemView.popular_recyclerview.adapter = mPopularTourListAdapter
    }
}