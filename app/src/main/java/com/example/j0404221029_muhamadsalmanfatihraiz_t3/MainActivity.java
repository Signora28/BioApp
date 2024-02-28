package com.example.j0404221029_muhamadsalmanfatihraiz_t3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSimpan = findViewById(R.id.btSimpan);
        EditText etNama = findViewById(R.id.etNama);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        RadioButton rbPria = findViewById(R.id.rbPria);
        Spinner spAgama = findViewById(R.id.spAgama);
        CheckBox cbOlahraga = findViewById(R.id.cbOlahraga);
        CheckBox cbMenyanyi = findViewById(R.id.cbMenyanyi);
        CheckBox cbMembacaBuku = findViewById(R.id.cbMembacaBuku);

        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNama.getText().toString().equals("") || etEmail.getText().toString().equals("") || etPassword.getText().toString().equals("")){
                    if (etNama.getText().toString().equals("")) {
                        etNama.setError("Nama harus diisi");
                    }

                    if (etEmail.getText().toString().equals("")) {
                        etEmail.setError("Email harus diisi");
                    }

                    if (etPassword.getText().toString().equals("")) {
                        etPassword.setError("Password harus diisi");
                    }

                } else {
                    Intent intent = new Intent(MainActivity.this, DataActivity.class);

                    intent.putExtra("nama", etNama.getText().toString());
                    intent.putExtra("email", etEmail.getText().toString());
                    intent.putExtra("password", etPassword.getText().toString());

                    String jeniskelamin = rbPria.isChecked() == true ? "Pria" : "Wanita";

                    intent.putExtra("jeniskelamin", jeniskelamin);
                    intent.putExtra("agama", spAgama.getSelectedItem().toString());

                    String hobi = "";

                    if (cbOlahraga.isChecked() == true) {
                        hobi = hobi + cbOlahraga.getText().toString() + ", ";
                    }

                    if (cbMenyanyi.isChecked() == true) {
                        hobi = hobi + cbMenyanyi.getText().toString() + ", ";
                    }

                    if (cbMembacaBuku.isChecked() == true) {
                        hobi = hobi + cbMembacaBuku.getText().toString() + ", ";
                    }

                    if (hobi.length() > 0) {
                        hobi = hobi.substring(0, hobi.length() - 2);
                    } else {
                        hobi = "-";
                    }

                    intent.putExtra("hobi", hobi);
                    Toast.makeText(getApplicationContext(), "Data dikirim", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        });
    }
}