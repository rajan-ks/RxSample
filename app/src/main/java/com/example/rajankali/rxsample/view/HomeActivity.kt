package com.example.rajankali.rxsample.view

import com.example.rajankali.rxsample.R
import com.example.rajankali.rxsample.interactor.HomeInteractor
import com.example.rajankali.rxsample.util.longToast
import com.example.rajankali.rxsample.viewmodel.BaseViewModel
import com.example.rajankali.rxsample.viewmodel.HomeViewModel

class HomeActivity : BaseActivity(), HomeInteractor {

    override val layoutID: Int
        get() = R.layout.activity_home

    override val baseViewModel: BaseViewModel
        get() = HomeViewModel(this)

    override fun showToast(message:String) {
        runOnUiThread {
            longToast(message)
        }
    }
}
