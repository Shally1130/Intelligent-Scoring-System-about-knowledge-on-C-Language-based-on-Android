package com.example.c_tesy;

import java.util.ArrayList;



import util.MyApplication;
import android.app.Activity;
import android.content.Intent;
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

public class systemExercise extends Activity {
	private MyApplication application;
	private ListView lv1;
	private ListView lv2;
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;
	private TextView tv4;
	private EditText et1;
	private Button bt1;
	final int ranT[]=new int[10];
	final String chT[]=new String[10];
	final String ansT[]=new String[10];
	final int ranX[]=new int[10];
	final String corectX[]=new String[10];
	final String ansX[]=new String[10];
	final ArrayList<String>  arrayX = new ArrayList<String>();
	final ArrayList<String>  arrayT = new ArrayList<String>();
	private String ChooseArrayX[]=new String[20];
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.systemexercise);
		lv1=(ListView)findViewById(R.id.systemexercise_lv1);
		lv2=(ListView)findViewById(R.id.systemexercise_lv2);
		tv1=(TextView)findViewById(R.id.systemexercise_tv1);
		tv2=(TextView)findViewById(R.id.systemexercise_tv2);
		tv3=(TextView)findViewById(R.id.systemexercise_tv3);
		tv4=(TextView)findViewById(R.id.systemexercise_tv4);
		et1=(EditText)findViewById(R.id.systemexercise_ed1);
		bt1=(Button)findViewById(R.id.systemexercise_bt1);
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				checkChoose(lv1);
			}
		});
		application = (MyApplication) getApplication();
		SQLiteDatabase db = application.getDB();
		String sql = "select * from channels";
		Cursor cursor = db.rawQuery(sql, null);
		for(int i=0;i<10;i++)
		{
			ranX[i]=(int) (Math.random()*100);
		    ranT[i]=((int) (Math.random()*100))+100;
	     }
		for(int j=0;j<10;j++)
		{
            cursor.moveToPosition(ranX[j]);
			String questionX = cursor.getString(cursor.getColumnIndex("question"));
			arrayX.add(questionX);
			String sX=cursor.getString(cursor.getColumnIndex("answer"));
			corectX[j]=sX;
			   cursor.moveToPosition(ranT[j]);
				String questionT = cursor.getString(cursor.getColumnIndex("answer"));
				arrayT.add(questionT);
				String sT=cursor.getString(cursor.getColumnIndex("question"));
				chT[j]=sT;
		}

			BaseAdapter adapterX = new BaseAdapter() {
		        
				@Override
				public View getView(final int position, View convertView, ViewGroup parent) {
					
					View view = getLayoutInflater().inflate(R.layout.listview_item, null);
					final TextView TextView_Question = (TextView) view.findViewById(R.id.textView_question);
					final TextView TextView_storage=(TextView) view.findViewById(R.id.storage);
					final Button button_A = (Button) view.findViewById(R.id.button_A);
					final Button button_B = (Button) view.findViewById(R.id.button_B);
					final Button button_C = (Button) view.findViewById(R.id.button_C);
					final Button button_D = (Button) view.findViewById(R.id.button_D);
					final Button buttoncode = (Button) view.findViewById(R.id.btcode);
					
	                button_A.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							ChooseArrayX[position] = button_A.getText().toString();	
				            TextView_storage.setText(ChooseArrayX[position]);

						}
					});
					button_B.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							ChooseArrayX[position] = button_B.getText().toString();	
				            TextView_storage.setText(ChooseArrayX[position]);
						}
					});
					button_C.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							ChooseArrayX[position] = button_C.getText().toString();	
				            TextView_storage.setText(ChooseArrayX[position]);
						}
					});
					button_D.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							ChooseArrayX[position] = button_D.getText().toString();	
				            TextView_storage.setText(ChooseArrayX[position]);
						}
					});
					buttoncode.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Intent i = new Intent();
							i.setClassName("com.n0n3m4.droidc", "com.n0n3m4.droidc.CCompilerMain");
							systemExercise.this.startActivity(i);
							
						}
					});
					TextView_storage.setText(ChooseArrayX[position]);
					TextView_Question.setText(arrayX.get(position));
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
					return arrayX.get(position);
				}
				
				@Override
				public int getCount() {
					// TODO Auto-generated method stub
					return arrayX.size();
				}
			};
	    lv1.setAdapter(adapterX);
	    setListViewHeightBasedOnChildren(lv1);
        BaseAdapter adapterT = new BaseAdapter() {
	        
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				
				View view = getLayoutInflater().inflate(R.layout.tiankong, null);
				final TextView fillBlank_question = (TextView) view.findViewById(R.id.fillBlank_question);
				final TextView fillBlank_answer=(TextView) view.findViewById(R.id.fillBlank_answer);
			    final EditText fillBlank_write=(EditText)view.findViewById(R.id.write);
				fillBlank_question.setText(arrayT.get(position));
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
				return arrayT.get(position);
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return arrayT.size();
			}
		};
        lv2.setAdapter(adapterT);
        setListViewHeightBasedOnChildren(lv2);
	}
	public void checkChoose(ListView mListView)
	{
		int grade = 0;
		for(int i=0;i<mListView.getChildCount();i++)
		{
			View view=mListView.getChildAt(i);
			TextView storage=(TextView)view.findViewById(R.id.storage);
			ansX[i]=(String) storage.getText();
			if(ansX[i].equals(corectX[i]))grade+=2;
		}
        	tv4.setText("您的分数是："+grade);
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
