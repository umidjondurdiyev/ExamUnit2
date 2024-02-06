package com.durdiyevw.examunit.core.model

import com.durdiyevw.examunit.core.model.popular.PopularResponse

abstract class BaseModel {

    companion object {
        const val NowPlayingResponse = 0
        const val PopularResponse = 1
    }

    abstract fun getType(): Int

}