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
		
		//�ж��Ƿ�����WiFi���
		wifiMgr = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        int wifiState = wifiMgr.getWifiState();
        WifiInfo info = wifiMgr.getConnectionInfo();
        String wifiId = info != null ? info.getSSID() : null;
        
        if (wifiState == (WifiManager.WIFI_STATE_DISABLED)||wifiState == (WifiManager.WIFI_STATE_DISABLING)||wifiId!="ZJUWLAN")
		{
        	AlertDialog.Builder dialog=new AlertDialog.Builder(ClassroomQuery.this);
            dialog.setTitle("�޷���ȡ������Ϣ��").setIcon(android.R.drawable.ic_dialog_info).setMessage("ȥ����WiFi���ӣ�").setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
              
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 //ת��������һ��Activity
            	 Intent intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
             	 startActivity(intent);
             }
         }).setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
              
              
             public void onClick(DialogInterface dialog, int which) {
                 dialog.cancel();//ȡ��������
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
		
		//WebChromeClient�Ǹ���WebView����Javascript�ĶԻ�����վͼ�꣬��վtitle�����ؽ��ȵ� 
		mWebView.setWebChromeClient(new WebChromeClient()
		{
			public void onProgressChanged(WebView view, int progress)
			{
				
			}
		});
		
		//WebViewClient���ǰ���WebView�������֪ͨ�������¼���
		mWebView.setWebViewClient(new WebViewClient()
		{
			@Override
			public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
			{
//				Toast.makeText(ClassroomQuery.this, "������ZJUWLAN������", Toast.LENGTH_SHORT).show();
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
		 * ��ӦPC��ҳ
		 */
		webSettings.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
		webSettings.setUseWideViewPort(true);
		/*
		 * ȥ������ͼ��
		 */
	    webSettings.setBuiltInZoomControls(true);
	    webSettings.setDisplayZoomControls(false);
	    /*
	     * ȥ���߽������
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
