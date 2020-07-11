package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import mk.kotlin.travel_padc_assignment.datas.model.impls.TourModelImpl
import mk.kotlin.travel_padc_assignment.mvp.presenters.AbstractBasePresenter
import mk.kotlin.travel_padc_assignment.mvp.presenters.DetailsPresenter
import mk.kotlin.travel_padc_assignment.mvp.views.DetailsView
import mk.padc.mgkaung_assignment.utils.VALUE_TWO

class DetailsPresenterImpl : DetailsPresenter, AbstractBasePresenter<DetailsView>() {
    private val mTourModel: TourModelImpl = TourModelImpl
    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {

    }

    override fun onDetailUiReadyState(name: String,value:Int, lifecycleOwner: LifecycleOwner) {
        when(value){
            VALUE_TWO ->{
                mTourModel.findTourById(name).observe(lifecycleOwner, Observer {
                    mView?.displayDetails(it)
                })
            }
        }

    }



}