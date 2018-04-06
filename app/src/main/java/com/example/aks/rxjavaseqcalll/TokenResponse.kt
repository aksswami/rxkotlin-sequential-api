package com.example.aks.rxjavaseqcalll

import com.squareup.moshi.Json

/**
 * Created by amitkumar.swami on 7/4/18.
 */
class TokenResponse {

    @Json(name = "Token")
    private var token: String? = null

    fun getToken(): String? {
        return token
    }

    fun setToken(token: String) {
        this.token = token
    }
}