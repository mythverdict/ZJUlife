/*
 * @author Fan Wei
 */
package com.zju.isee.zjulife;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.view.View.OnClickListener;

public class About extends Activity
{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        ImageView infoOperatingIV = (ImageView)findViewById(R.id.rotate);  
        Animation operatingAnim = AnimationUtils.loadAnimation(this, R.anim.rotate);  
        LinearInterpolator lin = new LinearInterpolator();  
        operatingAnim.setInterpolator(lin);
        
        if (operatingAnim != null) 
        {  
        	infoOperatingIV.startAnimation(operatingAnim);
        }

//        infoOperatingIV.clearAnimation(); 
        
        View feedback = (View) findViewById(R.id.feedback);
        feedback.setOnClickListener(listener);
	}
	
	private OnClickListener listener = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			switch (v.getId())
			{
			case R.id.feedback:
				Intent data=new Intent(Intent.ACTION_SENDTO); 
				data.setData(Uri.parse("mailto:1334113129@qq.com")); 
				data.putExtra(Intent.EXTRA_SUBJECT, "ZJU life反馈"); 
				data.putExtra(Intent.EXTRA_TEXT, "感谢您的配合参与！"); 
				startActivity(data);				
				break;

			default:
				break;
			}
			
		}
	};

}
