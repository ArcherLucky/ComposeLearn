package com.archer.composelearn.old

import android.widget.TextView
import com.archer.composelearn.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class FlashItemAdapter(layoutId: Int, list: MutableList<String>) : BaseQuickAdapter<String, BaseViewHolder>(layoutId, list) {

    override fun convert(holder: BaseViewHolder, item: String) {
        holder.getView<TextView>(R.id.tv_1).setText(item)
        holder.getView<TextView>(R.id.tv_2).setText(item)
    }




}