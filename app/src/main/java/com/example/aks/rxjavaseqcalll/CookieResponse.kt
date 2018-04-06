package com.example.aks.rxjavaseqcalll

import com.squareup.moshi.Json

/**
 * Created by amitkumar.swami on 7/4/18.
 */
class CookieResponse {

    @Json(name = "SomeCookieValue")
    private var cookie: String? = null

    fun getCookie(): String? {
        return cookie
    }

    fun setCookie(cookie: String) {
        this.cookie = cookie
    }
}