package mk.kotlin.travel_padc_assignment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters.MainPresenterImpl
import kotlinx.android.synthetic.main.fragment_home.*
import mk.kotlin.travel_padc_assignment.R
import mk.kotlin.travel_padc_assignment.activities.DetailActivity
import mk.kotlin.travel_padc_assignment.adapters.CountryListAdapter
import mk.kotlin.travel_padc_assignment.adapters.MainAdapter
import mk.kotlin.travel_padc_assignment.datas.model.TourModel
import mk.kotlin.travel_padc_assignment.datas.model.impls.TourModelImpl
import mk.kotlin.travel_padc_assignment.datas.vos.DataVO
import mk.kotlin.travel_padc_assignment.delegates.ToursItemDelegate
import mk.kotlin.travel_padc_assignment.mvp.presenters.MainPresenter
import mk.kotlin.travel_padc_assignment.mvp.views.MainView
import mk.kotlin.travel_padc_assignment.viewmodels.viewholders.PopularTourListAdapter
import mk.kotlin.travel_padc_assignment.viewmodels.viewpods.EmptyViewPod
import mk.padc.mgkaung_assignment.utils.EM_NO_NEWS_AVAILABLE


class HomeFragment : Fragment(), ToursItemDelegate, MainView {

    private lateinit var mAdatper: CountryListAdapter
    private lateinit var mPopularAdapter: PopularTourListAdapter

    val mTourImpl: TourModel = TourModelImpl
    lateinit var mMainAdapter: MainAdapter
    val datalist: ArrayList<DataVO> = arrayListOf()

    private lateinit var viewPodEmpty: EmptyViewPod
    private lateinit var mPresenter: MainPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun setUpPresenter(){
        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(this)
    }
    private fun setUpViewPod() {
        viewPodEmpty = vpEmpty as EmptyViewPod
        viewPodEmpty.setEmptyData(EM_NO_NEWS_AVAILABLE, "")
    }
    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        hideEmptyView()
        setUpSwipeRefresh()
        setUpRecyclerView()
        setUpViewPod()
        mPresenter.onUiReadyState(this)
    }

    private fun setUpSwipeRefresh() {
        swipeRefresh.setOnRefreshListener {
            mPresenter.onSwipeRefresh()
        }
    }

    private fun setUpRecyclerView() {
        mMainAdapter = MainAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mainRecyler.layoutManager = linearLayoutManager
        mainRecyler.adapter = mMainAdapter
    }

    override fun displayCountryList(countryList: DataVO) {
         datalist.clear()
         datalist.add(countryList)
         mMainAdapter.setNewData(listOf(countryList))
    }


    private fun showEmptyView() {
        vpEmpty.visibility = View.VISIBLE
    }

    private fun hideEmptyView() {
        vpEmpty.visibility = View.GONE
    }


    override fun displayEmptyView() {
        showEmptyView()
    }

    override fun enableSwipeRefresh() {
        swipeRefresh.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefresh.isRefreshing = false
    }

    override fun navigateToTourDetail(name: String, value: Int) {

        context?.let { ActivityCompat.startActivity(it,DetailActivity.newIntent(it,name,value),null) }

    }

    override fun onTapTourItem(name: String, id: Int) {}


}
