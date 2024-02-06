package com.durdiyevw.examunit.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.durdiyevw.examunit.core.model.BaseModel
import com.durdiyevw.examunit.core.model.NowPlayingResponse
import com.durdiyevw.examunit.core.model.popular.PopularResponse
import com.durdiyevw.examunit.databinding.ItemBannerParentBinding
import com.durdiyevw.examunit.databinding.ItemFilmParentBinding

class MultiAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = ArrayList<BaseModel>()

    fun setData(data:ArrayList<BaseModel>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].getType()
    }

    inner class BannerParentViewHolder(private val binding: ItemBannerParentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val adapter = BannerAdapter()

        fun bindDataToBannerParent(data:NowPlayingResponse) {
            binding.recycleBanner.adapter = adapter
            binding.recycleBanner.setHasFixedSize(true)
            adapter.setData(data = data.results)
        }
    }

    inner class FilmsParentViewHolder(private val binding: ItemFilmParentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val adapter = PopularAdapter()

        fun bindDataToFilmsParent(data:PopularResponse) {
            binding.newsRecyclerView.adapter = adapter
            binding.newsRecyclerView.setHasFixedSize(true)
            adapter.setData(data = data.results)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            0 -> {
                BannerParentViewHolder(
                    ItemBannerParentBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }

            else -> {
                FilmsParentViewHolder(
                    ItemFilmParentBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (getItemViewType(position)) {
            0 -> {
                (holder as BannerParentViewHolder).bindDataToBannerParent(data[position] as NowPlayingResponse)
            }

            1 -> {
                (holder as FilmsParentViewHolder).bindDataToFilmsParent(data[position] as PopularResponse)
            }
        }
    }
}