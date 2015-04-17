/*
 * @author Fan Wei
 */
package com.zju.isee.zjulife;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.zju.isee.zjulife.PinnedSectionListView.PinnedSectionListAdapter;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BusResult extends ListActivity implements OnClickListener 
{

		//下拉控件
		Spinner spinner1;
		Spinner spinner2;
		Spinner spinner3;
		Spinner spinner4;
			
		//文件的路径
		public final static String URL = "/data/data/com.zju.isee.zjulife/files";
		//数据库文件
		public final static String DB_FILE_NAME = "bus.db";
		// 归属地
		public final static String TABLE_NAME = "bus";
		// 索引ID
		public final static int ID_INDEX = 0;
		public final static int NUMBER_INDEX = 1;
		public final static int START_STOP_INDEX = 2;
		public final static int START_TIME_INDEX = 3;
		public final static int PASS_STOP1_INDEX = 4;
		public final static int PASS_TIME1_INDEX = 5;
		public final static int PASS_STOP2_INDEX = 6;
		public final static int PASS_TIME2_INDEX = 7;
		public final static int END_STOP_INDEX = 8;
		public final static int END_TIME_INDEX = 9;
		public final static int EXTRA_MESSAGE = 10;
		
		LayoutInflater layoutInflater;
		View view;
		static String[] schoolLocation = null;
		static String[] busTime = null;
		
		static SQLiteDatabase db = null;
		
		static int position1;
		static int position2;
		static int position3;
		static int position4;
		int position;
		static String info = null;
		
		//设置SECTION、ITEM的高宽等
//		static LayoutParams sectionParams = new LayoutParams(LayoutParams.MATCH_PARENT, 20);
	
    static class SimpleAdapter extends ArrayAdapter<Item> implements PinnedSectionListAdapter {

    	
    	String startStop = schoolLocation[position1];
		String endStop = schoolLocation[position2];
		String starttime = busTime[position3];
		String endtime = busTime[position4];

        public SimpleAdapter(Context context, int resource, int textViewResourceId) {
            super(context, resource, textViewResourceId);
            generateDataset(1, 22, false);
        }
        
        public void generateDataset(int k, int l, boolean clear) {
        	
        	if (clear) clear();
        	//查询结果是否为空标志
        	int s=0;
        	
            final int sectionsNumber = l - k + 1;
            prepareSections(sectionsNumber);

            int sectionPosition = 0, listPosition = 0;
            for (int i=1; i<=sectionsNumber; i++) {
            	Cursor cursor1 = null;
            	Cursor cursor2 = null;
            	Cursor cursor3 = null;
            	Cursor cursor4 = null;
            	Cursor cursor5 = null;
            	Cursor cursor6 = null;
            	if(i <= 16){
            	cursor1 = db.query("bus", null, "_charater_id='"+i+"号班车"+"'"+"and start_stop='" +startStop + "'" + "and pass_stop1='" +endStop+ "'" + "and start_time>='" +starttime+ "'"+ "and start_time<='" +endtime+ "'", null, null, null, null);
            	cursor2 = db.query("bus", null, "_charater_id='"+i+"号班车"+"'"+"and start_stop='" +startStop + "'" + "and pass_stop2='" +endStop+ "'" + "and start_time>='" +starttime+ "'"+ "and start_time<='" +endtime+ "'", null, null, null, null);
    			cursor3 = db.query("bus", null, "_charater_id='"+i+"号班车"+"'"+"and start_stop='" +startStop + "'" + "and end_stop='" +endStop+ "'" + "and start_time>='" +starttime+ "'"+ "and start_time<='" +endtime+ "'", null, null, null, null);
    			cursor4 = db.query("bus", null, "_charater_id='"+i+"号班车"+"'"+"and pass_stop1='" +startStop + "'" + "and pass_stop2='" +endStop+ "'"+"and start_time>'"+starttime+"'", null, null, null, null);
    			cursor5 = db.query("bus", null, "_charater_id='"+i+"号班车"+"'"+"and pass_stop1='" +startStop + "'" + "and end_stop='" +endStop+ "'"+"and start_time>'"+starttime+"'", null, null, null, null);
    			cursor6 = db.query("bus", null, "_charater_id='"+i+"号班车"+"'"+"and pass_stop2='" +startStop + "'" + "and end_stop='" +endStop+ "'" + "and start_time>'" +starttime+ "'", null, null, null, null);
            	}
            	if (i == 17) {
            		cursor1 = db.query("bus", null, "_charater_id='"+"学生教学专用"+(i-16)+"号班车"+"'"+"and start_stop='" +startStop + "'" + "and pass_stop1='" +endStop+ "'" + "and start_time>='" +starttime+ "'"+ "and start_time<='" +endtime+ "'", null, null, null, null);
                	cursor2 = db.query("bus", null, "_charater_id='"+"学生教学专用"+(i-16)+"号班车"+"'"+"and start_stop='" +startStop + "'" + "and pass_stop2='" +endStop+ "'" + "and start_time>='" +starttime+ "'"+ "and start_time<='" +endtime+ "'", null, null, null, null);
        			cursor3 = db.query("bus", null, "_charater_id='"+"学生教学专用"+(i-16)+"号班车"+"'"+"and start_stop='" +startStop + "'" + "and end_stop='" +endStop+ "'" + "and start_time>='" +starttime+ "'"+ "and start_time<='" +endtime+ "'", null, null, null, null);
        			cursor4 = db.query("bus", null, "_charater_id='"+"学生教学专用"+(i-16)+"号班车"+"'"+"and pass_stop1='" +startStop + "'" + "and pass_stop2='" +endStop+ "'"+"and start_time>'"+starttime+"'", null, null, null, null);
        			cursor5 = db.query("bus", null, "_charater_id='"+"学生教学专用"+(i-16)+"号班车"+"'"+"and pass_stop1='" +startStop + "'" + "and end_stop='" +endStop+ "'"+"and start_time>'"+starttime+"'", null, null, null, null);
        			cursor6 = db.query("bus", null, "_charater_id='"+"学生教学专用"+(i-16)+"号班车"+"'"+"and pass_stop2='" +startStop + "'" + "and end_stop='" +endStop+ "'" + "and start_time>'" +starttime+ "'", null, null, null, null);
				}
            	if (i>=18 && i <= 20) {
            		cursor1 = db.query("bus", null, "_charater_id='"+"校区间"+(i-17)+"号班车"+"'"+"and start_stop='" +startStop + "'" + "and pass_stop1='" +endStop+ "'" + "and start_time>='" +starttime+ "'"+ "and start_time<='" +endtime+ "'", null, null, null, null);
                	cursor2 = db.query("bus", null, "_charater_id='"+"校区间"+(i-17)+"号班车"+"'"+"and start_stop='" +startStop + "'" + "and pass_stop2='" +endStop+ "'" + "and start_time>='" +starttime+ "'"+ "and start_time<='" +endtime+ "'", null, null, null, null);
        			cursor3 = db.query("bus", null, "_charater_id='"+"校区间"+(i-17)+"号班车"+"'"+"and start_stop='" +startStop + "'" + "and end_stop='" +endStop+ "'" + "and start_time>='" +starttime+ "'"+ "and start_time<='" +endtime+ "'", null, null, null, null);
        			cursor4 = db.query("bus", null, "_charater_id='"+"校区间"+(i-17)+"号班车"+"'"+"and pass_stop1='" +startStop + "'" + "and pass_stop2='" +endStop+ "'"+"and start_time>'"+starttime+"'", null, null, null, null);
        			cursor5 = db.query("bus", null, "_charater_id='"+"校区间"+(i-17)+"号班车"+"'"+"and pass_stop1='" +startStop + "'" + "and end_stop='" +endStop+ "'"+"and start_time>'"+starttime+"'", null, null, null, null);
        			cursor6 = db.query("bus", null, "_charater_id='"+"校区间"+(i-17)+"号班车"+"'"+"and pass_stop2='" +startStop + "'" + "and end_stop='" +endStop+ "'" + "and start_time>'" +starttime+ "'", null, null, null, null);
				}
            	if(i>=21 && i <= 22){
            		cursor1 = db.query("bus", null, "_charater_id='"+"研究生"+(i-20)+"号班车"+"'"+"and start_stop='" +startStop + "'" + "and pass_stop1='" +endStop+ "'" + "and start_time>='" +starttime+ "'"+ "and start_time<='" +endtime+ "'", null, null, null, null);
                	cursor2 = db.query("bus", null, "_charater_id='"+"研究生"+(i-20)+"号班车"+"'"+"and start_stop='" +startStop + "'" + "and pass_stop2='" +endStop+ "'" + "and start_time>='" +starttime+ "'"+ "and start_time<='" +endtime+ "'", null, null, null, null);
        			cursor3 = db.query("bus", null, "_charater_id='"+"研究生"+(i-20)+"号班车"+"'"+"and start_stop='" +startStop + "'" + "and end_stop='" +endStop+ "'" + "and start_time>='" +starttime+ "'"+ "and start_time<='" +endtime+ "'", null, null, null, null);
        			cursor4 = db.query("bus", null, "_charater_id='"+"研究生"+(i-20)+"号班车"+"'"+"and pass_stop1='" +startStop + "'" + "and pass_stop2='" +endStop+ "'"+"and start_time>'"+starttime+"'", null, null, null, null);
        			cursor5 = db.query("bus", null, "_charater_id='"+"研究生"+(i-20)+"号班车"+"'"+"and pass_stop1='" +startStop + "'" + "and end_stop='" +endStop+ "'"+"and start_time>'"+starttime+"'", null, null, null, null);
        			cursor6 = db.query("bus", null, "_charater_id='"+"研究生"+(i-20)+"号班车"+"'"+"and pass_stop2='" +startStop + "'" + "and end_stop='" +endStop+ "'" + "and start_time>'" +starttime+ "'", null, null, null, null);
				}
            	if (cursor1.getCount()+cursor2.getCount()+cursor3.getCount()+cursor4.getCount()+cursor5.getCount()+cursor6.getCount() == 0)
				{
					continue;
				}
            	s=1;
    			Item section = new Item(Item.SECTION, (i<=16?i+"号班车":(i==17?"学生教学专用"+(i-16)+"号班车":(i<=20?"校区间"+(i-17)+"号班车":"研究生"+(i-20)+"号班车"))));
            	section.listPosition = listPosition;
            	section.listPosition = listPosition++;
            	onSectionAdded(section, sectionPosition);
            	add(section);

            	if (cursor1 != null && cursor1.moveToNext())
				{
					while ((!cursor1.isAfterLast()))
					{
						if(cursor1.getString(PASS_TIME1_INDEX)==null)
			        	{
			        		info = cursor1.getString(START_TIME_INDEX) + "--"+"不确定";
			        	}
			        	else
			        	{
							info = cursor1.getString(START_TIME_INDEX) + "--" + cursor1.getString(PASS_TIME1_INDEX);
						}
						Item item = new Item(Item.ITEM, cursor1.getString(START_STOP_INDEX) + "→" + cursor1.getString(PASS_STOP1_INDEX) +"\n"+ info +"\n"+ ((cursor1.getString(EXTRA_MESSAGE)!=null)?("*"+cursor1.getString(EXTRA_MESSAGE)):""));
	                    item.sectionPosition = sectionPosition;
	                    item.listPosition = listPosition++;
						add(item);
						cursor1.moveToNext();
					}
                }
            	
            	if (cursor2 != null && cursor2.moveToFirst())
    			{
    				while((!cursor2.isAfterLast()))
    				{
    		        	if(cursor2.getString(PASS_TIME2_INDEX)==null)
    		        	{
    		        		info = cursor2.getString(START_TIME_INDEX) + "--"+"不确定";
    		        	}
    		        	else
    		        	{
    						info = cursor2.getString(START_TIME_INDEX) + "--" + cursor2.getString(PASS_TIME2_INDEX);
    					}
    		        	Item item = new Item(Item.ITEM, cursor2.getString(START_STOP_INDEX) +"→"+ cursor2.getString(PASS_STOP2_INDEX) +"\n"+info+"\n"+ ((cursor2.getString(EXTRA_MESSAGE)!=null)?("*"+cursor2.getString(EXTRA_MESSAGE)):""));
	                    item.sectionPosition = sectionPosition;
	                    item.listPosition = listPosition++;
						add(item);    		        	
    					cursor2.moveToNext();
    					}
    			}
            	
            	if (cursor3 != null && cursor3.moveToFirst()) 
    			{
    				while((!cursor3.isAfterLast()))
    				{
    		        	if(cursor3.getString(END_TIME_INDEX)==null)
    		        	{
    		        		info = cursor3.getString(START_TIME_INDEX) + "--"+"不确定";
    		        	}
    		        	if(cursor3.getString(END_TIME_INDEX)!=null)
    		        	{
    						info = cursor3.getString(START_TIME_INDEX) + "--" + cursor3.getString(END_TIME_INDEX);
    					}
    		        	Item item = new Item(Item.ITEM, cursor3.getString(START_STOP_INDEX) +"→"+ cursor3.getString(END_STOP_INDEX) +"\n"+info+"\n"+ ((cursor3.getString(EXTRA_MESSAGE)!=null)?("*"+cursor3.getString(EXTRA_MESSAGE)):""));
	                    item.sectionPosition = sectionPosition;
	                    item.listPosition = listPosition++;
						add(item);
    					cursor3.moveToNext();
    					}
    			}
            	
            	if (cursor4 != null && cursor4.moveToFirst())
    			{
    				while((!cursor4.isAfterLast()))
    				{
    					if(cursor4.getString(PASS_TIME1_INDEX)==null && cursor4.getString(PASS_TIME2_INDEX)!=null)
    					{
    						info = cursor4.getString(START_TIME_INDEX) + "--" + "不确定" +"--"+ cursor4.getString(PASS_TIME2_INDEX) + "--" + cursor4.getString(END_TIME_INDEX);
    					}
    					if(cursor4.getString(PASS_TIME1_INDEX)!=null && cursor4.getString(PASS_TIME2_INDEX)==null)
    					{
    						info = cursor4.getString(START_TIME_INDEX) + "--"+ cursor4.getString(PASS_TIME1_INDEX) +"--"+ "不确定" + "--"+  cursor4.getString(END_TIME_INDEX);
    					}
    					if(cursor4.getString(PASS_TIME1_INDEX)!=null && cursor4.getString(PASS_TIME2_INDEX)!=null)
    					{
    						info = cursor4.getString(START_TIME_INDEX) + "--"+ cursor4.getString(PASS_TIME1_INDEX) + "--"+cursor4.getString(PASS_TIME2_INDEX) + "--"+  cursor4.getString(END_TIME_INDEX);
    					}
    					Item item = new Item(Item.ITEM, cursor4.getString(START_STOP_INDEX) +"→"+ cursor4.getString(PASS_STOP1_INDEX) +"→"+ cursor4.getString(PASS_STOP2_INDEX) +"→"+ cursor4.getString(END_STOP_INDEX) +"\n"+info+"\n"+ ((cursor4.getString(EXTRA_MESSAGE)!=null)?("*"+cursor4.getString(EXTRA_MESSAGE)):""));
	                    item.sectionPosition = sectionPosition;
	                    item.listPosition = listPosition++;
						add(item);
    		            cursor4.moveToNext();
    				}
    			}
            	
            	if (cursor5 != null && cursor5.moveToFirst())
    			{
    				while((!cursor5.isAfterLast()))
    				{
    					if (cursor5.getString(PASS_TIME1_INDEX)==null && cursor5.getString(END_TIME_INDEX)!=null && cursor5.getString(PASS_TIME2_INDEX)==null)
    					{
    						info = cursor5.getString(START_STOP_INDEX) +"→"+ cursor5.getString(PASS_STOP1_INDEX) +"→"+ cursor5.getString(END_STOP_INDEX) + "\n" +
    							   cursor5.getString(START_TIME_INDEX) + "--" + "不确定" + "--" + cursor5.getString(END_TIME_INDEX);
    					}
    					if (cursor5.getString(PASS_TIME1_INDEX)==null && cursor5.getString(END_TIME_INDEX)!=null && cursor5.getString(PASS_TIME2_INDEX)!=null)
    					{
    						info = cursor5.getString(START_STOP_INDEX) +"→"+ cursor5.getString(PASS_STOP1_INDEX) +"→"+ cursor5.getString(PASS_STOP2_INDEX) + "→" + cursor5.getString(END_STOP_INDEX) + "\n" +
    							   cursor5.getString(START_TIME_INDEX) +"--"+ "不确定" +"--"+ cursor5.getString(PASS_TIME2_INDEX) + "--" + cursor5.getString(END_TIME_INDEX);
    					}
    					if (cursor5.getString(PASS_TIME1_INDEX)!=null && cursor5.getString(END_TIME_INDEX)==null)
    					{
    						info = cursor5.getString(START_STOP_INDEX) +"→"+ cursor5.getString(PASS_STOP1_INDEX) +"→" + cursor5.getString(END_STOP_INDEX) + "\n" +
    							   cursor5.getString(START_TIME_INDEX) +"--"+ cursor5.getString(PASS_TIME1_INDEX) + "--" + "不确定";
    					}
    					if (cursor5.getString(PASS_TIME1_INDEX)!=null && cursor5.getString(END_TIME_INDEX)!=null)
    					{
    						info = cursor5.getString(START_STOP_INDEX) +"→"+ cursor5.getString(PASS_STOP1_INDEX) +"→" + cursor5.getString(END_STOP_INDEX) + "\n" +
    							   cursor5.getString(START_TIME_INDEX) +"--"+ cursor5.getString(PASS_TIME1_INDEX) + "--" + cursor5.getString(END_TIME_INDEX);
    					}
    					Item item = new Item(Item.ITEM, info+"\n"+ ((cursor5.getString(EXTRA_MESSAGE)!=null)?("*"+cursor5.getString(EXTRA_MESSAGE)):""));
	                    item.sectionPosition = sectionPosition;
	                    item.listPosition = listPosition++;
						add(item);
    		            cursor5.moveToNext();
    				}
    			}
            	
            	if (cursor6 != null && cursor6.moveToFirst())
    			{
    				while((!cursor6.isAfterLast()))
    				{
    					if (cursor6.getString(PASS_TIME2_INDEX)==null && cursor6.getString(END_TIME_INDEX)!=null && cursor6.getString(PASS_TIME1_INDEX)==null)
    					{
    						info = cursor6.getString(START_STOP_INDEX)+"→"+cursor6.getString(PASS_STOP2_INDEX) +"→"+cursor6.getString(END_STOP_INDEX)+"\n"+
    							   cursor6.getString(START_TIME_INDEX)+"--"+"不确定"+"--"+cursor6.getString(END_TIME_INDEX);
    					}
    					if (cursor6.getString(PASS_TIME2_INDEX)==null && cursor6.getString(END_TIME_INDEX)!=null && cursor6.getString(PASS_TIME1_INDEX)!=null)
    					{
    						info = cursor6.getString(START_STOP_INDEX)+"→"+cursor6.getString(PASS_STOP1_INDEX)+"→"+cursor6.getString(PASS_STOP2_INDEX) +"→"+cursor6.getString(END_STOP_INDEX)+"\n"+
    							   cursor6.getString(START_TIME_INDEX)+"--"+cursor6.getString(PASS_TIME1_INDEX)+"--"+"不确定"+"--"+cursor6.getString(END_TIME_INDEX);
    					}
    					if (cursor6.getString(PASS_TIME2_INDEX)!=null && cursor6.getString(END_TIME_INDEX)==null)
    					{
    						info = cursor6.getString(PASS_STOP2_INDEX)+"→"+cursor6.getString(END_STOP_INDEX)+"\n"+
    							   cursor6.getString(PASS_TIME2_INDEX)+"--"+"不确定";
    					}
    					if (cursor6.getString(PASS_TIME2_INDEX)!=null && cursor6.getString(END_TIME_INDEX)!=null)
    					{
    						info = cursor6.getString(PASS_STOP2_INDEX)+"→"+cursor6.getString(END_STOP_INDEX)+"\n"+
    							   cursor6.getString(PASS_TIME2_INDEX)+"--"+cursor6.getString(END_TIME_INDEX);
    					}
    					Item item = new Item(Item.ITEM, info+"\n"+ ((cursor6.getString(EXTRA_MESSAGE)!=null)?("*"+cursor6.getString(EXTRA_MESSAGE)):""));
	                    item.sectionPosition = sectionPosition;
	                    item.listPosition = listPosition++;
						add(item);
    		            cursor6.moveToNext();
    				}
    			}
            	//关闭cursor，否则3次连续查询之后报错溢出
            	cursor1.close();
            	cursor2.close();
            	cursor3.close();
            	cursor4.close();
            	cursor5.close();
            	cursor6.close();
                sectionPosition++;
            }
            if (s==0)
			{
            	Item section = new Item(Item.SECTION, "无查询结果");
            	section.listPosition = listPosition;
            	section.listPosition = listPosition++;
            	onSectionAdded(section, sectionPosition);
            	add(section);
            	
            	Item item = new Item(Item.ITEM, "抱歉，查询不到您需要的校车信息！");
                item.sectionPosition = sectionPosition;
                item.listPosition = listPosition++;
				add(item);
			}
        }
        
        protected void prepareSections(int sectionsNumber)
        { 
        	
        }
        protected void onSectionAdded(Item section, int sectionPosition) { }

        @Override public View getView(int position, View convertView, ViewGroup parent) {
            TextView view = (TextView) super.getView(position, convertView, parent);
            view.setTag("" + position);
            Item item = getItem(position);
            if (item.type == item.ITEM)
			{
            	view.setTextColor(0xFFECF0F1);
            	if(position%2 ==0)
            	{
            		view.setBackgroundColor(0xFF1E1E1E);
            	}
            	else 
            	{
            		view.setBackgroundColor(0xFF444444);
				}
            	view.setTextSize(15f);
            	view.setLayoutParams(new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			}
            if (item.type == Item.SECTION) {
                //view.setOnClickListener(PinnedSectionListActivity.this);
            	view.setTextColor(0xFFECF0F1);
                view.setBackgroundColor(0xFF85B935);
                view.setTextSize(20f);
                view.setLayoutParams(new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT, 80));
            }
            return view;
        }

        @Override public int getViewTypeCount() {
            return 2;
        }

        @Override public int getItemViewType(int position) {
            return getItem(position).type;
        }

        public boolean isItemViewTypePinned(int viewType) {
            return viewType == Item.SECTION;
        }

    }

    static class FastScrollAdapter extends SimpleAdapter implements SectionIndexer {

        private Item[] sections;

        public FastScrollAdapter(Context context, int resource, int textViewResourceId) {
            super(context, resource, textViewResourceId);
        }

        @Override protected void prepareSections(int sectionsNumber) {
            sections = new Item[sectionsNumber];
        }

        @Override protected void onSectionAdded(Item section, int sectionPosition) {
            sections[sectionPosition] = section;
        }

        public Item[] getSections() {
            return sections;
        }

        public int getPositionForSection(int section) {
            if (section >= sections.length) {
                section = sections.length - 1;
            }
            return sections[section].listPosition;
        }

        public int getSectionForPosition(int position) {
            if (position >= getCount()) {
                position = getCount() - 1;
            }
            return getItem(position).sectionPosition;
        }

    }

	static class Item {

		public static final int ITEM = 0;
		public static final int SECTION = 1;

		public final int type;
		public final String text;

		public int sectionPosition;
		public int listPosition;

		public Item(int type, String text) {
		    this.type = type;
		    this.text = text;
		}

		@Override public String toString() {
			return text;
		}

	}

	private boolean hasHeaderAndFooter;
	private boolean isFastScroll;
	private boolean addPadding;
	private boolean isShadowVisible = true;
//	private int mDatasetUpdateCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pinnedsectionlist);
		
		Intent intent = getIntent();
        position1 = intent.getIntExtra("position1",1);
        position2 = intent.getIntExtra("position2",1);
        position3 = intent.getIntExtra("position3",1);
        position4 = intent.getIntExtra("position4",1);
        
        
        schoolLocation = getResources().getStringArray(R.array.schoolLocation);
        busTime = getResources().getStringArray(R.array.busTime);
        
        //首先将DB文件拷贝至程序内存当中
  		if (copyDB())
  		{
  			//得到数据库文件
  			File file = new File(URL, DB_FILE_NAME);
  			db = SQLiteDatabase.openOrCreateDatabase(file, null);
  		}
		if (savedInstanceState != null) {
		    isFastScroll = savedInstanceState.getBoolean("isFastScroll");
		    addPadding = savedInstanceState.getBoolean("addPadding");
		    isShadowVisible = savedInstanceState.getBoolean("isShadowVisible");
		    hasHeaderAndFooter = savedInstanceState.getBoolean("hasHeaderAndFooter");
		}
		initializeHeaderAndFooter();
		initializeAdapter();
		initializePadding();
	}

    @Override
	protected void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    outState.putBoolean("isFastScroll", isFastScroll);
	    outState.putBoolean("addPadding", addPadding);
	    outState.putBoolean("isShadowVisible", isShadowVisible);
	    outState.putBoolean("hasHeaderAndFooter", hasHeaderAndFooter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) 
	{
//	    Item item = (Item) getListView().getAdapter().getItem(position);
//	    if (item.type == item.ITEM ) 
//	    {
//	    	
//	    }
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.main, menu);
//		menu.getItem(0).setChecked(isFastScroll);
//		menu.getItem(1).setChecked(addPadding);
//		menu.getItem(2).setChecked(isShadowVisible);
//		return true;
//	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
//	    switch (item.getItemId()) {
//    	    case R.id.action_fastscroll:
//    	        isFastScroll = !isFastScroll;
//    	        item.setChecked(isFastScroll);
//    	        initializeAdapter();
//    	        break;
//    	    case R.id.action_addpadding:
//    	        addPadding = !addPadding;
//    	        item.setChecked(addPadding);
//    	        initializePadding();
//    	        break;
//    	    case R.id.action_showShadow:
//    	        isShadowVisible = !isShadowVisible;
//    	        item.setChecked(isShadowVisible);
//    	        ((PinnedSectionListView)getListView()).setShadowVisible(isShadowVisible);
//    	        break;
//    	    case R.id.action_showHeaderAndFooter:
//    	        hasHeaderAndFooter = !hasHeaderAndFooter;
//    	        item.setChecked(hasHeaderAndFooter);
//    	        initializeHeaderAndFooter();
//    	        break;
//    	    case R.id.action_updateDataset:
//    	    	updateDataset();
//    	    	break;
//	    }
	    return true;
	}

//	private void updateDataset() {
//		mDatasetUpdateCount++;
//		SimpleAdapter adapter = (SimpleAdapter) getListAdapter();
//		switch (mDatasetUpdateCount % 4) {
//			case 0: adapter.generateDataset('A', 'B', true); break;
//			case 1: adapter.generateDataset('C', 'M', true); break;
//			case 2: adapter.generateDataset('P', 'Z', true); break;
//			case 3: adapter.generateDataset('A', 'Z', true); break;
//		}
//		adapter.notifyDataSetChanged();
//	}
	
	private void initializePadding() {
	    float density = getResources().getDisplayMetrics().density;
	    int padding = addPadding ? (int) (16 * density) : 0;
	    getListView().setPadding(padding, padding, padding, padding);
	}

    private void initializeHeaderAndFooter() {
//        setListAdapter(null);
//        if (hasHeaderAndFooter) {
//            ListView list = getListView();
//
//            LayoutInflater inflater = LayoutInflater.from(this);
//            TextView header1 = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, list, false);
//            header1.setText("First header");
//            list.addHeaderView(header1);
//
//            TextView header2 = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, list, false);
//            header2.setText("Second header");
//            list.addHeaderView(header2);
//
//            TextView footer = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, list, false);
//            footer.setText("Single footer");
//            list.addFooterView(footer);
//        }
//        initializeAdapter();
    }

    @SuppressLint("NewApi")
    private void initializeAdapter() {
        getListView().setFastScrollEnabled(isFastScroll);
        if (isFastScroll) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                getListView().setFastScrollAlwaysVisible(true);
            }
            setListAdapter(new FastScrollAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1));
        } else {
            setListAdapter(new SimpleAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1));
        }
    }

    public void onClick(View v) {
        Toast.makeText(this, "Item: " + v.getTag() , Toast.LENGTH_SHORT).show();
    }

 // 将raw文件中的数据库文件拷贝至手机中的程序内存当中
 	@SuppressLint("WorldReadableFiles")
 	@SuppressWarnings("deprecation")
 	public boolean copyDB()
 	{
 		try
 		{
 			// 判断程序内存中是否有拷贝后的文件
 			if (!(new File(URL)).exists())
 			{
 				InputStream is = getResources().openRawResource(R.raw.bus);
 				FileOutputStream fos = this.openFileOutput(DB_FILE_NAME, Context.MODE_WORLD_READABLE);
 				// 一次拷贝的缓冲大小1M
 				byte[] buffer = new byte[1024 * 1024];
 				int count = 0;
 				// 循环拷贝数据库文件
 				while ((count = is.read(buffer)) > 0)
 				{
 					fos.write(buffer, 0, count);
 				}

 				fos.close();
 				is.close();
 			}
 			return true;
 		} catch (Exception e)
 		{
 			e.printStackTrace();
 			return false;
 		}
 	} 
    
}