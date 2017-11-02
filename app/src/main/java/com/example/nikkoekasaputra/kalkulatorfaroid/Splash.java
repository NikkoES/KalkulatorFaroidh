package com.example.nikkoekasaputra.kalkulatorfaroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		final int welcomeScreenDisplay = 3000;

		Thread welcomeThread = new Thread() { //maksudnya syntax ini apa yaa ??

			int wait = 50;
			 
			@Override
			public void run() {
				try {
					super.run();
					while (wait < welcomeScreenDisplay) {
						sleep(100);
						wait += 100;
					}
				}
				catch (Exception e) {
					System.out.println("EXc=" + e);
				} 
				finally {
					startActivity(new Intent(Splash.this, MainActivity.class));
					finish();
				}
			}
		}; //sampe sini ??
		welcomeThread.start();

	}
	
}
