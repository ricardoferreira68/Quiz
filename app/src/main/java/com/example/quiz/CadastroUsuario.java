package com.example.quiz;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import DAO.DBacesso;
import DAO.Usuario;

public class CadastroUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        EditText edtNome = findViewById(R.id.idEditNome);
        EditText edtEmail = findViewById(R.id.idEditEmail);
        EditText edtSenha = findViewById(R.id.idEditSenha);
        EditText edtSenha2 = findViewById(R.id.idEditSenha2);
        Button btnSalvar = findViewById(R.id.idBtnSalvarUsuario);
        Button btnCancelar = findViewById(R.id.idBtnCancelarUsuario);
        DBacesso db = new DBacesso(this);
        Usuario usuario = new Usuario();

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = edtNome.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String senha = edtSenha.getText().toString().trim();
                String senha2 = edtSenha2.getText().toString().trim();

                if(nome.equals("")){
                    Toast.makeText(getApplicationContext(), "Digite o nome!", Toast.LENGTH_SHORT).show();
                }else{
                    if(email.equals("")){
                        Toast.makeText(getApplicationContext(), "Digite o e-mail!", Toast.LENGTH_SHORT).show();
                    }else{
                        if(senha.equals("")){
                            Toast.makeText(getApplicationContext(), "Digite a senha!", Toast.LENGTH_SHORT).show();
                        }else{
                            if(senha2.equals("")){
                                Toast.makeText(getApplicationContext(), "Repita a senha!", Toast.LENGTH_SHORT).show();
                            }else{
                                if (!senha.equals(senha2)){
                                    Toast.makeText(getApplicationContext(), "Senhas diferentes!", Toast.LENGTH_SHORT).show();
                                }else {
                                    Cursor cursor = db.consultarUsuario(email);
                                    if (cursor.getCount()>0){
                                        Toast.makeText(getApplicationContext(), "e-mail já cadastrado!", Toast.LENGTH_SHORT).show();
                                    }else{
                                        usuario.setEmail(email);
                                        usuario.setNome(nome);
                                        usuario.setSenha(senha);
                                        db.inserirUsuario(usuario);
                                        Toast.makeText(getApplicationContext(), "Cadastrado!", Toast.LENGTH_LONG).show();
                                        finish();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}