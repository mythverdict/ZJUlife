/*
 * @author Fan Wei
 * original code from Internet and modified by fanwei 
 */
package com.zju.isee.zjulife;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;


@SuppressLint("InflateParams") 
public class SwitchFragment extends Fragment
{
	private LinearLayout groupViewL1;
	private ViewPager viewPager;

	private ImageView[] imageViews;
	private ImageView imageView;

	private List<View> viewList = new ArrayList<View>();
	private LayoutInflater myInflater;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		super.onCreateView(inflater, container, savedInstanceState);
		View switchView = inflater.inflate(R.layout.fragment_switch, container, false);
		myInflater = inflater;

		groupViewL1 = (LinearLayout)switchView.findViewById(R.id.viewGroup);
		viewPager = (ViewPager)switchView.findViewById(R.id.viewPager);
		return switchView;
	}

	@SuppressLint("InflateParams") @Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		/**
		 * 将需要滑动的View添加到viewList当中
		 **/
		View oneView = myInflater.inflate(R.layout.sort_one, null);
		viewList.add(oneView);
		viewList.add(myInflater.inflate(R.layout.sort_two, null));
		viewList.add(myInflater.inflate(R.layout.sort_three, null));
		viewList.add(myInflater.inflate(R.layout.sort_four, null));
		viewList.add(myInflater.inflate(R.layout.sort_five, null));
		/**
		 * 定义圆点滑动导航ImageView，实现顶部圆点，根据View的个数而定
		 **/
		imageViews = new ImageView[viewList.size()];
		for (int i = 0; i < viewList.size(); i++)
		{
			imageView = new ImageView(this.getActivity());
			imageView.setLayoutParams(new LayoutParams(60, 30));
			imageViews[i] = imageView;

			if (i == 0)
			{
				imageViews[i].setBackgroundResource(R.drawable.focused);
			} else
			{
				imageViews[i].setBackgroundResource(R.drawable.indicator);
			}
			
			groupViewL1.addView(imageViews[i]);
		}
		
		/**
		 * 通过滑动适配器实现滑动效果
		 **/
		viewPager.setAdapter(new PageAdapter(viewList));
		viewPager.setOnPageChangeListener(new SwitchPageChangeListener());
	}

	@Override
	public void onResume()
	{
		super.onResume();
	}
	
	class SwitchPageChangeListener implements OnPageChangeListener
	{

		@Override
		public void onPageScrollStateChanged(int arg0)
		{
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2)
		{
			
		}

		@Override
		public void onPageSelected(int arg0)
		{
			
			for (int i = 0; i < imageViews.length; i++)
			{
				imageViews[arg0].setBackgroundResource(R.drawable.focused);
				
				if (arg0 != i)
				{
					imageViews[i].setBackgroundResource(R.drawable.indicator);
				}
			}
			

		}
		
	}
}
