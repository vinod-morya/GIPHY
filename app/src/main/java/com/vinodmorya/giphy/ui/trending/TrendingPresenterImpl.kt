package com.vinodmorya.giphy.ui.trending

class TrendingPresenterImpl : TrendingContracts.TrendingPresenter, TrendingContracts.TrendingInteractor.SearchListener, TrendingContracts.TrendingInteractor.TrendingFetchListener {


    private var mITrendingView: TrendingContracts.ITrendingView
    private var trendingInteractor: TrendingContracts.TrendingInteractor

    constructor(iTrendingView: TrendingFragment) {
        this.mITrendingView = iTrendingView
        this.trendingInteractor = TrendingInteractorImpl()
    }

    override fun fetchTrending(mOffset: Int) {
        mITrendingView.showProgress()
        trendingInteractor.fetchTrendingGifs(this, mOffset)
    }

    override fun onSearchInit(search: String) {
        mITrendingView.showProgress()
        trendingInteractor.onSearchInitialised(this, search)
    }


    override fun onTrendingFetchSuccess(giphyModel: GiphyModel) {
        mITrendingView.onTrendingDataReceived(giphyModel)
        mITrendingView.hideProgress()
    }

    override fun onTrendingFetchFail(error: String) {
        mITrendingView.showError(error)
        mITrendingView.hideProgress()
    }

    override fun onSearchSuccess(giphyModel: GiphyModel, query: String) {
        mITrendingView.onSearchDataReceived(giphyModel, query)
        mITrendingView.hideProgress()
    }

    override fun onSearchFail(error: String) {
        mITrendingView.showError(error)
        mITrendingView.hideProgress()
    }

}