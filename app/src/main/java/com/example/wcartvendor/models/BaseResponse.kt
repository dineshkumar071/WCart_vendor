package com.example.wcartvendor.models

import com.google.gson.annotations.SerializedName

open class BaseResponse {
    @SerializedName("message")
    var message: String? = null

    @JvmField
    @SerializedName("status")
    var status: String? = null

}