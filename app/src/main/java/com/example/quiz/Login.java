package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tvEmail = findViewById(R.id.idTxtLoginEmail);
        TextView tvSenha = findViewById(R.id.idSenha);
        Button btnEntrar = findViewById(R.id.idBtnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = tvEmail.getText().toString();
                String senha = tvSenha.getText().toString();
                if (email.equals("")){
                    Toast.makeText(getApplicationContext(), "Digite o e-mail", Toast.LENGTH_SHORT).show();
                }else {
                    if (senha.equals("")) {
                        Toast.makeText(getApplicationContext(), "Digite a senha.", Toast.LENGTH_SHORT).show();
                    } else {

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}