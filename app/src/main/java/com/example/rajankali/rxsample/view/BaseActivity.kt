package com.example.rajankali.rxsample.view

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.example.rajankali.rxsample.BR

import com.example.rajankali.rxsample.viewmodel.BaseViewModel

/**
 * Created by rajan.kali on 7/17/2017.
 * Base Activity class
 */

abstract class BaseActivity : AppCompatActivity() {

    @get:LayoutRes
    protected abstract val layoutID: Int
    protected abstract val baseViewModel: BaseViewModel

    protected lateinit var binding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ViewDataBinding>(this, layoutID)
        binding.setVariable(BR.data, baseViewModel)
    }
}
