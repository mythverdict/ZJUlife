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
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class AppRecommend extends ListActivity {

	
    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview2);
 
        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.list_item1,
        new String[]{"title","info","img"},
        new int[]{R.id.title,R.id.info,R.id.img});
        setListAdapter(adapter);
        
        getData();
        ListView listView = getListView();
        listView.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
					String[] urlString = getResources().getStringArray(R.array.appdownload);
				    Intent intent= new Intent();        
				    intent.setAction("android.intent.action.VIEW");    
				    Uri content_url = Uri.parse(urlString[position]);   
				    intent.setData(content_url);  
				    startActivity(intent);
			}
		});
	}	

    private List<Map<String, Object>> getData() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        
        map.put("title", "iZJU");
        map.put("info", "iZJU浙江大学最大的手机移动媒体信息平台，覆盖80%浙大师生，拥有最全面的浙江大学信息资询，具有信息精准分类和投放的功能，为浙大师生服务。");
        map.put("img", R.drawable.izju);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", "求是潮");
        map.put("info", "求是潮手机站 是浙江大学求是潮的新一代移动客户端，提供 课表 / 活动 / 成绩 / 考试 / 校车 等方便学生的查询。");
        map.put("img", R.drawable.qiushichao);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", "求是青梅");
        map.put("info", "青梅是为全国各高校大学生打造的移动互联网校园资讯产品，以其本地化服务、即时性发布、个性化定制和安全性运营为特点。");
        map.put("img", R.drawable.qiushiqingmei);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "Mycc98");
        map.put("info", "浙江大学CC98论坛客户端 For Android作为个人的作品，希望能让你爱上用手机水98的生活！");
        map.put("img", R.drawable.cc98);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", "信电小站");
        map.put("info", "“信电小站”是由信电学生会开发运营的移动客户端，旨在为信电系全体师生提供便捷的通知、课表、成绩查询，以及学习资料的下载。同时也是一个全新的权益服务平台，促进院系与师生的密切交流。");
        map.put("img", R.drawable.isee);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", "浙大校园卡");
        map.put("info", "浙大校园卡支持转账支付、实时查询交易查看、随时随地方便校园卡管理。");
        map.put("img", R.drawable.xiaoyuanka);
        list.add(map);
        
        return list;
    }
}