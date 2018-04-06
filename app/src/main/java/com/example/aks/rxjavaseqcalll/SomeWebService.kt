package com.example.aks.rxjavaseqcalll

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by amitkumar.swami on 7/4/18.
 */
class SomeWebService {

    lateinit var apiService: ApiService
    var tokenResult: Observable<String>? = null

    fun getToken(): Observable<String> {
//        if (tokenResult == null) {
        apiService = ApiService.retrofit.create(ApiService::class.java)
        return step1ApiUserResponse()
                .flatMap { body ->
                    step2CookieResponse(body)
                            .flatMap { cookie ->
                                step3TokenResponse(cookie)
                            }

                }

//            val body = step1ApiUserResponse()
//            val cookie = step2CookieResponse(body.blockingSingle())
//            val tokenResult = step3TokenResponse(cookie.blockingSingle())
//            this.tokenResult = tokenResult
//            tokenResult.doOnComplete { }
//        } else {
//            tokenResult!!.doOnComplete { }
//        }
//        return tokenResult
    }

    fun step1ApiUserResponse(): Observable<String?> {
        return apiService.getStep1User()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { user ->
                    Log.d("Step1", user.toString())
                    user.getResponse()
                }
                .toObservable()
    }

    fun step2CookieResponse(body: String): Observable<String?> {
        return apiService.getStep2Cookie(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { result ->
                    result.getCookie()
                }
                .toObservable()
    }

    fun step3TokenResponse(cookie: String): Observable<String?> {
        return apiService.getStep3Token(cookie)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { result ->
                    result.getToken()
                }
                .toObservable()
    }
}