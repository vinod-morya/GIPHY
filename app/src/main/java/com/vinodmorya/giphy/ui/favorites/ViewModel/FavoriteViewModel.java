package com.vinodmorya.giphy.ui.favorites.ViewModel;

import android.app.Application;

import com.vinodmorya.giphy.ui.trending.GiphyModelGif;
import com.vinodmorya.giphy.ui.roomDatabase.GiphyRoom.GiphyRepository;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Transformations;

public class FavoriteViewModel extends AndroidViewModel
  {
	 private final GiphyRepository gifRepository = new GiphyRepository(getApplication());
	 private final Executor executor = Executors.newFixedThreadPool(2);
	 private final MediatorLiveData<String> searchQueryData = new MediatorLiveData<>();
	 private final LiveData<List<GiphyModelGif>> gifModels = Transformations.switchMap(searchQueryData, gifRepository::searchGifs);

	 public FavoriteViewModel(@NonNull Application application)
		{
		  super(application);
		}

	 public void addGif(GiphyModelGif gif)
		{
		  executor.execute(() -> gifRepository.addGif(gif));
		}

	 public void updateGif(GiphyModelGif gif)
		{
		  executor.execute(() -> gifRepository.updateGif(gif));
		}

	 public void addGifs(ArrayList<GiphyModelGif> gif)
		{
		  executor.execute(() -> gifRepository.addGifs(gif));
		}


	 public LiveData<List<GiphyModelGif>> getAllFavoriteGifs()
		{
		  return gifRepository.getAllFavoriteGifs();
		}

	 public void deleteAllTrendingGifs()
		{
		  executor.execute(gifRepository::deleteAllGifsExceptFav);
		}

	 @NotNull
	 public LiveData<List<GiphyModelGif>> getGifsBySearch()
		{
		  return gifModels;
		}

	 public void setSearchQuery(String query)
		{
		  searchQueryData.setValue(query);
		}
  }
