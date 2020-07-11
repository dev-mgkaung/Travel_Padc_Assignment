package mk.kotlin.travel_padc_assignment.mvp.views

import mk.kotlin.travel_padc_assignment.datas.vos.DataVO


interface MainView : BaseView{
    fun displayCountryList(countryList: DataVO)
    fun displayEmptyView()
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun navigateToTourDetail(name:String,value:Int)
}