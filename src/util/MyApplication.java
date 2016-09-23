package util;


import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

public class MyApplication extends Application{
	private DBHelper dbHelper;
	private SQLiteDatabase db;

	@Override
	public void onCreate() {
		dbHelper = new DBHelper(getApplicationContext(), "table.db4", 1);
		db=dbHelper.getReadableDatabase();
		super.onCreate();
	}

	public SQLiteDatabase getDB() {

		return db;
	}

	@Override
	public void onTerminate() {
		dbHelper.close();
		super.onTerminate();
	}
}