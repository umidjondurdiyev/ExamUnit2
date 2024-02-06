package com.durdiyevw.examunit.core.model.popular


import com.durdiyevw.examunit.core.model.BaseModel
import com.google.gson.annotations.SerializedName

data class PopularResponse(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int, // 42646
    @SerializedName("total_results")
    val totalResults: Int // 852918
) : BaseModel() {
    override fun getType(): Int {
        return PopularResponse
    }
}