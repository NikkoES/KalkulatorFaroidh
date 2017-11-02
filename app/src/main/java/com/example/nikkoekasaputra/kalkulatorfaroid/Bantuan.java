package com.example.nikkoekasaputra.kalkulatorfaroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Bantuan extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);

		TextView ban1 = (TextView) findViewById(R.id.textViewBantuan1);
		TextView ban2 = (TextView) findViewById(R.id.textViewBantuan2);
		TextView ban3 = (TextView) findViewById(R.id.textViewBantuan3);
		TextView ban4 = (TextView) findViewById(R.id.textViewBantuan4);
		TextView ban5 = (TextView) findViewById(R.id.textViewBantuan5);
		TextView ban6 = (TextView) findViewById(R.id.textViewBantuan6);

		ban1.setText("Dalam aplikasi ini terdiri dari 5 menu utama, yaitu Faroidh/Mawaris, Contoh Kasus, Kalkulator, Bantuan, dan Tentang Aplikasi.");
		ban2.setText("Menu ini berisi penjelasan dari Ilmu Faroidh secara jelas dan lengkap. Baik itu definisi, syarat, rukun, tata cara, masalah dan yang lainnya.");
		ban3.setText("Setelah di menu sebelumnya disajikan penjelasan materi, maka pada menu ini terdapat banyak contoh pengaplikasian ilmu faroidh beserta jenis masalahnya.");
		ban4.setText("Menu ini berfungsi untuk menghitung secara otomatis harta warisan. Berikut adalah tata cara menggunakannya :\n" +
				"\t1. Jika belum ada Data Pewaris tekan tombol Tambah Pewaris\n" +
				"\t2. Jika ingin Melihat Detail Data Dewaris tekan data tertentu, maka akan muncul detail Data Pewaris tertentu\n" +
				"\t3. Jika ingin Menghapus Data Pewaris tekan data tertentu selama 2 detik, maka akan muncul pilihan Hapus\n" +
				"\t4. Masukkan Identitas Pewaris yang terdiri dari Nama dan Jenis Kelamin\n" +
				"\t5. Masukkan Harta Pewaris yang terdiri dari Jumlah Harta dan Kewajiban Pewaris\n" +
				"\t6. Jika data sudah benar, tekan Selanjutnya\n" +
				"\t7. Masukkan jumlah pada masing-masing Ahli waris jika ada (jika tidak ada lewati)\n" +
				"\t8. Jika data sudah benar, tekan Selesai\n" +
				"\t9. Sistem akan melakukan perhitungan secara otomatis\n" +
				"\t10. Jika ada ahli waris yang terhalang maka akan ditampilkan pada Keterangan");
		ban5.setText("Pada menu ini disajikan detail dan tata cara menggunakan aplikasi ini.");
		ban6.setText("Menu ini berisi tentang pembuat dan tujuan dibuatnya aplikasi ini.");

		ImageButton btnback = (ImageButton) findViewById(R.id.back);
		btnback.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
    }
}
