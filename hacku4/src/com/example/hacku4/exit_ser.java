package com.example.hacku4;

import java.util.ArrayList;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class exit_ser extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		final databasehandler dbh=new databasehandler(getApplicationContext());
		
		
		final ArrayList<Service1> asr=dbh.getallservices();
		setContentView(R.layout.exist_ser);
		
		
		final ListView lv=(ListView)findViewById(R.id.lv_ser);
		
		
		lv.setAdapter(new list_adaptar(getApplicationContext(), asr));
		
		
		
	lv.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View layv, int pos,
				long arg3) {
			// TODO Auto-generated method stub
			
			
			Intent mn=new Intent(getApplicationContext(), new_ser.class);
			
			mn.putExtra("update", true);
            mn.putExtra("pos", pos);
			
          //  finish();
            
            startActivity(mn);
			
			//lv.invalidateViews();
			//onCreate(savedInstanceState);
		}
	
	
	});
		
		
	lv.setOnItemLongClickListener(new OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
				int pos, long arg3) {
			// TODO Auto-generated method stub
			
			
			
			
			
			
TextView tv=(TextView)arg1.findViewById(R.id.exi_ser_id);
			
			String rv=tv.getText().toString();
			
			
			Log.d("service deleated is  ",asr.get(pos).getCode());
			
			asr.remove(pos);
			
			Log.d("RAGHAV", "datbno "+rv+"lv no "+pos);
			
			
			dbh.deleteservice(Integer.parseInt(rv));
			
			finish();
			Intent in=new Intent(getApplicationContext(), exit_ser.class);
			startActivity(in);
			
			Intent in1=new Intent(getApplicationContext(), ManagerService.class);
			stopService(in);
			
			Intent in2 =new Intent(getApplicationContext(), ManagerService.class);
			in2.putExtra("switchon", true);
			startService(in2);
			
			
			
			
			
			
			
			
			return false;
		}
	})	;
		
		
	
	
	}

	
	
	
	
	
	
}
