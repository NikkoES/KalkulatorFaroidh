package com.example.nikkoekasaputra.kalkulatorfaroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Pewaris extends Activity {
	EditText nama, jumlahHarta, jumlahUtang, jumlahUrus, jumlahWasiat;
	int harta, utang, urus, wasiat;
	String jk;
	RadioGroup jenisKelamin;
	RadioButton perempuan, laki;
	protected Cursor cursor;
	DataHelper dbHelper;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pewaris);

		dbHelper = new DataHelper(this);

		Button selesai = (Button) findViewById(R.id.selesaiHitung);

		nama = (EditText) findViewById(R.id.eTNama);
		jenisKelamin = (RadioGroup) findViewById(R.id.jkGroup);
		perempuan = (RadioButton) findViewById(R.id.rbPerempuan);
		laki = (RadioButton) findViewById(R.id.rbLakiLaki);

		jumlahHarta = (EditText) findViewById(R.id.eTJumlahHarta);
		jumlahUtang = (EditText) findViewById(R.id.eTJumlahHutang);
		jumlahUrus = (EditText) findViewById(R.id.eTJumlahPengurusuanJenazah);
		jumlahWasiat = (EditText) findViewById(R.id.eTJumlahWasiat);

		selesai.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

                //convert nama ke string
                String sNama = nama.getText().toString();

				//memilih jenis kelamin pewaris
				if (laki.isChecked()) {
					jk = "Laki-laki";
				}
				else if (perempuan.isChecked()) {
					jk = "Perempuan";
				}

				//default jika harta tidak diisi
				if (nama.getText().toString().equals("") || jumlahHarta.getText().toString().equals("")) {
					nama.setHint("Wajib diisi !");
					jumlahHarta.setHint("Wajib diisi !");
					nama.setText("");
					jumlahHarta.setText("");
					nama.setHintTextColor(Color.RED);
					jumlahHarta.setHintTextColor(Color.RED);
				}
				//jika harta diisi
				else {
					String sHarta = jumlahHarta.getText().toString();
					if (sHarta.equals("")) {
						sHarta = "0";
					}
					
					String sUtang = jumlahUtang.getText().toString();
					if (sUtang.equals("")) {
						sUtang = "0";
					}
					
					String sUrus = jumlahUrus.getText().toString();
					if (sUrus.equals("")) {
						sUrus= "0";
					}
					
					String sWasiat = jumlahWasiat.getText().toString();
					if (sWasiat.equals("")) {
						sWasiat = "0";
					}					
					
					//merubah nilai menjadi integer (parsing)
					harta = Integer.parseInt(sHarta);
					utang = Integer.parseInt(sUtang);
					urus = Integer.parseInt(sUrus);
					wasiat = Integer.parseInt(sWasiat);
					
					if ((wasiat < (harta / 3)) && (harta<=2000000000)) {
						Intent i = new Intent(Pewaris.this, AhliWaris.class);

						//mengirim data ke kelas ahli waris (mempersiapkan)
                        i.putExtra("terima0", (sNama));
						i.putExtra("terima1", jk);
						i.putExtra("terima2", (sHarta));
						i.putExtra("terima3", (sUtang));
						i.putExtra("terima4", (sUrus));
						i.putExtra("terima5", (sWasiat));

						startActivity(i);
						finish();
					}
					else if (wasiat > (harta / 3)) {
						jumlahWasiat.setHintTextColor(Color.RED);
						jumlahWasiat.setHint("Wasiat lebih besar dari 1/3 harta");

					}
					else if (harta > 2000000000) {
						jumlahHarta.setHintTextColor(Color.RED);
						jumlahHarta.setHint("Harta lebih dari 10 digit");

					}
				}

			}

		});

		ImageButton btnback = (ImageButton) findViewById(R.id.back);
		btnback.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}
}
