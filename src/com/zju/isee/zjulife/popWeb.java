/*
 * @author Fan Wei
 */
package com.zju.isee.zjulife;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

@SuppressLint("SetJavaScriptEnabled")
public class popWeb extends Activity
{
	WebView mWebView;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.popweb);
		
		mWebView = (WebView) findViewById(R.id.popWebview);

		mWebView.getSettings().setJavaScriptEnabled(true);   
		mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);   
		mWebView.setHorizontalScrollBarEnabled(false);   
		mWebView.getSettings().setSupportZoom(true);   
		mWebView.getSettings().setBuiltInZoomControls(true);   
		mWebView.setInitialScale(50);   
		mWebView.setHorizontalScrollbarOverlay(true);  

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
				Toast.makeText(popWeb.this, "������ZJUWLAN������", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url)
			{
				view.loadUrl(url);
				return true;
			}
		});
		
		mWebView.loadUrl("file:///android_asset/popweb.html");
		
		
		WebSettings webSettings = mWebView.getSettings();
		
		webSettings.setLoadWithOverviewMode(true);
		webSettings.setUseWideViewPort(false);
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
	}

	
    public void BackToMain(View v)
    {
    	Intent intent = new Intent(popWeb.this, MainActivity.class);
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
