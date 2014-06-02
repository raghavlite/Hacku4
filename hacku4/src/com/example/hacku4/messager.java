package com.example.hacku4;



import java.util.ArrayList;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class messager extends BroadcastReceiver{

	private String str1;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		 Context mContext = context;
         Bundle bundle=intent.getExtras();
         String phoneno,str;
         SmsMessage[] msgs = null;
         ArrayList<Service1> ae=ManagerService.ar;
         
         
		int j;
		if((Object[]) bundle.get("pdus")!=null){
			
    		
    		if(PreferenceManager.getDefaultSharedPreferences(mContext).getBoolean("u", true)==true)
    		{
    		
    		Object[] pdus = (Object[]) bundle.get("pdus");
			msgs = new SmsMessage[pdus.length];  
			//Toast.makeText(mContext, "mmmmmmmmmmmm", Toast.LENGTH_SHORT).show();
			 Intent in=new Intent(context, ManagerService.class);
			
			
			for (int i=0; i<msgs.length; i++){
		
				msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);                
				str1 = msgs[i].getOriginatingAddress();  
				phoneno=msgs[i].getOriginatingAddress();
                
				str=msgs[i].getMessageBody().toString();
				
				//abortBroadcast();
				
				if(ManagerService.a==1)
				{
				
				
					for(j=0;j<(ae.size());j++)
					{
						if(str.startsWith("SENDMAIL"))
						{
							in.putExtra("msg", str);
							in.putExtra("serv_no", -1);
							in.putExtra("sender", str1);
							context.startService(in);
						
							abortBroadcast();
							break;
						
						}
						
						
						
						if(str.startsWith(ae.get(j).getCode()))
						{
							Log.d("RECEIVER", str+"    "+ae.get(j).getCode()+ "  "+j);
							
							in.putExtra("serv_no", j);
							in.putExtra("sender", str1);
							in.putExtra("msg", str);
							context.startService(in);			
							abortBroadcast();
							break;
						}
						
					}
					
			   
				
			//	in.putExtra("msg", str);
				
				
				
				
				
				}
				
			}
    	
    	}
    	
    	}		
		
		
		
		
		
	}
	
	
	
	
	
	

}
