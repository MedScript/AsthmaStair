package com.medscript.asthmastair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText _textUser, _textPass;
    private Button _btnLogin;
    private Spinner _spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //_textUser = findViewById(R.id.);
        //_textPass = findViewById(R.id.);
        //_btnLogin = findViewById(R.id.);
        //_spinner = findViewById(R.id.);

        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.usertype, R.layout.support_simple_spinner_dropdown_item);
        _spinner.setAdapter(adapter);

        _btnLogin.setOnClickListener(v -> {
            String item = _spinner.getSelectedItem().toString();
            if (item.equals("Doutor")){
                Intent docIntent = new Intent(MainActivity.this, Doctor.class);
                startActivity(docIntent);

            } else if (item.equals("Paciente")){
                Intent patienteIntent = new Intent(MainActivity.this, Patiente.class);
                startActivity(patienteIntent);
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}