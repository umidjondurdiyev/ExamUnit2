package com.durdiyevw.examunit.core.repository

import com.durdiyevw.examunit.core.model.NowPlayingResponse
import com.durdiyevw.examunit.core.model.popular.PopularResponse
import com.durdiyevw.examunit.core.network.ApiClient
import com.durdiyevw.examunit.core.util.ResultWrapper
import java.io.IOException

class FilmRepository {

    val api = ApiClient.createService()

    suspend fun getNowPlaying() : ResultWrapper<NowPlayingResponse, Any>{
        return try {
            val result = api.getNowPlaying("10137bab07a7a987b23a902a78d6986c")

            if (result.isSuccessful) {
                ResultWrapper.Success(result.body(), result.code())
            } else {
                ResultWrapper.Error(result.message(), result.code())
            }
        } catch (e: IOException) {
            ResultWrapper.Error("Internet Yoq")
        } catch (e: Exception) {
            ResultWrapper.Error(e.message)
        }
    }

    suspend fun getPopular() : ResultWrapper<PopularResponse, Any>{
        return try {
            val result = api.getPopularFilms("10137bab07a7a987b23a902a78d6986c")

            if (result.isSuccessful) {
                ResultWrapper.Success(result.body(), result.code())
            } else {
                ResultWrapper.Error(result.message(), result.code())
            }
        } catch (e: IOException) {
            ResultWrapper.Error("Internet Yoq")
        } catch (e: Exception) {
            ResultWrapper.Error(e.message)
        }
    }

}