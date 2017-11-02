package com.example.nikkoekasaputra.kalkulatorfaroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Detail extends Activity {

	String sNama, sJK, sHarta, sHutang, sPengurusan, sWasiat, sTotal,
			sAnakLakilaki, sAnakPerempuan, sSuami, sIstri, sAyah,
			sIbu, sKakek, sNenek, sSaudaraKandung, sSaudariKandung;

	protected Cursor cursor;
	DataHelper dbHelper;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		dbHelper = new DataHelper(this);

		SQLiteDatabase db = dbHelper.getReadableDatabase();
		cursor = db.rawQuery("select * from data_pewaris, data_ahli_waris where data_pewaris.nama_pewaris = data_ahli_waris.nama_pewaris AND data_pewaris.nama_pewaris = '"+getIntent().getStringExtra("nama_pewaris")+"'", null);
		cursor.moveToFirst();
		if(cursor.getCount()>0){
			cursor.moveToPosition(0);
			sNama = cursor.getString(0).toString();
			sJK = cursor.getString(1).toString();
			sHarta = cursor.getString(2).toString();
			sHutang = cursor.getString(3).toString();
			sPengurusan = cursor.getString(4).toString();
			sWasiat = cursor.getString(5).toString();
			sTotal = cursor.getString(6).toString();
			sAnakLakilaki = cursor.getString(8).toString();
			sAnakPerempuan = cursor.getString(9).toString();
			sSuami = cursor.getString(10).toString();
			sIstri = cursor.getString(11).toString();
			sAyah = cursor.getString(12).toString();
			sIbu = cursor.getString(13).toString();
			sKakek = cursor.getString(14).toString();
			sNenek = cursor.getString(15).toString();
			sSaudaraKandung = cursor.getString(16).toString();
			sSaudariKandung = cursor.getString(17).toString();
		}

		//default jika data ahli waris bernilai 0, maka tidak ditampilkan	
		//awal state	
		if (sAnakLakilaki.equals("Rp. 0")) {
			LinearLayout GAnakLakilaki = (LinearLayout) findViewById(R.id.GAnakLakilaki);
			GAnakLakilaki.setVisibility(View.GONE);
		}

		if (sAnakPerempuan.equals("Rp. 0")) {
			LinearLayout GAnakPerempuan = (LinearLayout) findViewById(R.id.GAnakPerempuan);
			GAnakPerempuan.setVisibility(View.GONE);
		}

		if (sSuami.equals("Rp. 0")) {
			LinearLayout GSuami = (LinearLayout) findViewById(R.id.GSuami);
			GSuami.setVisibility(View.GONE);
		}

		if (sIstri.equals("Rp. 0")) {
			LinearLayout GIstri = (LinearLayout) findViewById(R.id.GIstri);
			GIstri.setVisibility(View.GONE);
		}

		if (sAyah.equals("Rp. 0")) {
			LinearLayout GAyah = (LinearLayout) findViewById(R.id.GAyah);
			GAyah.setVisibility(View.GONE);
		}

		if (sIbu.equals("Rp. 0")) {
			LinearLayout GIbu = (LinearLayout) findViewById(R.id.GIbu);
			GIbu.setVisibility(View.GONE);
		}

		if (sKakek.equals("Rp. 0")) {
			LinearLayout GKakek = (LinearLayout) findViewById(R.id.GKakek);
			GKakek.setVisibility(View.GONE);
		}

		if (sNenek.equals("Rp. 0")) {
			LinearLayout GNenek = (LinearLayout) findViewById(R.id.GNenek);
			GNenek.setVisibility(View.GONE);
		}

		if (sSaudaraKandung.equals("Rp. 0")) {
			LinearLayout GSaudaraKandung = (LinearLayout) findViewById(R.id.GSaudaraKandung);
			GSaudaraKandung.setVisibility(View.GONE);
		}

		if (sSaudariKandung.equals("Rp. 0")) {
			LinearLayout GSaudariKandung = (LinearLayout) findViewById(R.id.GSaudariKandung);
			GSaudariKandung.setVisibility(View.GONE);
		}
		
		//akhir state

		// ---------------------------
		TextView tvNama = (TextView) findViewById(R.id.showNama);
		TextView tvJK = (TextView) findViewById(R.id.showJK);
		TextView tvHarta = (TextView) findViewById(R.id.RpJumlah);
		TextView tvHutang = (TextView) findViewById(R.id.RpHutang);
		TextView tvPengurusanJenazah = (TextView) findViewById(R.id.RpPengurusanJenazah);
		TextView tvWasiat = (TextView) findViewById(R.id.RpWasiat);
		TextView tvJumlah = (TextView) findViewById(R.id.RpTotal);
		
		TextView AnakLakilaki1 = (TextView) findViewById(R.id.AnakLakilaki1);
		TextView AnakPerempuan1 = (TextView) findViewById(R.id.AnakPerempuan1);

		TextView Suami1 = (TextView) findViewById(R.id.Suami1);
		TextView Istri1 = (TextView) findViewById(R.id.Istri1);

		TextView Ayah1 = (TextView) findViewById(R.id.Ayah1);
		TextView Ibu1 = (TextView) findViewById(R.id.Ibu1);
		
		TextView Kakek1 = (TextView) findViewById(R.id.Kakek1);
		TextView Nenek1 = (TextView) findViewById(R.id.Nenek1);
		
		TextView SaudaraKandung1 = (TextView) findViewById(R.id.SaudaraKandung1);
		TextView SaudariKandung1 = (TextView) findViewById(R.id.SaudariKandung1);

		//memasukkan nilai ke textview
		tvNama.setText(sNama);
		tvJK.setText(sJK);
		tvHarta.setText(sHarta);
		tvHutang.setText(sHutang);
		tvPengurusanJenazah.setText(sPengurusan);
		tvWasiat.setText(sWasiat);
		tvJumlah.setText(sTotal);

		AnakLakilaki1.setText(sAnakLakilaki);
		AnakPerempuan1.setText(sAnakPerempuan);

		Suami1.setText(sSuami);
		Istri1.setText(sIstri);

		Ayah1.setText(sAyah);
		Ibu1.setText(sIbu);

		Kakek1.setText(sKakek);
		Nenek1.setText(sNenek);

		SaudaraKandung1.setText(sSaudaraKandung);
		SaudariKandung1.setText(sSaudariKandung);

		ImageButton btnback = (ImageButton) findViewById(R.id.back);
		btnback.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	private int harta(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
}
