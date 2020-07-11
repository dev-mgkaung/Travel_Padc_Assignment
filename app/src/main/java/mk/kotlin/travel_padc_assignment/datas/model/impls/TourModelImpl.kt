package mk.kotlin.travel_padc_assignment.datas.model.impls

import android.util.Log
import androidx.lifecycle.LiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import mk.kotlin.travel_padc_assignment.datas.model.BaseAppModel
import mk.kotlin.travel_padc_assignment.datas.model.TourModel
import mk.kotlin.travel_padc_assignment.datas.vos.CountryVO
import mk.kotlin.travel_padc_assignment.datas.vos.DataVO


object TourModelImpl: BaseAppModel(), TourModel {


    private fun mergeList():BiFunction<List<CountryVO>,List<CountryVO>,List<CountryVO>>{
        val dataList = ArrayList<CountryVO>()
        return BiFunction { one, two->
            one.forEach {
                dataList.add(it)
            }
            two.forEach {
                dataList.add(it)
            }
            dataList
        }
    }


    override fun getCommonApi(onError: (message: String) -> Unit): Observable<DataVO> {
        val observableOne = mApi.getAllCourntries().map { it.data.toList() }.subscribeOn(Schedulers.io())
        val observableTwo = mApi.getAllTours().map { it.data.toList()}.subscribeOn(Schedulers.io())
        val zipData = Observable.zip(
            observableOne,
            observableTwo,
            createDataVOModel())
          observableOne.subscribeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mDB.TourDao().insertAllData(it) },{
               Log.e("error",it.localizedMessage)
            })
          observableTwo.subscribeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mDB.TourDao().insertAllData(it)
            },{
                Log.e("error",it.localizedMessage.toString())
            })
        return zipData
    }



    private fun createDataVOModel():BiFunction<List<CountryVO>,List<CountryVO>,DataVO> {
        val dataList = ArrayList<CountryVO>()
        val popularList = ArrayList<CountryVO>()
        return BiFunction { one, two->
            one.forEach {
                dataList.add(it)
            }
            two.forEach {
                popularList.add(it)
            }
            DataVO(dataList,popularList)
        }
    }



    override fun findTourById(name: String): LiveData<CountryVO> {
        return mDB.TourDao().getTourById(name)
    }


}