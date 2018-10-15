package com.vinodmorya.giphy.ui.roomDatabase.GiphyRoom;

import com.vinodmorya.giphy.ui.trending.GiphyModelGif;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
interface GiphyDAO
  {
	 @Insert(onConflict = OnConflictStrategy.REPLACE)
	 long insertGif(GiphyModelGif gif);

	 @Insert(onConflict = OnConflictStrategy.IGNORE)
	 void insertGifs(List<GiphyModelGif> list);

	 @Update
	 void updateGif(GiphyModelGif gif);

	 @Delete
	 void deleteGif(GiphyModelGif gif);

	 @Query("SELECT * FROM GifTable where searchTag In (:query) ORDER BY trendingDatetime DESC")
	 LiveData<List<GiphyModelGif>> getGifs(String query);

	 @Query("SELECT * FROM GifTable  where checked = 1 ORDER BY trendingDatetime DESC")
	 LiveData<List<GiphyModelGif>> getAllFavoriteGifs();

	 @Query("DELETE FROM GifTable where checked = 0")
	 void deleteAllGifsExceptFavorite();
  }
