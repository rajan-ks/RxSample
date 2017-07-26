package com.example.rajankali.rxsample.view

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rajankali.rxsample.dto.BaseModel
import com.example.rajankali.rxsample.viewmodel.RxViewHolder


/**
 * Created by rajan.kali on 7/24/2017.
 * Adapter class
 */
class RecyclerAdapter(val context: Context, val dataList: List<BaseModel>, val isGrid: Boolean,
                      @LayoutRes val listItemId: Int, @LayoutRes val gridItemId: Int, val clazz: Class<out BaseModel>) : RecyclerView.Adapter<RxViewHolder>(){

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RxViewHolder?, position: Int) {
        holder?.bind(dataList[position],clazz = clazz)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RxViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val layoutId = if(isGrid) gridItemId else listItemId
        val row: View = layoutInflater.inflate(layoutId,parent,false)
        return RxViewHolder(row)
    }
}