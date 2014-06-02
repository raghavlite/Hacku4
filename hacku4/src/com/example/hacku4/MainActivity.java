package com.example.hacku4;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.devspark.sidenavigation.ISideNavigationCallback;
import com.devspark.sidenavigation.SideNavigationView;
import com.devspark.sidenavigation.SideNavigationView.Mode;
import com.example.hacku21.BaseInflaterAdapter;
import com.example.hacku21.CardInflater;
import com.example.hacku21.CardItemData;





import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;



























public class MainActivity extends SherlockActivity implements ISideNavigationCallback {

    public static final String EXTRA_TITLE = "com.devspark.sidenavigation.sample.extra.MTGOBJECT";
    public static final String EXTRA_RESOURCE_ID = "com.devspark.sidenavigation.sample.extra.RESOURCE_ID";
    public static final String EXTRA_MODE = "com.devspark.sidenavigation.sample.extra.MODE";

    private ImageView icon;
    private SideNavigationView sideNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        
        
        Intent in2 =new Intent(getApplicationContext(), ManagerService.class);
		in2.putExtra("switchon", true);
		startService(in2);
        
		
		
		
		

		ListView list = (ListView)findViewById(R.id.list_view);

		list.addHeaderView(new View(this));
		list.addFooterView(new View(this));

		BaseInflaterAdapter<CardItemData> adapter = new BaseInflaterAdapter<CardItemData>(new CardInflater());
		for (int i = 0; i < 50; i++)
		{
			CardItemData data = new CardItemData("Item " + i + " Line 1", "Item " + i + " Line 2", "Item " + i + " Line 3");
			adapter.addItem(data, false);
		}

		list.setAdapter(adapter);
		
		
		
		
		
		
		
        
        icon = (ImageView) findViewById(android.R.id.icon);
        sideNavigationView = (SideNavigationView) findViewById(R.id.side_navigation_view);
        sideNavigationView.setMenuItems(R.menu.side_navigation_menu);
        sideNavigationView.setMenuClickCallback(this);
        sideNavigationView.setMode(Mode.LEFT);

//        if (getIntent().hasExtra(EXTRA_TITLE)) {
//            String title = getIntent().getStringExtra(EXTRA_TITLE);
//            int resId = getIntent().getIntExtra(EXTRA_RESOURCE_ID, 0);
//            setTitle(title);
//            icon.setImageResource(resId);
//            sideNavigationView.setMode(getIntent().getIntExtra(EXTRA_MODE, 0) == 0 ? Mode.LEFT : Mode.RIGHT);
//        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getSupportMenuInflater().inflate(R.menu.main_menu, menu);
//        if (sideNavigationView.getMode() == Mode.RIGHT) {
//            menu.findItem(R.id.mode_right).setChecked(true);
//        } else {
//            menu.findItem(R.id.mode_left).setChecked(true);
//        }
//        return super.onCreateOptionsMenu(menu);
//    }

    
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                sideNavigationView.toggleMenu();
                break;
          
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
    
    

    @Override
    public void onSideNavigationItemClick(int itemId) {
        switch (itemId) {
            case R.id.side_navigation_menu_item1:
               // invokeActivity(getString(R.string.title1), R.drawable.ic_android1);
                
            	sideNavigationView.toggleMenu();
            	break;

            case R.id.side_navigation_menu_item2:
               // invokeActivity(getString(R.string.title2), R.drawable.ic_android2);
        		Intent in2=new Intent(getApplicationContext(), exit_ser.class);
    			startActivity(in2);
            	
            	
            	break;

            case R.id.side_navigation_menu_item3:
                //invokeActivity(getString(R.string.title3), R.drawable.ic_android3);
               
    			Intent in=new Intent(getApplicationContext(), new_ser.class);
    			
    			startActivity(in);
            	
            	break;

            case R.id.side_navigation_menu_item4:
               // invokeActivity(getString(R.string.title4), R.drawable.ic_android4);
                break;

            case R.id.side_navigation_menu_item5:
               // invokeActivity(getString(R.string.title5), R.drawable.ic_android5);
                break;

            default:
                return;
        }
        //finish();
    }

    @Override
    public void onBackPressed() {
        // hide menu if it shown
        if (sideNavigationView.isShown()) {
            sideNavigationView.hideMenu();
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Start activity from SideNavigation.
     * 
     * @param title title of Activity
     * @param resId resource if of background image
     */
    private void invokeActivity(String title, int resId) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_TITLE, title);
        intent.putExtra(EXTRA_RESOURCE_ID, resId);
        intent.putExtra(EXTRA_MODE, sideNavigationView.getMode() == Mode.LEFT ? 0 : 1);

        // all of the other activities on top of it will be closed and this
        // Intent will be delivered to the (now on top) old activity as a
        // new Intent.
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);
        // no animation of transition
        overridePendingTransition(0, 0);
    }

}

















































//
//
//public class MainActivity extends Activity implements ISideNavigationCallback {
//
//	
//	private SideNavigationView sideNavigationView;
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.initial);
//		
//		
//		 
//	        sideNavigationView = (SideNavigationView) findViewById(R.id.side_navigation_view);
//	        sideNavigationView.setMenuItems(R.menu.side_navigation_menu);
//	        sideNavigationView.setMenuClickCallback(this);
//	        sideNavigationView.setMode(Mode.LEFT);
//
//		
//		
//		
//	
//	Button btn,btn1,btn2,btn3,btn4,btn5;
//	
//	Intent in=new Intent(this, ManagerService.class);
//	in.putExtra("switchon", true);
//	
//	startService(in);
//	
//	
//	//btn5=(Button)findViewById(R.id.button5);
//	
//	
//	
//	btn1=(Button)findViewById(R.id.button1);
//	btn2=(Button)findViewById(R.id.button2);
//	btn3=(Button)findViewById(R.id.button3);
//	//btn4=(Button)findViewById(R.id.button4);
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	btn3.setOnClickListener(new OnClickListener() {
//		
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//		
//			
//			Intent inm=new Intent(getApplicationContext(), ManagerService.class);
//			
//			stopService(inm);
//			
//			inm.putExtra("switchon", true);
//			startService(inm);
//			
//			
//		}
//	});
//	
//	
//	
//	
//	
//	
//	btn1.setOnClickListener(new OnClickListener() {
//		
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			
//			Intent in=new Intent(getApplicationContext(), new_ser.class);
//			
//			startActivity(in);
//		}
//	});
//	
//	
//	
//	btn2.setOnClickListener(new OnClickListener() {
//		
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//		
//			Intent in2=new Intent(getApplicationContext(), exit_ser.class);
//			startActivity(in2);
//			
//			
//			
//		}
//	});
//	
//	
//	
//	
//	
//	}
//	
//	
//	
//	
//	@Override
//	protected void onStart() {
//		// TODO Auto-generated method stub
//		super.onStart();
//	
//	Intent ijk=new Intent(getApplicationContext(), ManagerService.class);
//	
//	stopService(ijk);
//	ijk.putExtra("switchon", true);
//	startService(ijk);
//	
//	
//	
//	}
//	
//	
//
//@Override
//protected void onDestroy() {
//	// TODO Auto-generated method stub
//	super.onDestroy();
//
//Intent in=new Intent(getApplicationContext(), ManagerService.class);
//
//stopService(in);
//
//
//
//}
//	
//	
//	
//	
//	
//	
//	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//
//
//
//	@Override
//	public void onSideNavigationItemClick(int itemId) {
//		// TODO Auto-generated method stub
//		switch (itemId) {
//        case R.id.side_navigation_menu_item1:
//            
//            break;
//
//        case R.id.side_navigation_menu_item2:
//            
//    		Intent in2=new Intent(getApplicationContext(), exit_ser.class);
//			startActivity(in2);
//			
//			
//			
//        	
//
//            break;
//
//        case R.id.side_navigation_menu_item3:
//
//			Intent in=new Intent(getApplicationContext(), new_ser.class);
//			
//			startActivity(in);
//            break;
//
//        case R.id.side_navigation_menu_item4:
//        	
//Intent inm=new Intent(getApplicationContext(), ManagerService.class);
//			
//			stopService(inm);
//			
//			inm.putExtra("switchon", true);
//			startService(inm);
//        	
//            
//            break;
//
//        case R.id.side_navigation_menu_item5:
//            
//            break;
//
//        default:
//            return;
//    }
//    finish();
//		
//		
//		
//		
//	}
//
//}





//
//
//
//
//
//
//
//
//<?xml version="1.0" encoding="utf-8"?>
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
//    android:layout_width="match_parent"
//    android:layout_height="match_parent" >
//
//    
//        
//    <Button
//        android:id="@+id/button2"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content"
//        android:layout_above="@+id/button3"
//        android:layout_alignLeft="@+id/imager"
//        android:text="DELETE/UPDATE EXISTING SERVICES" />
//
//    <Button
//        android:id="@+id/button1"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content"
//        android:layout_above="@+id/button2"
//        android:layout_alignLeft="@+id/imager"
//        android:text="CREATE NEW SERVICE" />
//
//    <Button
//        android:id="@+id/button3"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content"
//        android:layout_alignLeft="@+id/imager"
//        android:layout_alignParentBottom="true"
//        android:layout_marginBottom="18dp"
//        android:text="REFRESH" />
//
//    <ImageView
//        android:id="@+id/imager"
//        android:layout_width="wrap_content"
//        android:layout_height="wrap_content"
//        android:layout_alignParentTop="true"
//        android:layout_centerHorizontal="true"
//        android:src="@drawable/raghavbb" />
//    
//
//    <com.devspark.sidenavigation.SideNavigationView
//        android:id="@+id/side_navigation_view"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent" />
//
//</RelativeLayout>






