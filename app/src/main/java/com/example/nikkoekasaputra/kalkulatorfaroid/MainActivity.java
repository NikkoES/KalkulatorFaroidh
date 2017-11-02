package com.example.nikkoekasaputra.kalkulatorfaroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button faraidh = (Button) findViewById(R.id.button1);
		Button contoh = (Button) findViewById(R.id.button2);
		Button perhitungan = (Button) findViewById(R.id.button3);
		Button bantuan = (Button) findViewById(R.id.button4);
		Button about = (Button) findViewById(R.id.button5);

		faraidh.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent f = new Intent(MainActivity.this, Faraidh.class);
				startActivity(f);
			}
		});

		contoh.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent c = new Intent(MainActivity.this, ContohKasus.class);
				startActivity(c);
			}

		});

		perhitungan.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, ListPewaris.class);
				startActivity(i);
			}

		});

		bantuan.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent b = new Intent(MainActivity.this, Bantuan.class);
				startActivity(b);
			}

		});

		about.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent a = new Intent(MainActivity.this, About.class);
				startActivity(a);
			}

		});

	}

}