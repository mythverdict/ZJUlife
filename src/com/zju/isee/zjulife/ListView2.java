/*
 * @author Fan Wei
 */
package com.zju.isee.zjulife;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class ListView2 extends ListActivity {

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview3);
 
        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.list_item,
        new String[]{"title","info","img"},
        new int[]{R.id.title,R.id.info,R.id.img});
        setListAdapter(adapter);
        
        getData();
        ListView listView = getListView();
        listView.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				if (position == 0)
				{
					Intent intent = new Intent(ListView2.this, ClassChoice.class);
			    	startActivity(intent);
				}
				if (position == 1)
				{
					Intent intent = new Intent(ListView2.this, CommonClass.class);
			    	startActivity(intent);
				}
			}
		});
	}	

    private List<Map<String, Object>> getData() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        
        map.put("title", "ѡ������");
        map.put("info", "\nѧ��ѧ���ǵ�ѡ�ν��Ի㼯�ڴˣ�");
        map.put("img", R.drawable.search_27);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "ͨʶ�γ��ĵ�");
        map.put("info", "\n���������ͨʶ�γ̵��ĵ���ᣡ");
        map.put("img", R.drawable.search_27);
        list.add(map);
        
        return list;
    }
}