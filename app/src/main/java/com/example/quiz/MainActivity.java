package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final String txtDisciplina = "LINGUAGEM DE MONTAGEM";
    // private final EditText txtTextoBase = (EditText) findViewById(R.id.idTextoBase);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(txtDisciplina);
    }
}