package com.example.hacku4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class new_ser extends Activity {

	//protected static final String srv = null;
	public int as=0;
	Service1 srv;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);

    setContentView(R.layout.m1);
    as=0;
    
    
    
    
    final Context cntxt;
    final EditText ser_name;
	final EditText ser_url, ser_code, ser_values,ser_wantedv,ser_type;
    Button btn;

 cntxt=getApplicationContext();
    
    ser_name=(EditText)findViewById(R.id.ser_name);
     ser_url = (EditText)findViewById(R.id.ser_url);
    ser_code=(EditText)findViewById(R.id.ser_key);
    ser_values=(EditText)findViewById(R.id.ser_values);
    ser_wantedv=(EditText)findViewById(R.id.ser_wantedv);
    ser_type=(EditText)findViewById(R.id.ser_type);
   
    
    Intent inw=getIntent();
    if(inw.getBooleanExtra("update", false))
    {as=1;
    	
    	
    	srv=ManagerService.ar.get(inw.getIntExtra("pos", 0));
    	
    	
    	ser_name.setText(srv.getName());
    	ser_url.setText(srv.getUrl());
    	ser_code.setText(srv.getCode());
    	ser_values.setText(srv.getValues());
    	ser_wantedv.setText(srv.getWantedv());
    	ser_type.setText(srv.getType());
    	
    	
    	
    	
    	
    }
    else
    {
    	as=0;
    	
    }
   
    
    
    
    
    btn=(Button)findViewById(R.id.btn_create_se);
    
    
    btn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
	          
			databasehandler dbh=new databasehandler(cntxt);
			//SharedPreferences sp=getSharedPreferences("id_sp",MODE_PRIVATE );
			//Editor et=sp.edit();
		//	int a=sp.getInt("_id", -1);
			Service1 sr;
			
			
			
			sr=new Service1(ser_name.getText().toString(), ser_code.getText().toString(),
					ser_url.getText().toString(),
					ser_values.getText().toString(),
					ser_wantedv.getText().toString(),ser_type.getText().toString());
			
		Log.d("editt", ser_wantedv.getText().toString());	
			
			
		if(as==0)
		{
			dbh.addservice(sr);
		}
		else
		{
		    dbh.upgradeservice(srv.getId(), sr);	
		}
		
		
		Intent imk=new Intent(getApplicationContext(), MainActivity.class);
		finish();
		//startActivity(imk);
		Toast.makeText(getApplicationContext(), "added to database", Toast.LENGTH_SHORT).show();
		
		}
	});
    
    
    
    





}







}
