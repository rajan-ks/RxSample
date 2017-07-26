package com.example.rajankali.rxsample.binder

import android.databinding.BindingAdapter
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import com.example.rajankali.rxsample.R
import com.example.rajankali.rxsample.dto.BaseModel
import com.example.rajankali.rxsample.dto.User
import com.example.rajankali.rxsample.view.RecyclerAdapter
import com.mikhaellopez.circularimageview.CircularImageView
import com.squareup.picasso.Picasso

/**
 * Created by rajan.kali on 7/16/2017.
 * Common Bind class
 */


@BindingAdapter("font")
fun setFont(view: TextView, fontName: String) {
    val context = view.context
    val fontPath = "Fonts/$fontName.ttf"
    try {
        view.typeface = Typeface.createFromAsset(context.assets, fontPath)
    } catch (e: Exception) {
        view.typeface = Typeface.DEFAULT
    }

}

@BindingAdapter("image")
fun setImageFromURL(imageView: CircularImageView, imageUrl: String){
    val context = imageView.context
    Picasso.with(context).load(imageUrl).error(R.mipmap.ic_launcher).into(imageView)
}

@BindingAdapter("error")
fun setError(editText: EditText, errorText: String?) {
    if (TextUtils.isEmpty(errorText)) {
        editText.error = null
    } else {
        editText.error = errorText
    }
}

@BindingAdapter("tint")
fun setTint(progressBar: ProgressBar, color: Int) {
    progressBar.indeterminateDrawable.setColorFilter(color, PorterDuff.Mode.SRC_IN)
}

@BindingAdapter("manager","data","list_item","grid_item")
fun setDataAndLayout(recyclerView: RecyclerView,isGrid: Boolean,data : ArrayList<BaseModel>?, listItem:Int , gridItem:Int){
    Log.d("Thread for UI",Thread.currentThread().name)
   if(!isGrid) recyclerView.layoutManager = LinearLayoutManager(recyclerView.context) else recyclerView.layoutManager = GridLayoutManager(recyclerView.context, 2)
    if(data != null) recyclerView.adapter = RecyclerAdapter(recyclerView.context, dataList = data, isGrid = isGrid, gridItemId = gridItem, listItemId = listItem,clazz = User::class.java)
}