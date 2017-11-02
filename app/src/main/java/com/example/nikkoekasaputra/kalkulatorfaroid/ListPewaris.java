package com.example.nikkoekasaputra.kalkulatorfaroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class ListPewaris extends Activity{
	String[] daftar;
	ListView ListView1;
	Menu menu;
	protected Cursor cursor;
	DataHelper dbcenter;
	public static ListPewaris lp;

	@Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pewaris);

        Button btn = (Button) findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent p = new Intent(ListPewaris.this, Pewaris.class);
        		startActivity(p);
        	}
        });

		lp = this;
        dbcenter = new DataHelper(this);
        RefreshList();

		ImageButton btnback = (ImageButton) findViewById(R.id.back);
		btnback.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
    }

    public void RefreshList(){
    	SQLiteDatabase db = dbcenter.getReadableDatabase();
    	cursor = db.rawQuery("SELECT * FROM data_pewaris", null);
    	daftar = new String[cursor.getCount()];
    	cursor.moveToFirst();
    	for(int i=0;i<cursor.getCount();i++){
    		cursor.moveToPosition(i);
    		daftar[i] = cursor.getString(0).toString();
    	}
    	ListView1 = (ListView) findViewById(R.id.listView1);
    	ListView1.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
    	ListView1.setSelected(true);
    	ListView1.setOnItemClickListener(new OnItemClickListener(){

    		public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3){
    			final String selection = daftar[arg2];
    			final CharSequence[] dialogitem = {"Lihat Data", "Hapus Data"};
    			AlertDialog.Builder builder = new AlertDialog.Builder(ListPewaris.this);
    			builder.setTitle("Pilihan");
    			builder.setItems(dialogitem, new DialogInterface.OnClickListener(){
    				public void onClick(DialogInterface dialog, int item){
    					switch(item){
    						case 0 : {
    							Intent i = new Intent(getApplicationContext(), Detail.class);
    							i.putExtra("nama_pewaris", selection);
    							startActivity(i);
    							break;
    						}
    						case 1 : {
    							SQLiteDatabase db = dbcenter.getWritableDatabase();
    							db.execSQL("DELETE FROM data_pewaris where nama_pewaris = '"+selection+"'");
    							RefreshList();
    							break;
    						}
    					}
    				}
    			});
    			builder.create().show();
    		}
    	});
    	((ArrayAdapter) ListView1.getAdapter()).notifyDataSetInvalidated();
    }

}
