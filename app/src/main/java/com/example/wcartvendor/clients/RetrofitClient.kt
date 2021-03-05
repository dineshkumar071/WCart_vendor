package com.example.wcartvendor.clients

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = " http://wcartnode.webnexs.org/vendorapi/"
    private var retrofit: Retrofit? = null

    // service = retrofit.create(Api.class);
    private val retrofitInstance: Retrofit?
        get() {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val okHttp = OkHttpClient.Builder().addInterceptor(logger)
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson)).client(okHttp.build())
                    .build()

            // service = retrofit.create(Api.class);
            return retrofit
        }

    @JvmStatic
    val apiService: Api?
        get() = retrofitInstance?.create(Api::class.java)
}