package com.example.rajankali.rxsample.viewmodel

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.rajankali.rxsample.BR
import com.example.rajankali.rxsample.dto.BaseModel

/**
 * Created by rajan.kali on 7/24/2017.
 * Custom View Holder Recycler View
 */

class RxViewHolder(rowView: View) : RecyclerView.ViewHolder(rowView) {
    val itemBinding:ViewDataBinding = DataBindingUtil.bind(rowView)

    fun bind(data: BaseModel,clazz: Class<out BaseModel>) {
        itemBinding.setVariable(BR.data,clazz.cast(data))
        itemBinding.executePendingBindings()
    }
}
