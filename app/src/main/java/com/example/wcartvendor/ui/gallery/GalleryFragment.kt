package com.example.wcartvendor.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.wcartvendor.R
import com.example.wcartvendor.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : BaseFragment() {
    private val galleryViewModel by lazy { ViewModelProvider(this).get(GalleryViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            tv_gallery.text = it
        })
    }
}