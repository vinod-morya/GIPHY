package com.vinodmorya.giphy.ui.trending

import com.vinodmorya.giphy.BuildConfig
import com.vinodmorya.giphy.ui.support.network.NetworkCallbackInterfaces
import com.vinodmorya.giphy.ui.support.network.NetworkDataManager

class TrendingInteractorImpl : TrendingContracts.TrendingInteractor, NetworkCallbackInterfaces.TrendingCallbacks, NetworkCallbackInterfaces.SearchCallbacks {

    private lateinit var mTrendingSearchListener: TrendingContracts.TrendingInteractor.SearchListener
    private lateinit var trendingFetchListener: TrendingContracts.TrendingInteractor.TrendingFetchListener


    override fun fetchTrendingGifs(trendingFetchListener: TrendingContracts.TrendingInteractor.TrendingFetchListener, mOffset: Int) {
        this.trendingFetchListener = trendingFetchListener
        NetworkDataManager.getInstance().fetchTrendingData(BuildConfig.GIPHY_API_KEY, mOffset,this)
    }

    override fun onSearchInitialised(onseachListener: TrendingContracts.TrendingInteractor.SearchListener, query: String) {
        this.mTrendingSearchListener = onseachListener
        NetworkDataManager.getInstance().searchGifs(BuildConfig.GIPHY_API_KEY, query, this)
    }

    override fun onTrendingSuccess(giphyModel: GiphyModel) {
        trendingFetchListener.onTrendingFetchSuccess(giphyModel)
    }

    override fun onTrendingFailed(error: String) {
        trendingFetchListener.onTrendingFetchFail(error)
    }

    override fun onSearchSuccess(giphyModel: GiphyModel, query: String) {
        mTrendingSearchListener.onSearchSuccess(giphyModel, query)
    }

    override fun onSeachFailed(giphyError: String) {
        mTrendingSearchListener.onSearchFail(giphyError)
    }
}