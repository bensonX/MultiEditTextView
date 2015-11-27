package com.benson.multiedittextview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

	MultiEditTextView names;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		  names = (MultiEditTextView) findViewById(R.id.friend_names);
		names.setFriendCount(5);
		
		Button button1=(Button) findViewById(R.id.button1);
		Button button2=(Button) findViewById(R.id.button2);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				names.addView();
				
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				names.removeView();
				
			}
		});

	}
}
