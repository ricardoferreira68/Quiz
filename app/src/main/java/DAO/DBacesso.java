package DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBacesso extends SQLiteOpenHelper {
    private static final String nomeBanco = "usuario.db";
    private static final int versao = 1;

    public DBacesso(@Nullable Context context) {
        super(context, nomeBanco, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sentencaSql = "CREATE TABLE IF NOT EXISTS usuario(" +
                                "id INTERGER PRIMARY KEY, " +
                                "email TEXT UNIQUE, " +
                                "nome TEXT, " +
                                "senha TEXT);";
        sqLiteDatabase.execSQL(sentencaSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
