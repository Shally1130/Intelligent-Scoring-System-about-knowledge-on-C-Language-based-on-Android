package com.example.c_tesy;

import java.util.ArrayList;
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
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class exercise_fillBlank extends Activity {
	private MyApplication application;
	private ListView lv1;
	private Button bt1;
	private TextView tv1;
	final ArrayList<String>  array2 = new ArrayList<String>();
	   private  TextView fillBlank_answer;
	final int ran2[]=new int[20];
	final String corect2[]=new String[20];
	final String ans2[]=new String[20];
	private String ChooseArray2[]=new String[20];
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exercise_fillblank);
		lv1=(ListView)findViewById(R.id.exercise_fillblank_lv1);
		bt1=(Button)findViewById(R.id.exercise_fillblank_bt1);
		tv1=(TextView)findViewById(R.id.exercise_fillblank_tv);
		application = (MyApplication) getApplication();
		SQLiteDatabase db = application.getDB();
		String sql = "select * from channels";
		Cursor cursor2 = db.rawQuery(sql, null);
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				check(lv1);
			}
		});
		for(int i=0;i<20;i++)
		{
			ran2[i]=((int) (Math.random()*100))+100;
			
		}
		for(int j=0;j<20;j++)
		{
            cursor2.moveToPosition(ran2[j]);
			String question2 = cursor2.getString(cursor2.getColumnIndex("question"));
			array2.add(question2);
			corect2[j]=cursor2.getString(cursor2.getColumnIndex("answer"));
		}

		BaseAdapter adapter2 = new BaseAdapter() {
	        
			@Override
			public View getView(final int position, View convertView, ViewGroup parent) {
				
				View view = getLayoutInflater().inflate(R.layout.tiankong, null);
				//final Button bt=(Button)findViewById(R.id.tiankong_bt);
				final TextView fillBlank_question = (TextView) view.findViewById(R.id.fillBlank_question);
			    fillBlank_answer=(TextView) view.findViewById(R.id.fillBlank_answer);
			    final EditText fillBlank_write=(EditText)view.findViewById(R.id.write);
			    Button button_ok= (Button) view.findViewById(R.id.tiankong_bt);
			    button_ok.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						fillBlank_answer.setText(fillBlank_write.getText().toString());
						
					}
				});
				ChooseArray2[position] = fillBlank_write.getText().toString();	
			    fillBlank_question.setText(array2.get(position));
				fillBlank_answer.setText(ChooseArray2[position]);
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
				return array2.get(position);
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return array2.size();
			}
		};
		lv1.setAdapter(adapter2);
		setListViewHeightBasedOnChildren(lv1);
	}
	public void check(ListView mListView)
	{
		int grade = 0;
		for(int i=0;i<mListView.getChildCount();i++)
		{
			View view=mListView.getChildAt(i);
			TextView storage=(TextView)view.findViewById(R.id.fillBlank_answer);
			ans2[i]=(String) storage.getText();
			if(ans2[i].equals(corect2[i]))grade+=2;
		}
        	tv1.setText("您的分数是："+grade);
	}
	 public void setListViewHeightBasedOnChildren(ListView listView) { 
	     	ListAdapter listAdapter = listView.getAdapter(); 
	     	if (listAdapter == null) { 
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
