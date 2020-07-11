package mk.kotlin.travel_padc_assignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import mk.kotlin.travel_padc_assignment.mvp.views.DetailsView

interface DetailsPresenter : BasePresenter<DetailsView>
{
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun onDetailUiReadyState(name:String,value:Int,lifecycleOwner: LifecycleOwner)
}