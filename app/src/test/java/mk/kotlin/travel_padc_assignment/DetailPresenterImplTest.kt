package mk.kotlin.travel_padc_assignment


import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters.DetailsPresenterImpl
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import mk.kotlin.travel_padc_assignment.datas.model.impls.TourModelImpl
import mk.kotlin.travel_padc_assignment.datas.vos.CountryVO
import mk.kotlin.travel_padc_assignment.mvp.views.DetailsView
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class DetailPresenterImplTest {

    private lateinit var mPresenter : DetailsPresenterImpl

    @RelaxedMockK
    private lateinit var mView: DetailsView

    @MockK(relaxUnitFun = true)
    private lateinit var mModel : TourModelImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        mPresenter = DetailsPresenterImpl()
        mPresenter.initPresenter(mView)


        mPresenter.mTourModel = this.mModel

    }

    @Test
    fun onUiReadycallDisplayDetailList_fromDetailActivity() {

        val lifeCycleOwner = mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        val countryone = CountryVO()
        countryone.name="Sea Flower Resort"
        countryone.average_rating=4.0
        countryone.description="Hi desc"
        countryone.location="Yangon"

        mPresenter.onDetailUiReadyState("Sea Flower Resort",2,lifeCycleOwner)

        verify {
            mView?.displayDetails(countryone)
        }
    }

}