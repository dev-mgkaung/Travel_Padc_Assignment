package mk.kotlin.travel_padc_assignment.viewmodels.viewholders
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.photo_item_layout_recyclerview.view.*
import mk.kotlin.travel_padc_assignment.viewmodels.BaseViewHolder

class PhotoViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {
    override fun bindData(data: String) {
        mData = data

        Glide.with(itemView.context)
            .load(data)
            .centerCrop()
            .into(itemView.photoimage)
    }
}