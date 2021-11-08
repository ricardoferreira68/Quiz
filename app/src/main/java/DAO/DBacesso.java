package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBacesso extends SQLiteOpenHelper {
    private static final String nomeBanco = "base_de_dados.db";
    private static final int versao = 1;

    public DBacesso(@Nullable Context context) {
        super(context, nomeBanco, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
         String sentencaSql = "CREATE TABLE IF NOT EXISTS usuario(email TEXT PRIMARY KEY, nome TEXT, senha TEXT);";
        sqLiteDatabase.execSQL(sentencaSql);

        sentencaSql = "INSERT INTO usuario VALUES('ferreira.jose@estacio.br', 'Ricardo Ferreira', '123456');";
        sqLiteDatabase.execSQL(sentencaSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    // Inserir registro na tabela (INSERT)
    public void inserirUsuario(Usuario usuario){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("nome", usuario.getNome());
        dados.put("email", usuario.getEmail());
        dados.put("senha", usuario.getSenha());
        db.insert("usuario",null, dados);
    }

    // Consultar usuário.
    public Cursor consultarUsuario(String email){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM usuario WHERE email=?", new String[]{email});
    }
}
