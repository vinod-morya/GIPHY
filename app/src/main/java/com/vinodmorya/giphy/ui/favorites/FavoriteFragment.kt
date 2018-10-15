package com.vinodmorya.giphy.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.vinodmorya.giphy.R
import com.vinodmorya.giphy.ui.favorites.ViewModel.FavoriteViewModel
import com.vinodmorya.giphy.ui.trending.FavoriteInterface
import com.vinodmorya.giphy.ui.trending.GifAdapter
import com.vinodmorya.giphy.ui.trending.GiphyModelGif
import kotlinx.android.synthetic.main.favorite_fragment.*

class FavoriteFragment : Fragment(), FavoriteInterface {

    private var favoriteViewModel: FavoriteViewModel? = null
    private var mGiphyModelFavGifs: ArrayList<GiphyModelGif> = ArrayList()

    companion object {
        fun newInstance() = FavoriteFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.favorite_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        favoriteViewModel = ViewModelProviders.of(this).get(FavoriteViewModel::class.java)
        initObserver()
        setUpTheViews()
    }

    private fun setUpTheViews() {
        rv_giphy_fav.layoutManager = LinearLayoutManager(activity)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
        rv_giphy_fav.layoutManager = layoutManager
        rv_giphy_fav.adapter = GifAdapter(mGiphyModelFavGifs, this.context!!, this@FavoriteFragment)
    }

    override fun addToFavorite(gif: GiphyModelGif) {

    }

    override fun removeFromFavorite(gif: GiphyModelGif) {
        favoriteViewModel?.updateGif(gif)
    }

    private fun initObserver() {
        observerPersonListResults(favoriteViewModel?.allFavoriteGifs!!)
    }

    private fun observerPersonListResults(allUsers: LiveData<MutableList<GiphyModelGif>>) {
        allUsers.observe(this, Observer<List<GiphyModelGif>> { gifList ->
            mGiphyModelFavGifs.clear()
            if (gifList?.isNotEmpty()!!) {
                mGiphyModelFavGifs.addAll(gifList as ArrayList)
//                    Toast.makeText(this@FavoriteFragment.context, "Number of person objects in the response: " + gifList?.size, Toast.LENGTH_LONG).show()
            }
            rv_giphy_fav.adapter?.notifyDataSetChanged()
        })
    }


}
