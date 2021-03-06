/*
 * @author Fan Wei
 */
package com.zju.isee.zjulife;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

@SuppressLint({ "ViewHolder", "InflateParams" })
public class GridViewAdapter extends BaseAdapter {
	
	private ArrayList<String> adapterList;
	private Context mContext;
	private LayoutInflater inflater;
	public GridViewAdapter(Context context,ArrayList<String> dataList){
		mContext = context;
		inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		adapterList = dataList;
		
	}
	
	@Override
	public int getCount() {
		
		return adapterList.size();
	}

	@Override
	public Object getItem(int position) {
		
		return position;
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		convertView = inflater.inflate(R.layout.pop_list_item, null);
		TextView tv = (TextView) convertView.findViewById(R.id.grid_item_tv);
		tv.setText(adapterList.get(position));
		return convertView;
	}

}
