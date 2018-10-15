package com.vinodmorya.giphy.ui.trending

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

class GiphyModel {

    @SerializedName("data")
    @Expose
    var gif: ArrayList<GiphyModelGif>? = null
    @SerializedName("pagination")
    @Expose
    var pagination: Pagination? = null
    @SerializedName("meta")
    @Expose
    var meta: Meta? = null


    inner class Meta : Serializable {

        @SerializedName("status")
        @Expose
        var status: Int? = null
        @SerializedName("msg")
        @Expose
        var msg: String? = null
        @SerializedName("response_id")
        @Expose
        var responseId: String? = null

    }

    inner class Pagination : Serializable {

        @SerializedName("total_count")
        @Expose
        var totalCount: Int? = null
        @SerializedName("count")
        @Expose
        var count: Int? = null
        @SerializedName("offset")
        @Expose
        var offset: Int? = null

    }
}