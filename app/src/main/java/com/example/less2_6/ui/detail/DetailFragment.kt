package com.example.less2_6.ui.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.less2_6.base.BaseFragment
import com.example.less2_6.databinding.FragmentDetailBinding
import com.example.less2_6.databinding.FragmentVideoBinding

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    override val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this)[DetailViewModel::class.java]
    }

    override fun inflaterViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun initViews() {
        val id = arguments?.getString("id")
        viewModel.getPlaylistItems(id.toString()).observe(viewLifecycleOwner) {
            Log.e("TAG", "initViews: " + it)
        }
    }

    override fun initListeners() {

    }

    override fun initObservers() {

    }

}