/*
 * @author Fan Wei
 */
package com.zju.isee.zjulife;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainview);
    }
    
    public void start_1(View v)
    {
    	Intent intent = new Intent(MainActivity.this, AntiFake.class);
    	startActivity(intent);

//    	Intent intent=new Intent();
//    	intent.setAction("com.zju.isee.zjulife.AntiFake");
//    	startActivity(intent);
    }
    
    public void start_2(View v)
    {
    	Intent intent = new Intent(MainActivity.this, ListView1.class);
    	startActivity(intent);
    	
    }
		
    public void start_3(View v)
    {
    	Intent intent = new Intent(MainActivity.this, netManage.class);
    	startActivity(intent);
    }
    
    public void start_4(View v)
    {
    	Intent intent = new Intent(MainActivity.this, MapActivity.class);
    	startActivity(intent);
    }
    
    public void start_5(View v)
    {
    	Intent intent = new Intent(MainActivity.this, BusQuery.class);
    	startActivity(intent);
    }
    
    public void start_7(View v)
    {
    	Intent intent = new Intent(MainActivity.this, ClassroomQuery.class);
    	startActivity(intent);
    }
    
    public void start_8(View v)
    {
    	Intent intent = new Intent(MainActivity.this, ListView2.class);
    	startActivity(intent);
    }
    
    public void start_9(View v)
    {
    	Intent intent = new Intent(MainActivity.this, AfterClass.class);
    	startActivity(intent);
    }
    
    public void start_10(View v)
    {
    	Intent intent = new Intent(MainActivity.this, Award.class);
    	startActivity(intent);
    }
    
    public void start_11(View v)
    {
    	Intent intent = new Intent(MainActivity.this, Hospital.class);
    	startActivity(intent);
    }
    
    public void start_12(View v)
    {
    	Intent intent = new Intent(MainActivity.this, Eating.class);
    	startActivity(intent);
    }
    
    public void start_13(View v)
    {
    	Intent intent = new Intent(MainActivity.this, Hotel.class);
    	startActivity(intent);
    }
    
    public void start_15(View v)
    {
    	Intent intent = new Intent(MainActivity.this, About.class);
    	startActivity(intent);
    }
    
    public void start_16(View v)
    {
    	Intent intent = new Intent(MainActivity.this, AppRecommend.class);
    	startActivity(intent);
    }
    
    public void searchAll(View V)
    {
		Intent intent = new Intent(MainActivity.this, SearchAll.class);
    	startActivity(intent);
    }
    
	@Override
	public void onResume()
	{
		super.onResume();
		switchFragment();
	}
	
	private void switchFragment()
	{
		Fragment fragment = null;
		fragment = new SwitchFragment();
		
		FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_switch, fragment);
        ft.commitAllowingStateLoss();
        
	}

	
    @Override
	protected void onPause()
	{
		super.onPause();
	}

	@Override
	protected void onPostResume()
	{
		super.onPostResume();
	}

	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }
}
