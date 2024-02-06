package com.durdiyevw.examunit.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.durdiyevw.examunit.core.model.popular.Result
import com.durdiyevw.examunit.databinding.ItemFilmsBinding


class PopularAdapter : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    private val data = ArrayList<Result>()

    //
    fun setData(data: List<Result>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    fun addData(data:List<Result>){
        this.data.addAll(data)
        notifyItemInserted(this.data.size)
    }

    inner class ViewHolder(private val binding: ItemFilmsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data : Result) {
            binding.filmImage.load("https://image.tmdb.org/t/p/original${data.posterPath}")
            binding.filmDescription.text = data.originalTitle
            binding.filmReviews.text = data.voteAverage.toString()
            binding.hours.text = data.releaseDate
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFilmsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(data = data[position])
    }

}