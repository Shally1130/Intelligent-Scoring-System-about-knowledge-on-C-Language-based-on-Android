package com.example.c_tesy;
import com.example.c_tesy.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class choosePage extends Activity{
	private Button bt1;
	private Button bt2;
	private Button bt3;
	private Button bt4;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choosepage);
		bt1=(Button)findViewById(R.id.choosepage_bt1);
		bt2=(Button)findViewById(R.id.choosepage_bt2);
		bt3=(Button)findViewById(R.id.choosepage_bt3);
		bt4=(Button)findViewById(R.id.choosepage_bt4);
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent1=new Intent(choosePage.this,exercise_Choose.class);
				startActivity(intent1);
				
			}
		});
		bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent2=new Intent(choosePage.this,exercise_fillBlank.class);
				startActivity(intent2);
			}
		});
		bt3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClassName("com.n0n3m4.droidc", "com.n0n3m4.droidc.CCompilerMain");
				choosePage.this.startActivity(i);
			}
		});
		bt4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent4=new Intent(choosePage.this,systemExercise.class);
				startActivity(intent4);
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
