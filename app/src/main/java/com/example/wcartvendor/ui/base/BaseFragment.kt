package com.example.wcartvendor.ui.base

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

open class BaseFragment:Fragment() {
    protected lateinit var mContext: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context as FragmentActivity
    }
}