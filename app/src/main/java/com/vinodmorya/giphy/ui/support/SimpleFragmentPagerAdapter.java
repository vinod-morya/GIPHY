package com.vinodmorya.giphy.ui.support;

import android.content.Context;

import com.vinodmorya.giphy.R;
import com.vinodmorya.giphy.ui.trending.TrendingFragment;
import com.vinodmorya.giphy.ui.favorites.FavoriteFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter
  {

	 private final Context mContext;

	 public SimpleFragmentPagerAdapter(Context context, FragmentManager fm)
		{
		  super(fm);
		  mContext = context;
		}

	 // This determines the fragment for each tab
	 @Override
	 public Fragment getItem(int position)
		{
		  if(position == 0)
		  {
			 return new TrendingFragment();
		  }
		  else if(position == 1)
		  {
			 return new FavoriteFragment();
		  }
		  return null;
		}

	 // This determines the number of tabs
	 @Override
	 public int getCount()
		{
		  return 2;
		}

	 // This determines the title for each tab
	 @Override
	 public CharSequence getPageTitle(int position)
		{
		  // Generate title based on item position
		  switch(position)
		  {
			 case 0:
				return mContext.getString(R.string.tab_first);
			 case 1:
				return mContext.getString(R.string.tab_second);
			 default:
				return null;
		  }
		}
  }