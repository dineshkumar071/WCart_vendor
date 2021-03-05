package com.example.wcartvendor.ui.register

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.wcartvendor.R
import com.example.wcartvendor.models.BaseResponse
import com.example.wcartvendor.repository.Repository
import com.example.wcartvendor.ui.base.BaseViewModel
import com.example.wcartvendor.utility.Utilities.isValidEmail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.HashMap


class RegisterViewModel(private val mApplication: Application): BaseViewModel(mApplication)  {
    val errorMessage by lazy { MutableLiveData<String>() }
    val progressBar by lazy { MutableLiveData<Boolean>() }
    val responseSuccess by lazy { MutableLiveData<String>()}

    fun validation(){
        if (firstName?.isEmpty() == true) {
            errorMessage.value= mApplication.getString(R.string.err_fname_empty)
        } else if (lastName?.isEmpty() == true) {
            errorMessage.value= mApplication.getString(R.string.err_lname_empty)
        } else if (eMail?.isEmpty() == true) {
            errorMessage.value= mApplication.getString(R.string.err_email_empty)
        } else if (eMail?.isNotEmpty() == true && !isValidEmail(eMail!!)) {
            errorMessage.value= mApplication.getString(R.string.err_email_invalid)
        } else if (password?.isEmpty()==true) {
            errorMessage.value= mApplication.getString(R.string.err_password_empty)
        } else if (confirmPassword?.isEmpty()==true) {
            errorMessage.value= mApplication.getString(R.string.err_cpassword_empty)
        } else if (password!= confirmPassword) {
            errorMessage.value= mApplication.getString(R.string.err_dont_match)
        } else if (mobileNumber?.isEmpty()==true) {
            errorMessage.value= mApplication.getString(R.string.err_mobile_empty)
        } else if (address1?.isEmpty()==true) {
            errorMessage.value= mApplication.getString(R.string.err_add1)
        } else if (address2?.isEmpty()==true) {
            errorMessage.value= mApplication.getString(R.string.err_add2)
        } else if (state?.isEmpty()==true) {
            errorMessage.value= mApplication.getString(R.string.err_state_empty)
        } else if (city?.isEmpty()==true) {
            errorMessage.value= mApplication.getString(R.string.err_city_empty)
        } else if (country?.isEmpty()==true) {
            errorMessage.value= mApplication.getString(R.string.err_country_empty)
        } /*else if (chk.isChecked()==false) {
            Toast.makeText(this,  getResources().getString(R.string.err_name_empty), Toast.LENGTH_SHORT).show();
            return;
        }else if (bitmap == null) {
            Toast.makeText(this,  getResources().getString(R.string.err_name_empty), Toast.LENGTH_SHORT).show();
            return;
        }*/ else {
            registerUser()
        }
    }

    private fun registerUser() {
        progressBar.value=true
       val call=Repository.registerUser(firstName, lastName, eMail, password, mobileNumber, address1, address2, city, state, country)
        call?.enqueue(object : Callback<BaseResponse?> {
            override fun onResponse(call: Call<BaseResponse?>, response: Response<BaseResponse?>) {
                val users = response.body()
                if (users?.status.equals("true", ignoreCase = true)) {
                    progressBar.value = false
                    responseSuccess.value = "success"
                    /* ProgressDialog!!.cancel()
                    cusRotateLoading!!.stop()
                    startActivity(Intent(this@RegisterActivity, Registration_step2::class.java))*/

                } else {
                    progressBar.value = false
                    /*   ProgressDialog!!.cancel()
                    cusRotateLoading!!.stop()
                    Toast.makeText(this@RegisterActivity, "invalid email password...", Toast.LENGTH_SHORT).show()*/
                    errorMessage.value = "invalid email or password"
                }

                // loader(false);
            }

            override fun onFailure(call: Call<BaseResponse?>, t: Throwable) {
                progressBar.value = false
                /* ProgressDialog!!.cancel()
                cusRotateLoading!!.stop()
                Toast.makeText(this@RegisterActivity, "Sorry something went wrong...", Toast.LENGTH_SHORT).show()*/
                errorMessage.value = "Sorry something went wrong"
            }
        })
    }

    fun getCountryCode():MutableMap<String, String> {
        val isoCountryCodes: Array<String> = Locale.getISOCountries()
        val countryMap: MutableMap<String, String> = HashMap()
        var locale: Locale
        var name: String
        for (code in isoCountryCodes) {
            locale = Locale("", code)
            name = locale.displayCountry
            countryMap[name] = code
        }
        return countryMap
    }

}