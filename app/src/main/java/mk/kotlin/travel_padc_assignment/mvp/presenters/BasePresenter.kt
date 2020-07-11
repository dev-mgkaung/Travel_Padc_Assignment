package mk.kotlin.travel_padc_assignment.mvp.presenters

import mk.kotlin.travel_padc_assignment.mvp.views.BaseView

interface BasePresenter<V: BaseView> {
    fun initPresenter(view: V)
}