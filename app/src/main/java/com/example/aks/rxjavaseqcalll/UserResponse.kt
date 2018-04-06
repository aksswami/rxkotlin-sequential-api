package com.example.aks.rxjavaseqcalll

import com.squareup.moshi.Json

/**
 * Created by amitkumar.swami on 7/4/18.
 */
class UserResponse {

    @Json(name = "Response")
    private var response: String? = null

    fun getResponse(): String? {
        return response
    }

    fun setResponse(response: String) {
        this.response = response
    }
}