
package mk.kotlin.travel_padc_assignment.mvp.views
import mk.kotlin.travel_padc_assignment.datas.vos.CountryVO

interface DetailsView : BaseView {
    fun displayDetails(news: CountryVO)
}