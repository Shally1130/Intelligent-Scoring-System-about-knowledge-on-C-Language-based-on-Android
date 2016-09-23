package com.example.c_tesy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class exercise_Coding extends Activity {
        private TextView tv1;
        private Button bt1;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exercise_coding);
		tv1=(TextView)findViewById(R.id.exercise_coding_tv1);
		bt1=(Button)findViewById(R.id.exercise_coding_bt1);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
