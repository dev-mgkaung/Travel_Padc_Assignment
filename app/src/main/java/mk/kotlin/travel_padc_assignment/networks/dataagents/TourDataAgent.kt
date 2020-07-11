package mk.kotlin.travel_padc_assignment.networks

import mk.kotlin.travel_padc_assignment.datas.vos.CountryVO


interface TourDataAgent {

    fun getAllTours(accessToken:String, onSuccess: (List<CountryVO>, List<CountryVO>)->Unit,
                    onFailure: (String)->Unit)

}