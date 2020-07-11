package mk.kotlin.travel_padc_assignment.datas.model

import androidx.lifecycle.LiveData
import io.reactivex.Observable
import mk.kotlin.travel_padc_assignment.datas.vos.CountryVO
import mk.kotlin.travel_padc_assignment.datas.vos.DataVO


interface TourModel {

    fun getCommonApi(onError: (message: String) -> Unit): Observable<DataVO>
    fun findTourById(name: String): LiveData<CountryVO>

}