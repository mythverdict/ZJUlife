/*
 * @author Fan Wei
 */
package com.zju.isee.zjulife;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

public class SearchAdapter_all extends BaseAdapter implements SectionIndexer{
	private List<SortModel> list = null;
	private Context mContext;
	
	public SearchAdapter_all(Context mContext, List<SortModel> list) {
		this.mContext = mContext;
		this.list = list;
	}
	
	/**
	 * 当ListView数据发生变化时,调用此方法来更新ListView
	 * @param list
	 */
	public void updateListView(List<SortModel> list){
		this.list = list;
		notifyDataSetChanged();
	}

	public int getCount() {
		return this.list.size();
	}

	public Object getItem(int position) {
		return list.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("InflateParams") public View getView(final int position, View view, ViewGroup arg2) {
		ViewHolder viewHolder = null;
		final SortModel mContent = list.get(position);
		if (view == null) {
			viewHolder = new ViewHolder();
			view = LayoutInflater.from(mContext).inflate(R.layout.list_item2, null);
			viewHolder.tvTitle = (TextView) view.findViewById(R.id.title);
			viewHolder.tvinfo = (TextView) view.findViewById(R.id.info);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
	
		viewHolder.tvTitle.setText(this.list.get(position).getName());
		viewHolder.tvinfo.setText(mContent.getKeyWords());
		return view;

	}
	


	final static class ViewHolder {
		TextView tvinfo;
		TextView tvTitle;
	}


	@Override
	public Object[] getSections() {
		return null;

	}

	@Override
	public int getPositionForSection(int sectionIndex)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSectionForPosition(int position)
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
