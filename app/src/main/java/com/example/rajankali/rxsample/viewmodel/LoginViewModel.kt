package com.example.rajankali.rxsample.viewmodel

import android.databinding.ObservableField
import android.os.Handler
import com.example.rajankali.rxsample.BuildConfig
import com.example.rajankali.rxsample.interactor.LoginInteractor
import com.manaschaudhari.android_mvvm.FieldUtils.toField
import com.manaschaudhari.android_mvvm.FieldUtils.toObservable
import io.reactivex.Observable.combineLatest
import io.reactivex.functions.BiFunction

/**
 * Created by rajan.kali on 7/16/2017.
 * Main Screen View Model
 */

class LoginViewModel(private val loginInteractor: LoginInteractor) : BaseViewModel {
    var userName = ObservableField<String>()
    var password = ObservableField<String>()
    var buttonText = ObservableField<String>()
    var invalidUserName = ObservableField<String>()
    var invalidPassword = ObservableField<String>()
    var shouldEnableButton = ObservableField<Boolean>()
    var shouldShowProgress = ObservableField<Boolean>()

    init {
        userName.set("")
        password.set("")
        buttonText.set("Login")
        shouldEnableButton = toField<Boolean>(combineLatest(toObservable(password), toObservable(userName),
                BiFunction<String,String,Boolean> { u, p -> u.length > 5 && p.length > 6 }))
        toObservable(userName).subscribe { s -> invalidUserName.set(if (s.length > 5) null else "UserName Should be greater than 5 digits") }
        toObservable(password).subscribe { s -> invalidPassword.set(if (s.length > 6) null else "Password Should be greater than 6 digits") }
        if(BuildConfig.DEBUG){
            userName.set("rajanks")
            password.set("chandana")
        }
    }

   fun loginButtonClick() {
       buttonText.set("")
       shouldShowProgress.set(true)
        Handler().postDelayed({
            shouldShowProgress.set(false)
            buttonText.set("Login")
            if (userName.get() == "rajanks") {
                invalidUserName.set(null)
                if (password.get() == "chandana") {
                    loginInteractor.navigateToHome()
                    invalidPassword.set(null)
                } else {
                    invalidPassword.set("Invalid Password")
                }
            } else {
                invalidUserName.set("Invalid UserName")
            }
        }, 100)
    }
}
