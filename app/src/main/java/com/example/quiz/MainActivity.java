package com.example.quiz;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private View lastSelectedItem;
    private final int respostaCorreta = 1;
    private int alternativaEscolhida = 2;
    private final String txtDisciplina = "LINGUAGEM DE MONTAGEM";
    String[] alterantivas = new String[]{
            "A) Saída 0, porque o circuito demonstra a falta de fluxo de energia para a saída C.",
            "B) A saída C será energizada (saída 1).",
            "C) Saída 1, porque a saída C só será zero quando a entrada A for 0 e a entrada B for 0.",
            "D) A saída C ficará sem energia (saída 0)."};
    // private final EditText txtTextoBase = (EditText) findViewById(R.id.idTextoBase);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(txtDisciplina);
        Button btnVoltar = findViewById(R.id.idBtnVoltar);
        Button btnResponder = findViewById(R.id.idBtnResponder);
        btnResponder.setEnabled(false);
        Button btnProxima = findViewById(R.id.idBtnSeguir);
        btnProxima.setEnabled(false);
        TextView tvTextoBase = findViewById(R.id.idTextoBase);
        tvTextoBase.setFocusableInTouchMode(true);
        ListView lvAlternativas = findViewById(R.id.idListaAlternativas);
        ArrayAdapter<String> adpListaAnternativas = new ArrayAdapter<>(this, R.layout.lista_anternativas, alterantivas);

        lvAlternativas.setAdapter(adpListaAnternativas);


        lvAlternativas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (lastSelectedItem != null) {
                    lastSelectedItem.setBackgroundColor(Color.TRANSPARENT);
                }
                view.setBackgroundColor(getResources().getColor(R.color.black));
                lastSelectedItem = view;
                btnResponder.setEnabled(true);
                alternativaEscolhida = i;

            }
        });


        btnResponder.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                btnResponder.setEnabled(false);
                btnProxima.setEnabled(true);
                if (alternativaEscolhida == respostaCorreta){
                    lastSelectedItem.setBackgroundColor(getResources().getColor(R.color.verde_opaco));
                } else {
                    lastSelectedItem.setBackgroundColor(getResources().getColor(R.color.vermelho_coral));
                }
            }
        });


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
