package com.example.less2_6.ui.playlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.less2_6.databinding.ItemPlaylistBinding
import com.example.less2_6.model.Item
import com.example.less2_6.utils.loadImage

class PlaylistAdapter(private val onClick : (String) -> Unit) : RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    private val data : ArrayList<Item> = arrayListOf()

    fun addData(newData: List<Item>?) {
        data.clear()
        if (newData != null) {
            data.addAll(newData)
        }
        notifyDataSetChanged()
    }

    inner class PlaylistViewHolder(private val binding : ItemPlaylistBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : Item) {
            itemView.setOnClickListener{
                onClick(item.id.toString())
            }
            val count = item.contentDetails?.itemCount
            val title = item.snippet?.title
            binding.tvVideoCount.text = "$count video series"
            binding.tvTitle.text = item.snippet?.channelTitle
            binding.tvDesc.text = title.toString()
            binding.ivVideo.loadImage(item.snippet?.thumbnails?.default?.url.toString())
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(data[position])
    }
}