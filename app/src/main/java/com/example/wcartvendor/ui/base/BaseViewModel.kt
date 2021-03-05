package com.example.wcartvendor.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class BaseViewModel(mApplication: Application) : AndroidViewModel(mApplication){
    var firstName:String?=null
    var lastName:String?=null
    var eMail:String?=null
    var password:String?=null
    var confirmPassword:String?=null
    var mobileNumber:String?=null
    var address1:String?=null
    var address2:String?=null
    var city:String?=null
    var state:String?=null
    var country:String?=null
}