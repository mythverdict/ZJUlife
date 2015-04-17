/*
 * @author Fan Wei
 */
package com.zju.isee.zjulife;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

@SuppressLint("DefaultLocale")
public class SearchAll extends Activity {
	private ListView sortListView;
//	private SideBar sideBar;
	/**
	 * 显示字母的TextView
	 */
	private SearchAdapter_all adapter;
	private ClearEditText mClearEditText;
	
	/**
	 * 汉字转换成拼音的类
	 */
	private CharacterParser characterParser;
	private List<SortModel> SourceDateList;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_all);
		initViews();
	}

	private void initViews() {
		//实例化汉字转拼音类
		characterParser = CharacterParser.getInstance();
		
		new PinyinComparator();
		
		sortListView = (ListView) findViewById(R.id.search_items);
		sortListView.setOnItemClickListener(new OnItemClickListener() {
			
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			    Intent intent= new Intent();        
			    intent.setAction(((SortModel)adapter.getItem(position)).getActivity());    
			    startActivity(intent);
			}
		});
		
		SourceDateList = filledData(getResources().getStringArray(R.array.allSorts), getResources().getStringArray(R.array.keyWords), getResources().getStringArray(R.array.activity));
		
		adapter = new SearchAdapter_all(this, SourceDateList);
		sortListView.setAdapter(adapter);
		
		
		mClearEditText = (ClearEditText) findViewById(R.id.searchall_filter_edit);
		
		//根据输入框输入值的改变来过滤搜索
		mClearEditText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				//当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
				filterData(s.toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}


	/**
	 * 为ListView填充数据
	 * @param date
	 * @return
	 */
	private List<SortModel> filledData(String [] date, String[] keyWords, String[] activity){
		List<SortModel> mSortList = new ArrayList<SortModel>();
		
		for(int i=0; i<date.length; i++){
			SortModel sortModel = new SortModel();
			sortModel.setName(date[i]);
			sortModel.setKeyWords(keyWords[i]);
			sortModel.setActivity(activity[i]);
			//汉字转换成拼音
			String pinyin = characterParser.getSelling(date[i]);
			String sortString = pinyin.substring(0, 1).toUpperCase();
			
			// 正则表达式，判断首字母是否是英文字母
			if(sortString.matches("[A-Z]")){
				sortModel.setSortLetters(sortString.toUpperCase());
			}else{
				sortModel.setSortLetters("#");
			}
			
			mSortList.add(sortModel);
		}
		return mSortList;
		
	}
	
	/**
	 * 根据输入框中的值来过滤数据并更新ListView
	 * @param filterStr
	 */
	private void filterData(String filterStr) {
		List<SortModel> filterDateList = new ArrayList<SortModel>();

		if (TextUtils.isEmpty(filterStr)) {
			filterDateList = SourceDateList;
		} else {
			filterDateList.clear();
			for (SortModel sortModel : SourceDateList) {
				String name = sortModel.getName();
				String keyWords = sortModel.getKeyWords();
				if (name.toUpperCase().indexOf(
						filterStr.toString().toUpperCase()) != -1
						|| characterParser.getSelling(name).toUpperCase()
								.startsWith(filterStr.toString().toUpperCase())||keyWords.toUpperCase().indexOf(
										filterStr.toString().toUpperCase()) != -1
										|| characterParser.getSelling(keyWords).toUpperCase()
												.startsWith(filterStr.toString().toUpperCase())) {
					filterDateList.add(sortModel);
				}
			}
		}
		
//		// 根据a-z进行排序
//		Collections.sort(filterDateList, pinyinComparator);
		adapter.updateListView(filterDateList);
	}
}