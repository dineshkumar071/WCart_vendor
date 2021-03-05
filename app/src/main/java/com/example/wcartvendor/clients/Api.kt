package com.example.wcartvendor.clients

import com.example.wcartvendor.models.BaseResponse
import com.example.wcartvendor.models.Email_login
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    @POST("email_login")
    @FormUrlEncoded
    fun email_login(@Field("email_id") email_id: String?,
                    @Field("password") password: String?,
                    @Field("devicetoken") devicetoken: String?): Call<Email_login?>?

    @POST("register_step1")
    @FormUrlEncoded
    fun registerStep1(@Field("firstname") firstname: String?,
                      @Field("lastname") lastname: String?,
                      @Field("email_id") email_id: String?,
                      @Field("password") password: String?,
                      @Field("phone_no") phone_no: String?,
                      @Field("address1") address1: String?,
                      @Field("address2") address2: String?,
                      @Field("city") city: String?,
                      @Field("state") state: String?,
                      @Field("country") country: String?): Call<BaseResponse?>?

   /* @POST("change_password")
    @FormUrlEncoded
    fun changePassword(@Field("rider_id") rider_id: String?,
                       @Field("oldpassword") oldpassword: String?,
                       @Field("newpassword") newpassword: String?): Call<BaseResponse?>?

    @get:GET("login_screens")
    val banners: Call<Any?>?

    @FormUrlEncoded
    @POST("otp_login")
    fun getUser(@Field("phone_no") phone_no: String?): Call<Users?>?

    @POST("forgot_password")
    @FormUrlEncoded
    fun forgotPassword(@Field("phone_no") phone_no: String?,
                       @Field("newpassword") newpassword: String?
    ): Call<BaseResponse?>?

    @get:GET("cab_types")
    val cabList: Call<Any?>?

    @FormUrlEncoded
    @POST("single_cab_detail")
    fun getCabDetails(@Field("cabtype") cabtype: String?): Call<Cab_details?>?

    @POST("nearbydrivers")
    @FormUrlEncoded
    fun nearBy(@Field("rider_id") rider_id: String?,
               @Field("latitude") latitude: String?,
               @Field("longitude") longitude: String?,
               @Field("cabtype") cabtype: String?
    ): Call<Drivers?>?

    @POST("rateperkm")
    @FormUrlEncoded
    fun rate(@Field("cabtype") cabtype: String?,
             @Field("pickup_lat") pickup_lat: String?,
             @Field("pickup_lng") pickup_lng: String?,
             @Field("drop_lat") drop_lat: String?,
             @Field("drop_lng") drop_lng: String?): Call<RatePer?>?

    @POST("twoway")
    @FormUrlEncoded
    fun twoWay(@Field("cabtype") cabtype: String?,
               @Field("pickup_lat") pickup_lat: String?,
               @Field("pickup_lng") pickup_lng: String?,
               @Field("drop_lat") drop_lat: String?,
               @Field("drop_lng") drop_lng: String?): Call<RatePer?>?

    @POST("book_ride")
    @FormUrlEncoded
    fun  //this arriving driver class is just using comen class purpose
            postBooking(@Field("rider_id") rider_id: String?,
                        @Field("pickup_lat") pickup_lat: String?,
                        @Field("pickup_lng") pickup_lng: String?,
                        @Field("pickup_loc_name") pickup_loc_name: String?,
                        @Field("cabtype") cabtype: String?,
                        @Field("drop_lat") drop_lat: String?,
                        @Field("drop_lng") drop_lng: String?,
                        @Field("drop_loc_name") drop_loc_name: String?,
                        @Field("fare") fare: String?,
                        @Field("distance") distance: String?,
                        @Field("request_time") request_time: String?,
                        @Field("ride_otp") ride_otp: String?,
                        @Field("payment_method") payment_method: String?,
                        @Field("ride_type") ride_type: String?): Call<ArrivingDriver?>?

    @FormUrlEncoded
    @POST("cancel_ride")
    fun cancelRide(@Field("ride_id") ride_id: String?,
                   @Field("cancellation_time") cancellation_time: String?,
                   @Field("cancellation_reason") cancellation_reason: String?): Call<BaseResponse?>?

    @FormUrlEncoded
    @POST("no_driver")
    fun noDriver(@Field("rider_id") rider_id: String?,
                 @Field("request_time") request_time: String?): Call<BaseResponse?>?

    @FormUrlEncoded
    @POST("rideaccept_details")
    fun ArrivingDriverDetails(@Field("rider_id") rider_id: String?,
                              @Field("request_time") request_time: String?): Call<ArrivingDriver?>?

    @FormUrlEncoded
    @POST("driver_tracking")
    fun driverTracking(@Field("driver_id") driver_id: String?,
                       @Field("ride_id") ride_id: String?,
                       @Field("latitude") latitude: String?,
                       @Field("longitude") longitude: String?
    ): Call<DriverTrack?>?

    @FormUrlEncoded
    @POST("start_trip")
    fun startRide(@Field("ride_id") user_id: String?): Call<BaseResponse?>?

    @FormUrlEncoded
    @POST("end_trip")
    fun endTrip(@Field("ride_id") ride_id: String?): Call<EndTrip?>?

    @FormUrlEncoded
    @POST("stripe_pay")
    fun payStripe(@Field("amount") amount: String?,
                  @Field("token") token: String?,
                  @Field("rider_id") rider_id: String?,
                  @Field("email_id") email_id: String?,
                  @Field("ride_id") ride_id: String?): Call<BaseResponse?>?

    @FormUrlEncoded
    @POST("razor_pay")
    fun payRazor(@Field("amount") amount: String?,
                 @Field("rider_id") rider_id: String?,
                 @Field("ride_id") ride_id: String?,
                 @Field("status") status: String?,
                 @Field("transaction_id") transaction_id: String?
    ): Call<BaseResponse?>?

    @FormUrlEncoded
    @POST("ride_rating")
    fun ratings(@Field("rating") rating: String?,
                @Field("review") review: String?,
                @Field("ride_id") ride_id: String?): Call<BaseResponse?>?

    @FormUrlEncoded
    @POST("change_payment")
    fun changePayment(@Field("ride_id") ride_id: String?,
                      @Field("prev_method") prev_method: String?): Call<EndTrip?>?

    @FormUrlEncoded
    @POST("my_trips")
    fun getTripDetails(@Field("rider_id") rider_id: String?): Call<OvertripDetailsList?>?

    @FormUrlEncoded
    @POST("single_trip")
    fun getSingleTripDetail(@Field("rider_id") rider_id: String?,
                            @Field("ride_id") ride_id: String?
    ): Call<SingleTripDetails?>?*/
}