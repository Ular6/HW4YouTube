package com.example.less2_6.ui.video

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.less2_6.base.BaseFragment
import com.example.less2_6.databinding.FragmentVideoBinding

class VideoFragment : BaseFragment<FragmentVideoBinding, VideoViewModel>() {

    override val viewModel: VideoViewModel by lazy {
        ViewModelProvider(this)[VideoViewModel::class.java]
    }

    override fun inflaterViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentVideoBinding {
        return FragmentVideoBinding.inflate(inflater, container, false)
    }

    override fun initViews() {

    }

    override fun initListeners() {

    }

    override fun initObservers() {

    }

}