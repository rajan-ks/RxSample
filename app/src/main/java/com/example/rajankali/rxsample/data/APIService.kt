package com.example.rajankali.rxsample.data

import android.util.Log
import com.example.rajankali.rxsample.dto.User
import com.example.rajankali.rxsample.util.log
import io.reactivex.Observable
import retrofit2.Call

/**
 * Created by rajan.kali on 7/25/2017.
 * Network Service class
 */
class APIService(val apiClient: APIClient) {

    fun getUsers(page: Int): Observable<List<User>> {
        return Observable.create {
            subscriber ->
            try {
                log("Fetching data on ${Thread.currentThread().name}")
                val callResponse = apiClient.query(page)
                val response = callResponse.execute()
                if (response.isSuccessful) {
                    subscriber.onNext(response.body().users)
                    subscriber.onComplete()
                } else {
                    subscriber.onError(Throwable(response.message()))
                }
            }catch (ex : Exception){
                subscriber.onError(ex)
                log("Error: ${ex.stackTrace.toString()}")
            }
        }
    }
}