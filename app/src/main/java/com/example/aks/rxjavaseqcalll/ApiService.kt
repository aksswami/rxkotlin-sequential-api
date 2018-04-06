package com.example.aks.rxjavaseqcalll

import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


/**
 * Created by amitkumar.swami on 7/4/18.
 */
interface ApiService {

    @GET("/booky/step1user")
    fun getStep1User(): Single<UserResponse>

    @GET("/booky/step2cookie")
    fun getStep2Cookie(@Query("body") body: String): Single<CookieResponse>

    @GET("/booky/step3token")
    fun getStep3Token(@Header("Cookie") sessionId: String): Single<TokenResponse>

    companion object {

        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://jimclermonts.nl")
                .addConverterFactory(MoshiConverterFactory.create().asLenient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
    }
}