package br.gov.to.sefaz.apps.esportscalendar;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaNovoTime extends AppCompatActivity {

    EditText etTime = null;
    EditText etCdgTime = null;
    Button inserir, cancelar = null;
    TimeDAO banco = new TimeDAO(this, "bancoESports", 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_novo_time);

        etTime = (EditText)findViewById(R.id.editText);
        etCdgTime = (EditText)findViewById(R.id.editText2);
        inserir = (Button)findViewById(R.id.button7);
        cancelar = (Button)findViewById(R.id.button7);
    }

    public void insereNovoTime(View v){
        ContentValues cv = new ContentValues();
        cv.put("nome", etTime.getText().toString());
        cv.put("cdgTime", etCdgTime.getText().toString());
        banco.insereTime(cv);

        Intent intent = new Intent(getApplicationContext(), TelaInicial.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

        Intent intent2 = new Intent(getApplicationContext(), TelaTimes.class);
        startActivity(intent2);
    }

    public void cancela(View v){
        finish();
    }
}
