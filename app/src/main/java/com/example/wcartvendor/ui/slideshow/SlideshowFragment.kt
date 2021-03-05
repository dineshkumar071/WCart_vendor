package com.example.wcartvendor.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.wcartvendor.R
import com.example.wcartvendor.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_slideshow.*


class SlideshowFragment : BaseFragment() {
    private var slideshowViewModel: SlideshowViewModel? = null
    override fun onCreateView(
        @NonNull inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        slideshowViewModel = ViewModelProvider(this).get(SlideshowViewModel::class.java)
        val root: View = inflater.inflate(R.layout.fragment_slideshow, container, false)
        slideshowViewModel?.text?.observe(viewLifecycleOwner, Observer {
            fun onChanged(@Nullable s: String?) {
                text_slideshow.text = s
            }
        })
        return root
    }
}