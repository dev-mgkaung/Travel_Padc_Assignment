
package mk.kotlin.travel_padc_assignment.networks

import io.reactivex.Observable
import mk.kotlin.travel_padc_assignment.networks.responses.GetAllTourResponse
import mk.kotlin.travel_padc_assignment.networks.responses.GetCountryResponse
import mk.padc.mgkaung_assignment.utils.GET_ALL_COUNTRY
import mk.padc.mgkaung_assignment.utils.GET_ALL_TOUR
import retrofit2.http.*

interface TourApi{
    @GET(GET_ALL_COUNTRY)
    fun getAllCourntries()
            : Observable<GetCountryResponse>

    @GET(GET_ALL_TOUR)
    fun getAllTours(): Observable<GetAllTourResponse>

}