package com.medscript.asthmastair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText emailId, password;
    private Button _btnLogin;
    private Spinner _spinner;
    private FirebaseAuth mfirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        mfirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id._textUser);
        password = findViewById(R.id._textPass);
        //_spinner = findViewById(R.id.spinner);
        _btnLogin = findViewById(R.id._btnLogin);

//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.usertype, R.layout.support_simple_spinner_dropdown_item);
//        _spinner.setAdapter(adapter);

        mAuthStateListener = firebaseAuth -> {
            //String item = _spinner.getSelectedItem().toString();
            FirebaseUser mFirebaseUser = mfirebaseAuth.getCurrentUser();
            if (mFirebaseUser != null) {
                startActivity(new Intent(LoginActivity.this, Doctor.class));
//                if (item.equals("Doutor")) {
//                    Toast.makeText(MainActivity.this, "Bem vindo Doutor!", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(MainActivity.this, Doctor.class));
//                }
//                if (item.equals("Paciente")) {
//                    Toast.makeText(MainActivity.this, "Bem vindo!", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(MainActivity.this, Patiente.class));
//                }
            } else {
                Toast.makeText(LoginActivity.this, "Digite novamente!", Toast.LENGTH_SHORT).show();
            }
        };

        _btnLogin.setOnClickListener(v -> {
            String item = _spinner.getSelectedItem().toString();
            String email = emailId.getText().toString();
            String pwd = password.getText().toString();
            if (email.isEmpty()) {
                emailId.setError("Por favor introduzir um e-mail válido");
                emailId.requestFocus();
            } else if (pwd.isEmpty()) {
                password.setError("Por favor introduzir uma palavra-passe");
                password.requestFocus();
            } else if (email.isEmpty() && pwd.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Campos vazios!", Toast.LENGTH_SHORT).show();
            } else if (!(email.isEmpty() && pwd.isEmpty())) {
                mfirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(LoginActivity.this, task -> {
                    if (!task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Erro no login, tente novamente", Toast.LENGTH_SHORT).show();
                    } else {

                        startActivity(new Intent(LoginActivity.this, Doctor.class));
//                        if (item.equals("Doutor")){
//                            Toast.makeText(LoginActivity.this, "Bem vindo Doutor!", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(LoginActivity.this, Doctor.class));
//                        }
//                        if (item.equals("Paciente")){
//                            Toast.makeText(LoginActivity.this, "Bem vindo!", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(LoginActivity.this, Patiente.class));
//                        }
                    }
                });
            } else {
                Toast.makeText(LoginActivity.this, "Ocorreu um erro !", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        mfirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

}