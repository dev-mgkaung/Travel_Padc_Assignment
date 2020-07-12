package mk.kotlin.travel_padc_assignment

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters.MainPresenterImpl
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import mk.kotlin.travel_padc_assignment.datas.model.impls.TourModelImpl
import mk.kotlin.travel_padc_assignment.mvp.views.MainView
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {

     private lateinit var mPresenter : MainPresenterImpl

     @RelaxedMockK
     private lateinit var mView: MainView

     @MockK(relaxUnitFun = true)
     private lateinit var mModel : TourModelImpl

     @Before
     fun setUp() {
         MockKAnnotations.init(this)
         mPresenter = MainPresenterImpl()
         mPresenter.initPresenter(mView)
         mPresenter.mTourModel = this.mModel
     }

    @Test
    fun onTapTourItem_fromHomeFragment() {
        mPresenter.onTapTourItem("Sea Flower Resort",2)

        verify {
            mView?.navigateToTourDetail("Sea Flower Resort",2)
        }
    }

}