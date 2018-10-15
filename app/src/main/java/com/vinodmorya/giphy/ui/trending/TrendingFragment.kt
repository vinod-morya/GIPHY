package com.vinodmorya.giphy.ui.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.orhanobut.logger.Logger
import com.paginate.Paginate
import com.paginate.recycler.LoadingListItemSpanLookup
import com.vinodmorya.giphy.R
import com.vinodmorya.giphy.ui.favorites.ViewModel.FavoriteViewModel
import com.vinodmorya.giphy.ui.support.networkState.NetworkStateReceiver
import com.vinodmorya.giphy.ui.support.util.LottieDialogFragment
import com.yinglan.keyboard.HideUtil
import kotlinx.android.synthetic.main.trending_fragment.*

class TrendingFragment : Fragment(), TrendingContracts.ITrendingView, FavoriteInterface, SwipeRefreshLayout.OnRefreshListener,
        SearchView.OnQueryTextListener, NetworkStateReceiver.NetworkStateReceiverListener, Paginate.Callbacks {

    companion object {
        fun newInstance() = TrendingFragment()
    }

    private var trendingViewModel: FavoriteViewModel? = null
    private lateinit var mTrendingPresenter: TrendingContracts.TrendingPresenter
    private var mGiphyModelGif: ArrayList<GiphyModelGif> = ArrayList()
    private lateinit var lottieDialog: LottieDialogFragment
    private var mQuery: String = ""
    private var paginate: Paginate? = null
    private var mOffset: Int = 0
    private var loading = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.trending_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        trendingViewModel = ViewModelProviders.of(this).get(FavoriteViewModel(activity!!.application)::class.java)
        trendingViewModel?.deleteAllTrendingGifs()
        setUpTheViews()
        initLoader()
        initObserver()
        mTrendingPresenter = TrendingPresenterImpl(this)
        setUpPagination()
    }

    private fun setUpPagination() {
        if (paginate != null) {
            paginate!!.unbind()
        }

        loading = false
        paginate = Paginate.with(rv_giphy, this)
                .setLoadingTriggerThreshold(2)
                .addLoadingListItem(false)
                .setLoadingListItemSpanSizeLookup(LoadingListItemSpanLookup { 1 })
                .build()

    }


    private fun initLoader() {
        lottieDialog = LottieDialogFragment().newInstance(null, true)
        lottieDialog.isCancelable = false
    }

    private fun setUpTheViews() {
        sRL_refresh.setOnRefreshListener(this)
        rv_giphy.layoutManager = LinearLayoutManager(activity)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
        rv_giphy.layoutManager = layoutManager
        rv_giphy.adapter = GifAdapter(mGiphyModelGif, this.context!!, this@TrendingFragment)

        sv_search.setOnQueryTextListener(this)
    }

    override fun onRefresh() {
        trendingViewModel?.deleteAllTrendingGifs()
        if (mQuery.isEmpty()) {
            mTrendingPresenter.fetchTrending(mOffset)
        } else {
            mTrendingPresenter.onSearchInit(mQuery)
        }
        sRL_refresh.isRefreshing = false
    }

    private fun initObserver() {
        observeGifsBySearch(trendingViewModel?.getGifsBySearch()!!)
    }

    private fun observeGifsBySearch(gifsBySearch: LiveData<MutableList<GiphyModelGif>>) {
        gifsBySearch.observe(this, Observer<MutableList<GiphyModelGif>> { gifList ->
            if (gifList?.isNotEmpty()!!) {
                mGiphyModelGif.clear()
                mGiphyModelGif.addAll(gifList as ArrayList)
            }
            rv_giphy.adapter?.notifyDataSetChanged()
            return@Observer
        })
    }


    override fun showProgress() {
        try {
            if (!lottieDialog.isAdded) {
                lottieDialog.show(fragmentManager, "progressLoader")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun hideProgress() {
        lottieDialog.dismissAllowingStateLoss()
    }

    override fun showError(error: String) {
        loading = false
        Toast.makeText(activity, error, Toast.LENGTH_SHORT).show()
    }

    override fun addToFavorite(gif: GiphyModelGif) {
        trendingViewModel?.updateGif(gif)
    }

    override fun removeFromFavorite(gif: GiphyModelGif) {
        trendingViewModel?.updateGif(gif)
    }

    override fun onTrendingDataReceived(giphyModel: GiphyModel) {
        loading = false
        if (giphyModel.gif != null) {
            trendingViewModel?.addGifs(giphyModel.gif!!)
            trendingViewModel?.setSearchQuery("")
        }
    }

    override fun onSearchDataReceived(giphyModel: GiphyModel, query: String) {
        if (giphyModel.gif != null) {
            for (giphyModel: GiphyModelGif in giphyModel.gif!!) {
                giphyModel.searchTag = query
                trendingViewModel?.addGif(giphyModel)
            }

            trendingViewModel?.setSearchQuery(query)
        }
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        Logger.e(query)
        mQuery = query
        HideUtil.hideSoftKeyboard(activity)
        mTrendingPresenter.onSearchInit(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        Logger.e(newText)
        if (newText.isBlank()) {
            mQuery = ""
            trendingViewModel?.setSearchQuery(mQuery)
        }
        return true
    }

    @Synchronized
    override fun onLoadMore() {
        if (mQuery.isEmpty()) {
            loading = true
            mOffset += mGiphyModelGif.size
            mTrendingPresenter.fetchTrending(mOffset)
        }
    }

    override fun isLoading(): Boolean {
        return loading
    }

    override fun hasLoadedAllItems(): Boolean {
        return false
    }

    override fun networkAvailable() {
    }

    override fun networkUnavailable() {
        loading = false
    }

}
