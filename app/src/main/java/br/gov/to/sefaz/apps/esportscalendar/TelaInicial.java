package br.gov.to.sefaz.apps.esportscalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
    }

    public void irTelaTimes(View v){
        Intent intent = new Intent(this, TelaTimes.class);
        startActivity(intent);
    }
}
