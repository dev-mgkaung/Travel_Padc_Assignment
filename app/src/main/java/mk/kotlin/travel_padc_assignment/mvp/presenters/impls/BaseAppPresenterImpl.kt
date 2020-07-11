package mk.kotlin.travel_padc_assignment.mvp.presenters.impls

import mk.kotlin.travel_padc_assignment.mvp.presenters.AbstractBasePresenter
import mk.kotlin.travel_padc_assignment.mvp.presenters.BasePresenter
import mk.kotlin.travel_padc_assignment.mvp.views.BaseView


abstract class BaseAppPresenterImpl<V : BaseView> : AbstractBasePresenter<V>(), BasePresenter<V>
