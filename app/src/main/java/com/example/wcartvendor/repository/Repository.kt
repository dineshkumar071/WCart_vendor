package com.example.wcartvendor.repository

import com.example.wcartvendor.clients.RetrofitClient

object Repository {

    val api = RetrofitClient.apiService

    fun registerUser(
        firstName: String?,
        lastName: String?,
        eMail: String?,
        password: String?,
        mobileNumber: String?,
        address1: String?,
        address2: String?,
        city: String?,
        state: String?,
        country: String?
    ) = api?.registerStep1(firstName,
        lastName,
        eMail,
        password,
        mobileNumber,
        address1,
        address2,
        city,
        state,
        country)
}