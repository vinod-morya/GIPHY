package com.vinodmorya.giphy.ui.support.network

import com.vinodmorya.giphy.ui.trending.GiphyModel

class NetworkCallbackInterfaces {

    interface TrendingCallbacks {
        fun onTrendingSuccess(giphyModel: GiphyModel)

        fun onTrendingFailed(giphyError: String)
    }

    interface SearchCallbacks {
        fun onSearchSuccess(giphyModel: GiphyModel, query: String)

        fun onSeachFailed(giphyError: String)
    }
}
