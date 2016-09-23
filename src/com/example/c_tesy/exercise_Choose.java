package com.example.c_tesy;

import java.util.ArrayList;

import com.example.c_tesy.R;

import util.MyApplication;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class exercise_Choose extends Activity{
	private MyApplication application;
	private ListView listview;
	private TextView tv1;
	private Button bt1;
	final int ran[]=new int[20];
	final String ans[]=new String[20];
	final String corect[]=new String[20];
	final ArrayList<String>  array = new ArrayList<String>();
	private String ChooseArray[]=new String[20];
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exercise_choose);
		listview=(ListView)findViewById(R.id.exercise_choose_lv1);
		tv1=(TextView)findViewById(R.id.exercise_choose_tv1);
		bt1=(Button)findViewById(R.id.exercise_choose_bt1);
		application = (MyApplication) getApplication();
		SQLiteDatabase db = application.getDB();
		String sql = "select * from channels";
		Cursor cursor = db.rawQuery(sql, null);
	    bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				check(listview);
			}
		});
		for(int i=0;i<20;i++)
		{
			ran[i]=(int) (Math.random()*100);
		}
		for(int j=0;j<20;j++)
		{
            cursor.moveToPosition(ran[j]);
			String question = cursor.getString(cursor.getColumnIndex("question"));
			array.add(question);
			corect[j]=cursor.getString(cursor.getColumnIndex("answer"));
		}
        
		BaseAdapter adapter = new BaseAdapter() {
        
			@Override
			public View getView(final int position, View convertView, ViewGroup parent) {
				
				View view = getLayoutInflater().inflate(R.layout.listview_item, null);
				final TextView TextView_Question = (TextView) view.findViewById(R.id.textView_question);
				final TextView TextView_storage=(TextView) view.findViewById(R.id.storage);
				final Button button_A = (Button) view.findViewById(R.id.button_A);
				final Button button_B = (Button) view.findViewById(R.id.button_B);
				final Button button_C = (Button) view.findViewById(R.id.button_C);
				final Button button_D = (Button) view.findViewById(R.id.button_D);
				
                button_A.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						ChooseArray[position] = button_A.getText().toString();	
			            TextView_storage.setText(ChooseArray[position]);

					}
				});
				button_B.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						ChooseArray[position] = button_B.getText().toString();	
			            TextView_storage.setText(ChooseArray[position]);
					}
				});
				button_C.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						ChooseArray[position] = button_C.getText().toString();	
			            TextView_storage.setText(ChooseArray[position]);
					}
				});
				button_D.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						ChooseArray[position] = button_D.getText().toString();	
			            TextView_storage.setText(ChooseArray[position]);
					}
				});
				TextView_storage.setText(ChooseArray[position]);
				TextView_Question.setText(array.get(position));
				return view;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return array.get(position);
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return array.size();
			}
		};
		listview.setAdapter(adapter);
		setListViewHeightBasedOnChildren(listview);
	}
	public void check(ListView mListView)
	{
		int grade = 0;
		for(int i=0;i<mListView.getChildCount();i++)
		{
			View view=mListView.getChildAt(i);
			TextView storage=(TextView)view.findViewById(R.id.storage);
			ans[i]=(String) storage.getText();
			if(ans[i].equals(corect[i]))grade+=2;
		}
        	tv1.setText("您的分数是："+grade);
	}
	 public void setListViewHeightBasedOnChildren(ListView listView) { 
	     	ListAdapter listAdapter = listView.getAdapter(); 
	     	if (listAdapter == null) { 
	     	// pre-condition 
	     	return; 
	     	} 

	     	int totalHeight = 0; 
	     	for (int i = 0; i < listAdapter.getCount(); i++) { 
	     	View listItem = listAdapter.getView(i, null, listView); 
	     	listItem.measure(0, 0); 
	     	totalHeight += listItem.getMeasuredHeight(); 
	     	} 

	     	ViewGroup.LayoutParams params = listView.getLayoutParams(); 
	     	params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1)); 
	     	listView.setLayoutParams(params); 
	     	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
