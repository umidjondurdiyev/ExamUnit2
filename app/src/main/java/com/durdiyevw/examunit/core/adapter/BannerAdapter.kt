package com.durdiyevw.examunit.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.durdiyevw.examunit.databinding.ItemBannerBinding
import com.durdiyevw.examunit.databinding.ItemFilmsBinding


class BannerAdapter : RecyclerView.Adapter<BannerAdapter.ViewHolder>() {

    private val data = ArrayList<com.durdiyevw.examunit.core.model.Result>()

    //
    fun setData(data: List<com.durdiyevw.examunit.core.model.Result>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    fun addData(data: List<com.durdiyevw.examunit.core.model.Result>) {
        this.data.addAll(data)
        notifyItemInserted(this.data.size)
    }

    inner class ViewHolder(private val binding: ItemBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: com.durdiyevw.examunit.core.model.Result) {
            binding.bannerImg.load("https://image.tmdb.org/t/p/original${data.posterPath}")
            binding.bannerDescription.text = data.title
            binding.bannerReviews.text = data.voteAverage.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(data = data[position])
    }

}