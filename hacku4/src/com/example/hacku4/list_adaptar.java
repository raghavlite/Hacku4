package com.example.hacku4;

import java.util.ArrayList;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class list_adaptar extends BaseAdapter {

	
	int no;
	Context cntxt;
	ArrayList<Service1> asr;
	
	public list_adaptar(Context cntxt,ArrayList<Service1> asr) {
		// TODO Auto-generated constructor stub

	
	this.cntxt=cntxt;
	this.asr=asr;
	
	
	
	}
	
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return asr.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int pos, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		//
		
		
		
		

		
		
		LayoutInflater inflater = (LayoutInflater) cntxt
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (arg1 == null) {

			gridView = new View(cntxt);

			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.ser_splaser, null);

			// set value into textview
			TextView textView = (TextView) gridView
					.findViewById(R.id.exi_ser_name);
			textView.setText(String.valueOf(asr.get(pos).getName()));

			// set image based on selected text
			TextView textView2 = (TextView) gridView
					.findViewById(R.id.exi_ser_code);

			textView2.setText(asr.get(pos).getCode());
			
			
			TextView tv3=(TextView)gridView.findViewById(R.id.exi_ser_id);
			
			tv3.setText(String.valueOf(asr.get(pos).getId()));
			
	        //TextView textView3=(TextView)gridView.findViewById(R.id.e);
		
					
		
		} 
		
		
		else {
			gridView = (View) arg1;
		}

		return gridView;

	}

}
