package com.example.rajankali.rxsample.viewmodel

import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.util.Log
import com.example.rajankali.rxsample.data.APIClient
import com.example.rajankali.rxsample.data.APIService
import com.example.rajankali.rxsample.dto.BaseModel
import com.example.rajankali.rxsample.interactor.HomeInteractor
import com.example.rajankali.rxsample.util.log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by rajan.kali on 7/18/2017.
 * ViewModel - Home screen
 */

class HomeViewModel(private val homeInteractor: HomeInteractor) : BaseViewModel {
    val users = ObservableField<ArrayList<BaseModel>>()
    val userList = ObservableArrayList<BaseModel>()
    var isGrid = ObservableField<Boolean>()

    init {
        isGrid.set(false)
        val apiClient = APIClient.Factory.create()
        val subscriber = APIService(apiClient).getUsers(1)
        Observable.fromArray(userList).subscribe { users.set(userList) }
        subscriber.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe( { data ->
                run {
                    log("List updated on : ${Thread.currentThread().name} thread")
                    userList.addAll(data)
                    users.set(userList)
                    homeInteractor.showToast("Updated users")
                }}){error -> Log.d("Thread error",error.stackTrace.toString())}
        }

    fun onClick(){
       isGrid.set(!isGrid.get())
    }
}
