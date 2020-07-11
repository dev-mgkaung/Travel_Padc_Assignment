package mk.kotlin.travel_padc_assignment.networks.responses

import com.google.gson.annotations.SerializedName
import mk.kotlin.travel_padc_assignment.datas.vos.CountryVO
import mk.padc.mgkaung_assignment.utils.CODE_RESPONSE

data class GetCountryResponse (
    @SerializedName("code")val code: Int = 0,
    @SerializedName("message")val message: String = "",
    @SerializedName("data")val data: ArrayList<CountryVO> = arrayListOf()) {

    fun isResponseOk():Boolean{
        return data.isEmpty() && code == CODE_RESPONSE
    }
}