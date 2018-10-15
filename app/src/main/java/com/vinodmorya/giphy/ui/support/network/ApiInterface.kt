package com.vinodmorya.giphy.ui.support.network

import com.vinodmorya.giphy.ui.trending.GiphyModel
import io.reactivex.Observable
import ren.yale.android.retrofitcachelibrx2.anno.Cache
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


interface ApiInterface {


    @Cache(time = 1, timeUnit = TimeUnit.SECONDS)
    @GET("trending")
    fun giphyTrending(@Query("api_key") api_token: String, @Query("limit") limit: Int, @Query("offset") offset: Int, @Query("rating") rating: String): Observable<GiphyModel>


    @Cache(time = 1, timeUnit = TimeUnit.SECONDS)
    @GET("search")
    fun giphySearch(@Query("api_key") api_token: String, @Query("q") search: String, @Query("limit") limit: Int, @Query("rating") rating: String,
                    @Query("offset") offset: Int, @Query("lang") lang: String): Observable<GiphyModel>

}
