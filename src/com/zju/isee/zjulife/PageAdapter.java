/*
 * @author Fan Wei
 */
package com.zju.isee.zjulife;

import java.util.List;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class PageAdapter extends PagerAdapter
{
	private List<View> viewList;
	public PageAdapter(List<View> viewList)
	{
		this.viewList = viewList;
	}
	

	@Override
	public int getCount()
	{
		return viewList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1)
	{
		return (arg0 == arg1);
	}


	@Override
	public void destroyItem(View container, int position, Object object)
	{
		((ViewPager)container).removeView(viewList.get(position));
	}


	@Override
	public void finishUpdate(View container)
	{
	}


	@Override
	public int getItemPosition(Object object)
	{
		return super.getItemPosition(object);
	}


	@Override
	public Object instantiateItem(View container, int position)
	{
		((ViewPager)container).addView(viewList.get(position));
		return viewList.get(position);
	}


	@Override
	public void restoreState(Parcelable state, ClassLoader loader)
	{
	}


	@Override
	public void startUpdate(View container)
	{
	}


	@Override
	public Parcelable saveState()
	{
		return null;
	}

	
}
