package com.example.less2_6.ui.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.less2_6.R
import com.example.less2_6.base.BaseFragment
import com.example.less2_6.databinding.FragmentPlaylistBinding
import com.example.less2_6.ui.playlist.adapter.PlaylistAdapter

class PlaylistFragment : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {

    private val adapter : PlaylistAdapter by lazy {
        PlaylistAdapter(this::onClick)
    }

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun inflaterViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlaylistBinding {
        return FragmentPlaylistBinding.inflate(inflater, container, false)
    }

    override fun initViews() {
        viewModel.getPlaylist()
    }

    override fun initListeners() {

    }

    override fun initObservers() {
        viewModel.playlist.observe(viewLifecycleOwner) {
            adapter.addData(it.items)
        }
        binding.rvPlaylist.adapter = adapter
    }

    private fun onClick(id : String) {
        findNavController().navigate(R.id.detailFragment, bundleOf("id" to id))
    }
}