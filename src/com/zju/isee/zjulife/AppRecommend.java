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
        map.put("info", "iZJU�㽭��ѧ�����ֻ��ƶ�ý����Ϣƽ̨������80%���ʦ����ӵ����ȫ����㽭��ѧ��Ϣ��ѯ��������Ϣ��׼�����Ͷ�ŵĹ��ܣ�Ϊ���ʦ������");
        map.put("img", R.drawable.izju);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", "���ǳ�");
        map.put("info", "���ǳ��ֻ�վ ���㽭��ѧ���ǳ�����һ���ƶ��ͻ��ˣ��ṩ �α� / � / �ɼ� / ���� / У�� �ȷ���ѧ���Ĳ�ѯ��");
        map.put("img", R.drawable.qiushichao);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", "������÷");
        map.put("info", "��÷��Ϊȫ������У��ѧ��������ƶ�������У԰��Ѷ��Ʒ�����䱾�ػ����񡢼�ʱ�Է��������Ի����ƺͰ�ȫ����ӪΪ�ص㡣");
        map.put("img", R.drawable.qiushiqingmei);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "Mycc98");
        map.put("info", "�㽭��ѧCC98��̳�ͻ��� For Android��Ϊ���˵���Ʒ��ϣ�������㰮�����ֻ�ˮ98�����");
        map.put("img", R.drawable.cc98);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", "�ŵ�Сվ");
        map.put("info", "���ŵ�Сվ�������ŵ�ѧ���Ὺ����Ӫ���ƶ��ͻ��ˣ�ּ��Ϊ�ŵ�ϵȫ��ʦ���ṩ��ݵ�֪ͨ���α��ɼ���ѯ���Լ�ѧϰ���ϵ����ء�ͬʱҲ��һ��ȫ�µ�Ȩ�����ƽ̨���ٽ�Ժϵ��ʦ�������н�����");
        map.put("img", R.drawable.isee);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", "���У԰��");
        map.put("info", "���У԰��֧��ת��֧����ʵʱ��ѯ���ײ鿴����ʱ��ط���У԰������");
        map.put("img", R.drawable.xiaoyuanka);
        list.add(map);
        
        return list;
    }
}