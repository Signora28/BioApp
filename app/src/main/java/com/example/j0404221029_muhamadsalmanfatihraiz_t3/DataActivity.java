package com.example.j0404221029_muhamadsalmanfatihraiz_t3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Intent intent = this.getIntent();

        TextView tvNama = findViewById(R.id.tvNama);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvPassword = findViewById(R.id.tvPassword);
        TextView tvJenisKelamin = findViewById(R.id.tvJenisKelamin);
        TextView tvAgama = findViewById(R.id.tvAgama);
        TextView tvHobi = findViewById(R.id.tvHobi);

        tvNama.setText(intent.getStringExtra("nama"));
        tvEmail.setText(intent.getStringExtra("email"));
        tvPassword.setText(intent.getStringExtra("password"));
        tvJenisKelamin.setText(intent.getStringExtra("jeniskelamin"));
        tvAgama.setText(intent.getStringExtra("agama"));
        tvHobi.setText(intent.getStringExtra("hobi"));
    }
}