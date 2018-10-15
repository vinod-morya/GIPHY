package com.vinodmorya.giphy.ui.roomDatabase;

import android.content.Context;

import com.vinodmorya.giphy.ui.roomDatabase.GiphyRoom.FreshWorksDatabse;

import androidx.room.Room;

public class DatabaseCreator
  {
	 private static FreshWorksDatabse sGiphyDatabase;
	 private static final Object LOCK = new Object();

	 public synchronized static FreshWorksDatabse getGiphyDatabase(Context context)
		{
		  if(sGiphyDatabase == null)
		  {
			 synchronized(LOCK)
			 {
				if(sGiphyDatabase == null)
				{
				  sGiphyDatabase = Room.databaseBuilder(context, FreshWorksDatabse.class, "freshWorks.db").fallbackToDestructiveMigration().build();
				}
			 }
		  }
		  return sGiphyDatabase;
		}
  }
