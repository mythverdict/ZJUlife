/*
 * @author Fan Wei
 */
package com.zju.isee.zjulife;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class BusQuery extends Activity
{
	//ÏÂÀ­¿Ø¼þ
	Spinner spinner1;
	Spinner spinner2;
	Spinner spinner3;
	Spinner spinner4;
	
	String[] schoolLocation = null;
	String[] busTime = null;
	String[] busType = null;
	View queryView = null;
	SQLiteDatabase db = null;
	
	int position1;
	int position2;
	int position3;
	int position4;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_query);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        spinner4 = (Spinner)findViewById(R.id.spinner4);
        queryView = (View)findViewById(R.id.imageBus);
        
        schoolLocation = getResources().getStringArray(R.array.schoolLocation);
        busTime = getResources().getStringArray(R.array.busTime);
        
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,schoolLocation);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,busTime);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter1);
        spinner3.setAdapter(adapter2);
        spinner4.setAdapter(adapter2);
        
		queryView.setOnClickListener(new OnClickListener()
		{
				
			@Override
			public void onClick(View v)
			{
				
				position1 = spinner1.getSelectedItemPosition();
				position2 = spinner2.getSelectedItemPosition();
				position3 = spinner3.getSelectedItemPosition();
				position4 = spinner4.getSelectedItemPosition();
				
				Intent intent = new Intent();
				intent.putExtra("position1", position1);
				intent.putExtra("position2", position2);
				intent.putExtra("position3", position3);
				intent.putExtra("position4", position4);
				
				intent.setClass(BusQuery.this, BusResult.class);
				startActivity(intent);
			}
		});
	}
}
