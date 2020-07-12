package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import io.reactivex.android.schedulers.AndroidSchedulers
import mk.kotlin.travel_padc_assignment.datas.model.impls.TourModelImpl
import mk.kotlin.travel_padc_assignment.mvp.presenters.AbstractBasePresenter
import mk.kotlin.travel_padc_assignment.mvp.presenters.MainPresenter
import mk.kotlin.travel_padc_assignment.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    var mTourModel = TourModelImpl


    override fun onSwipeRefresh() {
        requestAllCountries()
    }

    override fun onUiReadyState(lifecycleOwner: LifecycleOwner) {
        requestAllCountries()
    }


    override fun onTapTourItem(name: String,value: Int) {
        mView?.navigateToTourDetail(name,value)
    }



    private fun requestAllCountries() {
        mView?.enableSwipeRefresh()
        mTourModel.getCommonApi(onError = {
                mView?.disableSwipeRefresh()
                mView?.displayEmptyView()
            }).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mView?.enableSwipeRefresh()
                mView?.displayCountryList(it)
                mView?.disableSwipeRefresh()
                })
}

}