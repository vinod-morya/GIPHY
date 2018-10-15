package com.vinodmorya.giphy.ui.roomDatabase.GiphyRoom;

import com.vinodmorya.giphy.ui.trending.GiphyModelGif;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {GiphyModelGif.class}, version = 2, exportSchema = false)
public abstract class FreshWorksDatabse extends RoomDatabase
  {
	 public abstract GiphyDAO GiphyDatabase();
  }
