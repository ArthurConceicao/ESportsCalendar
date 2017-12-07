package br.gov.to.sefaz.apps.esportscalendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Arthur on 16/11/2017.
 */

public class TimeDAO extends SQLiteOpenHelper {

    String[] scriptCriaBanco =
            {"create table time (_id integer primary key autoincrement, nome text not null, cdgTime text not null);"};

    public final String scriptApagaBD = "DROP TABLE IF EXISTS time";

    Context vrContexto = null;

    TimeDAO(Context contexto, String nome, int versao){
        super(contexto, nome, null, versao);
        vrContexto = contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (int iIndex = 0; iIndex < scriptCriaBanco.length; iIndex++){
            db.execSQL(scriptCriaBanco[iIndex]);
        }
    }

    //CRIACAO
    public void insereTime(ContentValues dados){
        SQLiteDatabase bancoDados = this.getWritableDatabase();

        bancoDados.insert("time", null, dados);

        Toast.makeText(vrContexto, "Insercao realizada", Toast.LENGTH_SHORT).show();
    }

    //EDICAO
    public void editaTime(ContentValues dados){
        SQLiteDatabase bancoDados = this.getWritableDatabase();

        bancoDados.update("time", dados, "cdgTime="+dados.getAsString("cdgTime"), null);

        Toast.makeText(vrContexto, "Edicao realizada", Toast.LENGTH_SHORT).show();
    }

    //REMOÇÃO
    public void removeTime(String cdgTime){
        SQLiteDatabase bancoDados = this.getWritableDatabase();

        bancoDados.delete("time", "cdgTime=?", new String[]{cdgTime});

        Toast.makeText(vrContexto, "Remocao realizada", Toast.LENGTH_SHORT).show();
    }

    //CONSULTA
    public ArrayList<String> listaTimes(){
        ArrayList<String> lista = new ArrayList<String>();
        SQLiteDatabase bancoDados = this.getReadableDatabase();
        Cursor cursor = bancoDados.query("time", new String[]{"nome", "cdgTime"},
                null, null, null, null, null);

        while(cursor.moveToNext()){
            lista.add(cursor.getString(0) + " " + cursor.getString(1));
        }
        return lista;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(scriptApagaBD);
    }
}
