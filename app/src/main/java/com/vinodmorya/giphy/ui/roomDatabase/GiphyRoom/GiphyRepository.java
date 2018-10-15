package com.vinodmorya.giphy.ui.roomDatabase.GiphyRoom;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.vinodmorya.giphy.ui.trending.GiphyModelGif;
import com.vinodmorya.giphy.ui.roomDatabase.DatabaseCreator;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;

public class GiphyRepository
  {
	 private final GiphyDAO mGiphyDAO;

	 public GiphyRepository(Context context)
		{
		  mGiphyDAO = DatabaseCreator.getGiphyDatabase(context).GiphyDatabase();
		}

	 public void addGif(GiphyModelGif gif)
		{
		   mGiphyDAO.insertGif(gif);
		}

	 public void addGifs(ArrayList<GiphyModelGif> gifs)
		{

		  mGiphyDAO.insertGifs(gifs);
		  Logger.e("db bulk insert ", "added " + gifs.size());
		}

	 public void updateGif(GiphyModelGif gif)
		{
		  mGiphyDAO.updateGif(gif);
		}

	 public void deleteGif(GiphyModelGif gif)
		{
		  mGiphyDAO.deleteGif(gif);
		  Logger.e("db delete ", "deleted " + gif.getId());
		}

	 public LiveData<List<GiphyModelGif>> getAllGifs()
		{
		  return mGiphyDAO.getGifs("");
		}

	 public void deleteAllGifsExceptFav()
		{
		  mGiphyDAO.deleteAllGifsExceptFavorite();
		  Logger.e("db bulk delete ", "deleted ");
		}

	 public LiveData<List<GiphyModelGif>> getAllFavoriteGifs()
		{
		  return mGiphyDAO.getAllFavoriteGifs();
		}

	 public LiveData<List<GiphyModelGif>> searchGifs(String query)
		{
		  return mGiphyDAO.getGifs(query);
		}
  }