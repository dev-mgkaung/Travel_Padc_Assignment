package mk.kotlin.travel_padc_assignment.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
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

class DetailActivity: BaseActivity(), DetailsView {

    private lateinit var mDetailPresenter: DetailsPresenter
    private lateinit var mScoreandReviewAdapter: ScoreandReviewAdapter
    private lateinit var mPhotoAdapter: PhotoAdapter

    val mTourModel: TourModel = TourModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detail)
        initPresneter()
        setUpRecycler()
        settingData()

        mDetailPresenter.onDetailUiReadyState(
             intent.getStringExtra(ARG_PARAM1).toString(),
             intent.getIntExtra(ARG_PARAM2, 0),this)

    }

    private fun initPresneter(){
        mDetailPresenter = DetailsPresenterImpl()
        mDetailPresenter.initPresenter(this)
    }

    private fun setUpRecycler(){
        mScoreandReviewAdapter = ScoreandReviewAdapter()
        mPhotoAdapter = PhotoAdapter()

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        val layoutManagerTwo = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        scorce_recyclerview.layoutManager = layoutManager
        photo_list_recyclerview.layoutManager = layoutManagerTwo
        scorce_recyclerview.adapter = mScoreandReviewAdapter
        photo_list_recyclerview.adapter = mPhotoAdapter

    }

    private fun settingData(){
        arrow_image.setOnClickListener {
           super.onBackPressed()
        }
    }


    companion object {
        @JvmStatic
        fun newIntent(context: Context,name: String, value: Int): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(ARG_PARAM1,name)
            intent.putExtra(ARG_PARAM2,value)
            return intent
        }
    }


    override fun displayDetails(countryVO: CountryVO) {
        this?.let {
            Glide.with(it)
                .load(countryVO.photos[1])
                .centerCrop()
                .into(bgimage)
        }
        stitle.text = countryVO.name
        tvLocation.text = countryVO.location
        tvRating.text = countryVO.average_rating.toString()
        ratingBar.rating = countryVO.average_rating.toFloat()
        mScoreandReviewAdapter.setNewData(countryVO.scores_and_reviews)
        mPhotoAdapter.setNewData(countryVO.photos)
        detail.text = countryVO.description
    }

}
