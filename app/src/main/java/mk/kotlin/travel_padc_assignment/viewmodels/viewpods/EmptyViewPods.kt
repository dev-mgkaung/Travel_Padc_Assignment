package mk.kotlin.travel_padc_assignment.viewmodels.viewpods
import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_pod_empty.view.*
import mk.kotlin.travel_padc_assignment.R


class EmptyViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()

    }

    fun setEmptyData(emptyMessage : String, emptyImageUrl: String){
        tvEmpty.text = emptyMessage
        ivEmptyImage.setImageResource(R.drawable.notfound)
    }


}