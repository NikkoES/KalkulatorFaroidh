package com.example.nikkoekasaputra.kalkulatorfaroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class About extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		
		TextView tentang = (TextView) findViewById(R.id.textViewAbout);
		tentang.setText("Aplikasi Kalkulator Faroidh dibuat untuk mempelajari tentang Ilmu Faroidh dan menghitung secara otomatis pembagian harta warisan dalam Islam. ");

		ImageButton btnback = (ImageButton) findViewById(R.id.back);
		btnback.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}

}