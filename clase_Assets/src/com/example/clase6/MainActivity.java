package com.example.clase6;


import com.ceti.clase6.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btn = (Button)findViewById(R.id.button2);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,ActivtyAssets.class);
				startActivity(intent);
				
			}
		});
	}
	
	
	
	public void menuBoton(View button){
		
		
		PopupMenu pm = new PopupMenu(this, button);
		pm.getMenuInflater().inflate(R.menu.configuracion_menu, pm.getMenu());
		pm.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				
				Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
				return false;
			}
		});	
		
		pm.show();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		  case R.id.menu_settings:
			  Toast.makeText(this, "setting", Toast.LENGTH_LONG).show();
			  return true; 
		  default: 
			  return super.onOptionsItemSelected(item);	 		
		}		
		// TODO Auto-generated method stub
	}

}
