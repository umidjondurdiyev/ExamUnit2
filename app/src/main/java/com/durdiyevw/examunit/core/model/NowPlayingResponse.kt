package com.durdiyevw.examunit.core.model


import com.google.gson.annotations.SerializedName

data class NowPlayingResponse(
    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int, // 168
    @SerializedName("total_results")
    val totalResults: Int // 3342
) : BaseModel() {
    override fun getType(): Int {
        return NowPlayingResponse
    }
}