package com.vinodmorya.giphy.ui.support.network

import com.orhanobut.logger.Logger
import com.vinodmorya.giphy.ui.trending.GiphyModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.Subject

class NetworkDataManager private constructor() {

    init {
        apiClient = NetworkClientRx.INSTANCE.api!!
    }

    fun fetchTrendingData(token: String, offset: Int, callbacks: NetworkCallbackInterfaces.TrendingCallbacks) {

        Logger.e("API request initiated")
        apiClient.giphyTrending(token, 50, offset, "G")
                .compose(NetworkClientRx.INSTANCE.ioMain())
                .subscribe(object : Subject<GiphyModel>() {
                    override fun hasObservers(): Boolean {
                        return false
                    }

                    override fun hasThrowable(): Boolean {
                        Logger.e("api hasComplete")

                        return false
                    }

                    override fun hasComplete(): Boolean {
                        Logger.e("api hasComplete")
                        return false
                    }

                    override fun getThrowable(): Throwable? {
                        return null
                    }

                    override fun subscribeActual(observer: Observer<in GiphyModel>) {

                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(giphyBeans: GiphyModel) {
                        callbacks.onTrendingSuccess(giphyBeans)
                    }

                    override fun onError(e: Throwable) {
                        callbacks.onTrendingFailed(e.localizedMessage)
                    }

                    override fun onComplete() {
                        Logger.e("api completed")
                    }
                })
    }

    fun searchGifs(token: String, query: String, callbacks: NetworkCallbackInterfaces.SearchCallbacks) {

        apiClient.giphySearch(token, query, 50, "G", 0, "en")
                .compose(NetworkClientRx.INSTANCE.ioMain())
                .subscribe(object : Subject<GiphyModel>() {
                    override fun hasObservers(): Boolean {
                        return false
                    }

                    override fun hasThrowable(): Boolean {
                        return false
                    }

                    override fun hasComplete(): Boolean {
                        return false
                    }

                    override fun getThrowable(): Throwable? {
                        return null
                    }

                    override fun subscribeActual(observer: Observer<in GiphyModel>) {

                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(giphyBeans: GiphyModel) {
                        callbacks.onSearchSuccess(giphyBeans, query)
                    }

                    override fun onError(e: Throwable) {
                        Logger.e(e.localizedMessage)
                        callbacks.onSeachFailed("error while searching. Try again")
                    }

                    override fun onComplete() {

                    }
                })
    }

    companion object {

        private var instance: NetworkDataManager? = null
        private lateinit var apiClient: ApiInterface

        fun getInstance(): NetworkDataManager {
            if (instance == null) {
                instance = NetworkDataManager()
            }
            return instance as NetworkDataManager
        }
    }

}