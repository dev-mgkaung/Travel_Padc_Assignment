package mk.kotlin.travel_padc_assignment.datas.model

import android.content.Context
import mk.kotlin.travel_padc_assignment.networks.TourApi
import mk.kotlin.travel_padc_assignment.persistances.TourDB
import mk.padc.mgkaung_assignment.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


abstract class BaseAppModel : BaseModel() {

       var mApi: TourApi
      protected lateinit var mDB: TourDB

     init{
      val mOkHttpClient = OkHttpClient.Builder()
          .connectTimeout(15, TimeUnit.SECONDS)
          .readTimeout(15, TimeUnit.SECONDS)
          .writeTimeout(15, TimeUnit.SECONDS)
          .build()

      val retrofit = Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .client(mOkHttpClient)
          .build()

      mApi = retrofit.create(TourApi::class.java)

  }

    fun initDatabase(context: Context){
        mDB = TourDB.getInstance(context)
    }

}