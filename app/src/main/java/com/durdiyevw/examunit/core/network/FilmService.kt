package com.durdiyevw.examunit.core.network

import com.durdiyevw.examunit.core.model.NowPlayingResponse
import com.durdiyevw.examunit.core.model.popular.PopularResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmService {

    @GET("/3/movie/now_playing")
    suspend fun getNowPlaying(@Query("api_key") apiKey:String) : Response<NowPlayingResponse>

    @GET("/3/movie/popular")
    suspend fun getPopularFilms(@Query("api_key") apiKey: String) : Response<PopularResponse>
}