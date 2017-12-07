package br.gov.to.sefaz.apps.esportscalendar;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaEditaTime extends AppCompatActivity {

    TextView tvTime = null;
    EditText etTime = null;
    Button salvar, cancelar = null;
    TimeDAO banco = new TimeDAO(this, "bancoESports", 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_edita_time);

        tvTime = (TextView)findViewById(R.id.textView10);
        etTime = (EditText)findViewById(R.id.editText3);
        salvar = (Button)findViewById(R.id.button6);
        cancelar = (Button)findViewById(R.id.button7);

        tvTime.setText(getIntent().getExtras().getString("nome") + " - " + getIntent().getExtras().getString("cdgTime"));
    }

    public void salvaEdicao(View v){
        ContentValues cv = new ContentValues();
        cv.put("nome", etTime.getText().toString());
        cv.put("cdgTime", getIntent().getExtras().getString("cdgTime"));
        banco.editaTime(cv);
        finish();;
    }

    public void cancela(View v){
        finish();
    }
}
