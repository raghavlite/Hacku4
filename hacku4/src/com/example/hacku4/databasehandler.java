package com.example.hacku4;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class databasehandler extends SQLiteOpenHelper{

	public static final int DATABASE_VERSION=2;
	
	public static final String DATABASE_NAME="service_manager152";
	
	public static final String TABLENAME="service_table152";
	
	
	
	
	public static final String KEY_ID="_id";
	public static final String KEY_NAME="name1";
	public static final String KEY_CODE="code1";
	public static final String KEY_URL="url1";
	public static final String KEY_VALUES="values1";
	public static final String KEY_WANTEDV="wantedv1";
	//created a database
	public databasehandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	
	
	//now we must create a table in the database
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLENAME + "("
				+ KEY_ID + " INTEGER PRIMARY KEY,"+KEY_NAME+" TEXT," + KEY_CODE + " TEXT,"
				+ KEY_URL + " TEXT,"+KEY_VALUES+" TEXT,"+KEY_WANTEDV+" TEXT,"+"balues"+" TEXT"+");";
		
		
		db.execSQL(CREATE_CONTACTS_TABLE);
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	
		
		db.execSQL("DROP TABLE IF EXISTS " + TABLENAME);

		// Create tables again
		onCreate(db);
		
		
	}
	
	
	//add service
	
public	void addservice(Service1 sr)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		
		cv.put(KEY_NAME, sr.getName());
		cv.put(KEY_CODE, sr.getCode());
		cv.put(KEY_URL, sr.getUrl());
		cv.put(KEY_VALUES, sr.getValues());
		cv.put(KEY_WANTEDV, sr.getWantedv());
		cv.put("balues", sr.getType());
		
		//cv.put("balue", "yeah");
		
		db.insert(TABLENAME, null, cv);
		db.close();
	

    }
	
	//get a single service
public	Service1 getservice(int id)
	{
		SQLiteDatabase db=this.getReadableDatabase();
		
	Cursor cr=db.query(TABLENAME,new String[] {KEY_ID,KEY_NAME,KEY_CODE,KEY_URL,KEY_VALUES,KEY_WANTEDV,"balues"}, KEY_ID+"=?", new String[] {String.valueOf(id)}, null, null, null);
		if(cr!=null)
		{
			cr.moveToFirst();
		}
	                                                                                                                                              
		Service1 sr=new Service1(
				cr.getString(cr.getColumnIndex(KEY_NAME)),
				cr.getString(cr.getColumnIndex(KEY_CODE)),
				cr.getString(cr.getColumnIndex(KEY_URL)),
				cr.getString(cr.getColumnIndex(KEY_VALUES)),
				cr.getString(cr.getColumnIndex(KEY_WANTEDV)),cr.getString(cr.getColumnIndex("balues")));
	
		sr.putId(cr.getInt(cr.getColumnIndex(KEY_ID)));
		
		db.close();
		
		return sr;
		
		
	}
	







	
	public ArrayList<Service1> getallservices()
	{
		ArrayList<Service1> lst=new ArrayList<Service1>(); 
		Service1 sr;
		
		SQLiteDatabase db=this.getReadableDatabase();
		
		Cursor cr=db.query(TABLENAME, new String[] {KEY_ID,KEY_NAME,KEY_CODE,KEY_URL,KEY_VALUES,KEY_WANTEDV,"balues"},
				null, null, null, null, null);
		
		
		
		if(cr.moveToFirst())
		{
			
			do
			{	
			 sr=new Service1(cr.getString(1),
					cr.getString(2), cr.getString(3),cr.getString(4),cr.getString(5),cr.getString(6));
			
			 sr.putId(Integer.parseInt(cr.getString(0)));
			 
			lst.add(sr);
		}
			while(cr.moveToNext());
			
			
			
			
			
			
		}
	//	return lst;
		
		
		
		db.close();
		return lst;
	
	}
	
	
	
  public  boolean upgradeservice(int id,Service1 sr)
	{
	  
	  SQLiteDatabase db=this.getWritableDatabase();
	  
	  ContentValues cv=new ContentValues();
	  cv.put(KEY_NAME, sr.getName());
	  cv.put(KEY_CODE, sr.getCode());
	  cv.put(KEY_URL, sr.getUrl());
	  cv.put(KEY_VALUES, sr.getValues());
	  cv.put(KEY_WANTEDV, sr.getWantedv());
	  cv.put("balues", sr.getType());
	 if( db.update(TABLENAME, cv,KEY_ID+"=?",new String[]{String.valueOf(id)})>0)
		 
		 {
		 
		  db.close();	 
		 
		 
		 return true;}
	  
	 else
	 {
		 db.close();
		 return false;
		 
		 
	 }
	  
	  
	  

	  
	 
	  
	  
		//return false;
	}
	
  
  
  public void deleteservice(int id)
  {
	  SQLiteDatabase db=this.getWritableDatabase();
	  
	  db.delete(TABLENAME, KEY_ID+"=?",new String[]{String.valueOf(id)});
	  db.close();
	  
  }
  
  public void deleteall()
  {
	  SQLiteDatabase db=this.getWritableDatabase();
	  
	  db.delete(TABLENAME, null, null);
	  
	  
	  db.close();
	  
	  
	  
  }
  
  public int getcount()
  {
	  
	  SQLiteDatabase db=this.getReadableDatabase();
	  
	 Cursor cr= db.query(TABLENAME, null, null, null, null, null, null);
	  
	  db.close();
	  
	  
	  return cr.getCount();
  }
  
  
}