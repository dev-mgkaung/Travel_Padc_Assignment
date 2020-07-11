package mk.kotlin.travel_padc_assignment.fragments

import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters.DetailsPresenterImpl
import kotlinx.android.synthetic.main.detail_toolbar_layout.*
import kotlinx.android.synthetic.main.fragment_detail.*
import mk.kotlin.travel_padc_assignment.R
import mk.kotlin.travel_padc_assignment.adapters.PhotoAdapter
import mk.kotlin.travel_padc_assignment.datas.model.TourModel
import mk.kotlin.travel_padc_assignment.datas.model.impls.TourModelImpl
import mk.kotlin.travel_padc_assignment.datas.vos.CountryVO
import mk.kotlin.travel_padc_assignment.mvp.presenters.DetailsPresenter
import mk.kotlin.travel_padc_assignment.mvp.presenters.ScoreandReviewAdapter
import mk.kotlin.travel_padc_assignment.mvp.views.DetailsView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DetailFragment : Fragment(), DetailsView {

    private var name: String = ""
    private var mValue: Int = 0
    private lateinit var mDetailPresenter: DetailsPresenter
    private lateinit var mScoreandReviewAdapter: ScoreandReviewAdapter
    private lateinit var mPhotoAdapter: PhotoAdapter
    val mTourModel: TourModel = TourModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_PARAM1).toString()
            mValue = it.getInt(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initPresneter()
        setUpRecycler()
        settingData()
        mDetailPresenter.onDetailUiReadyState(name,mValue,this)
    }

    private fun initPresneter(){
        mDetailPresenter = DetailsPresenterImpl()
        mDetailPresenter.initPresenter(this)
    }

    private fun setUpRecycler(){
        mScoreandReviewAdapter = ScoreandReviewAdapter()
        mPhotoAdapter = PhotoAdapter()

        val layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        val layoutManagerTwo = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        scorce_recyclerview.layoutManager = layoutManager
        photo_list_recyclerview.layoutManager = layoutManagerTwo
        scorce_recyclerview.adapter = mScoreandReviewAdapter
        photo_list_recyclerview.adapter = mPhotoAdapter

    }

    private fun settingData(){
        arrow_image.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(name: String, value: Int) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, name)
                    putInt(ARG_PARAM2, value)
                }
            }
    }

    override fun displayDetails(countryVO: CountryVO) {
        activity?.let {
            Glide.with(it)
                .load(countryVO.photos[1])
                .centerCrop()
                .into(bgimage)
        }
        title.text = countryVO.name
        tvLocation.text = countryVO.location
        tvRating.text = countryVO.average_rating.toString()
        ratingBar.rating = countryVO.average_rating.toFloat()
        mScoreandReviewAdapter.setNewData(countryVO.scores_and_reviews)
        mPhotoAdapter.setNewData(countryVO.photos)
        detail.text = countryVO.description
    }
}
