package com.example.rajankali.rxsample.data

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

/**
 * Created by rajan.kali on 7/26/2017.
 */

class dummy {

    internal fun rajan() {
        Observable.just("1").subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(s: String) {

            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {

            }
        })

        Observable.just(1).subscribe({ integer -> run{} }) { throwable -> kotlin.run {  } }
    }
}
