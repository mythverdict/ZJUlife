/*
 * @author Fan Wei
 */
package com.zju.isee.zjulife;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class AfterClass extends Activity
{
	WebView mWebView;
	@SuppressLint("SetJavaScriptEnabled") @Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.after_class);
		
		mWebView = (WebView) findViewById(R.id.afterclassWebview);

		mWebView.getSettings().setJavaScriptEnabled(true);   
		mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);   
		mWebView.setHorizontalScrollBarEnabled(false);   
		mWebView.getSettings().setSupportZoom(true);   
		mWebView.getSettings().setBuiltInZoomControls(true);   
		mWebView.setInitialScale(50);   
		mWebView.setHorizontalScrollbarOverlay(true);  

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
				Toast.makeText(AfterClass.this, "请连接ZJUWLAN后重试", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url)
			{
				view.loadUrl(url);
				return true;
			}
		});
		
		mWebView.loadUrl("file:///android_asset/after_class.html");
		
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
