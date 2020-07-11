package mk.kotlin.travel_padc_assignment.mvp.presenters

import androidx.lifecycle.ViewModel
import mk.kotlin.travel_padc_assignment.mvp.views.BaseView

abstract class AbstractBasePresenter<T: BaseView> : BasePresenter<T>, ViewModel() {

    protected lateinit var mView : T

    override fun initPresenter(view: T){
        mView = view
    }
}