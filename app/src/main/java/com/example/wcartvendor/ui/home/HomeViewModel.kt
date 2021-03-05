package com.example.wcartvendor.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wcartvendor.ui.base.BaseViewModel


class HomeViewModel(private val mApplication: Application): BaseViewModel(mApplication) {
    private val mText: MutableLiveData<String> = MutableLiveData()
    val text: LiveData<String>
        get() = mText

    init {
        mText.value = "This is home fragment"
    }
}