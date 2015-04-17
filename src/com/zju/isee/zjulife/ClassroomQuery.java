/*
 * @author Fan Wei
 */
package com.zju.isee.zjulife;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.LayoutAlgorithm;

@SuppressLint("SetJavaScriptEnabled")
public class ClassroomQuery extends Activity
{
	WebView mWebView;
	WifiManager wifiMgr;
	
	View refresh;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.classroom);
		
		mWebView = (WebView) findViewById(R.id.classroomWebview);

		mWebView.getSettings().setJavaScriptEnabled(true);   
		mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);   
		mWebView.setHorizontalScrollBarEnabled(false);
		mWebView.getSettings().setSupportZoom(true);
		mWebView.getSettings().setBuiltInZoomControls(true);   
		mWebView.setHorizontalScrollbarOverlay(true);  
		
		//判断是否连接WiFi相关
		wifiMgr = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        int wifiState = wifiMgr.getWifiState();
        WifiInfo info = wifiMgr.getConnectionInfo();
        String wifiId = info != null ? info.getSSID() : null;
        
        if (wifiState == (WifiManager.WIFI_STATE_DISABLED)||wifiState == (WifiManager.WIFI_STATE_DISABLING)||wifiId!="ZJUWLAN")
		{
        	AlertDialog.Builder dialog=new AlertDialog.Builder(ClassroomQuery.this);
            dialog.setTitle("无法获取内网信息！").setIcon(android.R.drawable.ic_dialog_info).setMessage("去设置WiFi连接？").setPositiveButton("确定", new DialogInterface.OnClickListener() {
              
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 //转跳到另外一个Activity
            	 Intent intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
             	 startActivity(intent);
             }
         }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
              
              
             public void onClick(DialogInterface dialog, int which) {
                 dialog.cancel();//取消弹出框
             }
         }).create().show();
		}
        else {
        	mWebView.loadUrl("http://jxzygl.zju.edu.cn/jxzwsyqk/jszycx_tj.aspx");
		}
        
        refresh = (View)findViewById(R.id.refresh);
        refresh.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				mWebView.loadUrl("http://jxzygl.zju.edu.cn/jxzwsyqk/jszycx_tj.aspx");
			}
		});
		
		//WebChromeClient是辅助WebView处理Javascript的对话框，网站图标，网站title，加载进度等 
		mWebView.setWebChromeClient(new WebChromeClient()
		{
			public void onProgressChanged(WebView view, int progress)
			{
				
			}
		});
		
		//WebViewClient就是帮助WebView处理各种通知、请求事件的
		mWebView.setWebViewClient(new WebViewClient()
		{
			@Override
			public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
			{
//				Toast.makeText(ClassroomQuery.this, "请连接ZJUWLAN后重试", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url)
			{
				view.loadUrl(url);
				return true;
			}
		});
		
		WebSettings webSettings = mWebView.getSettings();
		/*
		 * 适应PC网页
		 */
		webSettings.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
		webSettings.setUseWideViewPort(true);
		/*
		 * 去掉缩放图标
		 */
	    webSettings.setBuiltInZoomControls(true);
	    webSettings.setDisplayZoomControls(false);
	    /*
	     * 去掉边界滚动条
	     */
	    mWebView.setVerticalScrollBarEnabled(false);
	    mWebView.setHorizontalScrollBarEnabled(false); 
	    
	    webSettings.setTextZoom(40);
	}

	
    public void BackToMain(View v)
    {
    	Intent intent = new Intent(ClassroomQuery.this, MainActivity.class);
    	startActivity(intent);
    }
    
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack())
		{
			mWebView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
