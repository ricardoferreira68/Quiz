package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private final String txtDisciplina = "LINGUAGEM DE MONTAGEM";
    private final String[] alterantivas = new String[] {
            "Saída 0, porque o circuito demonstra a falta de fluxo de energia para a saída C.",
            "A saída C será energizada (saída 1).",
            "Saída 1, porque a saída C só será zero quando a entrada A for 0 e a entrada B for 0.",
            "A saída C ficará sem energia (saída 0)."};
    ListView lvAlternativas = (ListView) findViewById(R.id.idListaAlternativas);
    ArrayAdapter<String> adpListaAnternativas = new ArrayAdapter<>(this, R.layout.lista_anternativas, alterantivas);
    // private final EditText txtTextoBase = (EditText) findViewById(R.id.idTextoBase);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(txtDisciplina);

        lvAlternativas.setAdapter(adpListaAnternativas);
    }
}