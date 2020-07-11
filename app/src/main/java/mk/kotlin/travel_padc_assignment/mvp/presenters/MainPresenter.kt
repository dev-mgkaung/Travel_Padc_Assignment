package mk.kotlin.travel_padc_assignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import mk.kotlin.travel_padc_assignment.delegates.ToursItemDelegate
import mk.kotlin.travel_padc_assignment.mvp.views.MainView

interface MainPresenter : ToursItemDelegate, BasePresenter<MainView> {
    fun onSwipeRefresh()
    fun onUiReadyState(lifecycleOwner: LifecycleOwner)
}
