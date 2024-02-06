package com.durdiyevw.examunit.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.durdiyevw.examunit.core.model.NowPlayingResponse
import com.durdiyevw.examunit.core.model.popular.PopularResponse
import com.durdiyevw.examunit.core.repository.FilmRepository
import com.durdiyevw.examunit.core.util.ResultWrapper
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = FilmRepository()
    val nowPlayingLD: MutableLiveData<NowPlayingResponse> = MutableLiveData()
    val popularLD: MutableLiveData<PopularResponse> = MutableLiveData()
    val errorNowLD: MutableLiveData<String> = MutableLiveData()
    val errorPopLD: MutableLiveData<String> = MutableLiveData()

    fun getNowPlaying() {
        viewModelScope.launch {
            val result = repository.getNowPlaying()

            when (result) {
                is ResultWrapper.Success -> {
                    result.response?.let {
                        Log.d("TAG55", it.toString())
                        nowPlayingLD.value = it
                    }
                }

                is ResultWrapper.Error -> {
                    result.message?.let {
                        errorNowLD.value = it.toString()
                    }
                }

                else -> {}
            }
        }
    }

    fun getPopular() {
        viewModelScope.launch {
            val result = repository.getPopular()

            when (result) {
                is ResultWrapper.Success -> {
                    result.response?.let {
                        popularLD.value = it
                    }
                }

                is ResultWrapper.Error -> {
                    result.message?.let {
                        errorPopLD.value = it.toString()
                    }
                }

                else -> {}
            }
        }
    }

}