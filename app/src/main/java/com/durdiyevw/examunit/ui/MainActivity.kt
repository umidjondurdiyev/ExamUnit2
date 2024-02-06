package com.durdiyevw.examunit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import by.kirich1409.viewbindingdelegate.viewBinding
import com.durdiyevw.examunit.R
import com.durdiyevw.examunit.core.adapter.MultiAdapter
import com.durdiyevw.examunit.core.model.BaseModel
import com.durdiyevw.examunit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::bind)
    private val viewModel: MainViewModel by viewModels()
    private val data = ArrayList<BaseModel>()
    private val adapter by lazy { MultiAdapter() }
    var one = false
    var two = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getNowPlaying()
        viewModel.getPopular()
        setAdapter()
        observer()
        setAdapterToData()

    }



    private fun setAdapter() {
        binding.recycleView.adapter = adapter
        binding.recycleView.setHasFixedSize(true)
    }

    private fun observer() {

        viewModel.popularLD.observe(this) {
            Log.d("TAG66", data.toString())
            this.data.add(it)
            one = true
            setAdapterToData()
        }
        viewModel.nowPlayingLD.observe(this) {
            this.data.add(it)
            Log.d("TAG66", data.toString())
            two = true
            setAdapterToData()
        }
        viewModel.errorPopLD.observe(this) {
            Log.d("TAG44", it)
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        viewModel.errorNowLD.observe(this) {
            Log.d("TAG44", it)
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        Log.d("TAG55", data.toString())

    }

    private fun setAdapterToData() {
        if (one && two){
            adapter.setData(data)
        }
    }
}