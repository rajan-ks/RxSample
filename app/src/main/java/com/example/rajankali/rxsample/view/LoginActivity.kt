package com.example.rajankali.rxsample.view

import android.content.Intent
import com.example.rajankali.rxsample.R
import com.example.rajankali.rxsample.interactor.LoginInteractor
import com.example.rajankali.rxsample.viewmodel.BaseViewModel
import com.example.rajankali.rxsample.viewmodel.LoginViewModel

class LoginActivity : BaseActivity(), LoginInteractor {
    override val layoutID: Int
        get() = R.layout.activity_main

    override val baseViewModel: BaseViewModel
        get() = LoginViewModel(this)

    override fun navigateToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
    }
}
