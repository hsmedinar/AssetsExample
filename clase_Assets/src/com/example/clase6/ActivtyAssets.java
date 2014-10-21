package com.example.clase6;

import java.io.IOException;
import java.io.InputStream;

import com.ceti.clase6.R;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivtyAssets extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_assets);
		
		TextView txtContent = (TextView) findViewById(R.id.txtContent);
		TextView txtFileName = (TextView) findViewById(R.id.txtFileName);
		ImageView imgAssets = (ImageView) findViewById(R.id.imgAssets);
		
		Typeface tp = Typeface.createFromAsset(getAssets(), "AnnabelScript.ttf");		
		txtFileName.setTypeface(tp);		
		
		AssetManager assetManager = getAssets();
		

		try {
			String[] files = assetManager.list("Files");
			
			for(int i=0; i<files.length; i++)
			{
				txtFileName.append("\n File :"+i+" Name => "+files[i]);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			Log.e("READFILESASSETS", e1.getMessage());
		}
		
		
        InputStream input;
		try {
			input = assetManager.open("helloworld.txt");
			
	        int size = input.available();
	        byte[] buffer = new byte[size];
	        input.read(buffer);
	        input.close();


	         String text = new String(buffer);
			
	         txtContent.setText(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// To load image
    	try {

	    	InputStream ims = assetManager.open("android_logo_small.jpg");
	    	
	    	Drawable d = Drawable.createFromStream(ims, null);
	    	
	    	imgAssets.setImageDrawable(d);
    	}
    	catch(IOException ex) {
    		return;
    	}
		
	}
}
