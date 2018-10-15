package com.vinodmorya.giphy.ui.trending

interface TrendingContracts {
    interface ITrendingView {
        fun showProgress()
        fun hideProgress()
        fun onTrendingDataReceived(giphyModel: GiphyModel)
        fun showError(error: String)

        fun onSearchDataReceived(giphyModel: GiphyModel, query: String)
    }

    interface TrendingPresenter {
        fun onSearchInit(search: String)
        fun fetchTrending(mOffset: Int)
    }

    interface TrendingInteractor {
        fun fetchTrendingGifs(trendingFetchListener: TrendingFetchListener, mOffset: Int)
        fun onSearchInitialised(SearchListener: TrendingContracts.TrendingInteractor.SearchListener, mToken: String)

        interface TrendingFetchListener{
            fun onTrendingFetchSuccess(giphyModel: GiphyModel)
            fun onTrendingFetchFail(error: String)
        }


        interface SearchListener{
            fun onSearchSuccess(giphyModel: GiphyModel, query: String)
            fun onSearchFail(error: String)
        }


    }
}